package my.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import my.model.Gnome;
import my.Info;
import my.model.Item;
import my.model.Sale;
import my.repo.GnomeRepository;
import my.repo.ItemRepository;
import my.repo.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class ShowController {

    private static final Logger log = LoggerFactory.getLogger(ShowController.class);

    private List<Item> shopList;


    private final GnomeRepository gnomeRepository;

    private final SaleRepository saleRepository;

    private final ItemRepository itemRepository;

    private boolean shopStatus;

    @Autowired
    public ShowController(GnomeRepository gnomeRepository, SaleRepository saleRepository, ItemRepository itemRepository) throws IOException, SAXException, ParserConfigurationException {
        try {
            shopList = getItemList();
            shopStatus = true;
        } catch (Exception e) {
            log.error(e.getMessage());
            shopStatus = false;
        }
        this.gnomeRepository = gnomeRepository;
        this.saleRepository = saleRepository;
        this.itemRepository = itemRepository;
    }

    private List<Item> getItemList() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        List<Item> itemList = new ArrayList<>();
        String filepaht = "items.xml";
        Document doc = docBuilder.parse(filepaht);
        Node weapons = doc.getElementsByTagName("weapons").item(0);
        NodeList nodelist = weapons.getChildNodes();
        Item item;
        for (int i = 0; i < nodelist.getLength(); i++) {
            Node node = nodelist.item(i);
            if ("weapon".equals(node.getNodeName())) {
                item = new Item();
                item.setId(node.getAttributes().getNamedItem("id").getTextContent());
                item.setName(((Element) node).getElementsByTagName("name").item(0).getTextContent());
                item.setPrice(new BigDecimal(((Element) node).getElementsByTagName("price").item(0).getTextContent()));
                itemList.add(item);
            }
        }
        return itemList;
    }

    @RequestMapping("/view-shop")
    public ResponseEntity<?> viewShop() {
        if (shopStatus) {
            return new ResponseEntity<Object>(shopList, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(new Item("SHOP DOESN'T WORK", null, null), HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = {"/", "/my-info"})
    public ResponseEntity<?> myInfo() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item;
        List<Sale> sale = saleRepository.findByGnomeId(gnomeId);
        Info info = new Info();
        info.setGnomeName(gnome.getName());
        info.setGnomeMoney(gnome.getMoney());
        Map items = new HashMap();
        for (Sale s : sale) {
            item = itemRepository.findOne(s.getItemId());
            items.put(item.getName(), s.getQuantity());
        }
        info.setItems(items);
        return new ResponseEntity<Object>(info, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping("/buy")
    public ResponseEntity<?> buy(@RequestParam(value = "item_id") String itemId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        Sale sale;
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item = itemRepository.findOne(itemId);
        if (gnome.getMoney().compareTo(item.getPrice()) == -1) {
            return new ResponseEntity<>(new Gnome(gnome.getId(), "NOT ENOUGH MONEY", gnome.getMoney()), HttpStatus.BAD_REQUEST);
        }
        gnome.setMoney(gnome.getMoney().subtract(item.getPrice()));
        gnomeRepository.save(gnome);

        Optional<Sale> saleOp = saleRepository.findByGnomeIdAndItemId(gnomeId, item.getId());
        if (saleOp.isPresent()) {
            sale = saleOp.get();
            sale.setGnomeId(gnome.getId());
            int quant = sale.getQuantity();
            sale.setQuantity(++quant);
            saleRepository.save(sale);
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            sale = new Sale(gnome.getId(), item.getId(), 1);
        }
        saleRepository.save(sale);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping("/sell")
    public ResponseEntity<?> sell(@RequestParam(value = "item_id") String itemId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        Sale sale;
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item = itemRepository.findOne(itemId);
        Optional<Sale> saleOp = saleRepository.findByGnomeIdAndItemId(gnomeId, item.getId());
        if (!saleOp.isPresent() || saleOp.get().getQuantity() < 1) {
            return new ResponseEntity<Object>(new Sale("NO SUCH ITEM", item.getId(), 0), HttpStatus.BAD_REQUEST);
        }
        sale = saleOp.get();
        gnome.setMoney(gnome.getMoney().add(item.getPrice()));
        sale.setQuantity(sale.getQuantity() - 1);
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }
}
