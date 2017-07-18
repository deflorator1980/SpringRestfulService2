package my.controller;


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

import java.util.*;

@RestController
public class ShowController {

    private static final Logger log = LoggerFactory.getLogger(ShowController.class);

    @Autowired
    private GnomeRepository gnomeRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/my-info")
    public ResponseEntity<?> myInfo(){
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item;
        List<Sale> sale = saleRepository.findByGnomeId(gnomeId);
        Info info = new Info();
        info.setGnomeName(gnome.getGnomeName());
        info.setGnomeMoney(gnome.getGnomeMoney());
        Map items = new HashMap();
        for (Sale s : sale) {
            item = itemRepository.findOne(s.getItemId());
            items.put(item.getItemName(), s.getQuantity());
        }
        info.setItems(items);
        return new ResponseEntity<Object>(info, HttpStatus.OK);
    }

    @RequestMapping("/gnome")
    public Gnome gnome() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        return gnomeRepository.findOne(gnomeId);
    }

    @Transactional
    @RequestMapping("/buy")
    public ResponseEntity<?> buy(@RequestParam(value = "item_id") String itemId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String gnomeId = userDetails.getUsername();
        Sale sale;
//        Gnome gnome = gnomeRepository.findOne("003");
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item = itemRepository.findOne(itemId);
        if (gnome.getGnomeMoney().compareTo(item.getItemPrice()) == -1) {
            return new ResponseEntity<>(new Gnome(gnome.getGnomeId(), "NOT ENOUGH MONEY", gnome.getGnomeMoney()), HttpStatus.BAD_REQUEST);
        }
        gnome.setGnomeMoney(gnome.getGnomeMoney().subtract(item.getItemPrice()));
        gnomeRepository.save(gnome);

        Optional<Sale> saleOp = saleRepository.findByGnomeIdAndItemId(gnomeId, item.getItemId());
        if (saleOp.isPresent()) {
            sale = saleOp.get();
            sale.setGnomeId(gnome.getGnomeId());
            int quant = sale.getQuantity();
            sale.setQuantity(++quant);
            saleRepository.save(sale);
            return new ResponseEntity<>(gnome, HttpStatus.OK);
        } else {
            sale = new Sale(gnome.getGnomeId(), item.getItemId(), 1);
        }
        saleRepository.save(sale);
        return new ResponseEntity<>(gnome, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping("/sell")
    public ResponseEntity<?> sell(@RequestParam(value = "item_id") String itemId) {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String gnomeId = "003";
        String gnomeId = userDetails.getUsername();
        Sale sale;
        Gnome gnome = gnomeRepository.findOne(gnomeId);
        Item item = itemRepository.findOne(itemId);
        Optional<Sale> saleOp = saleRepository.findByGnomeIdAndItemId(gnomeId, item.getItemId());
        if (!saleOp.isPresent() || saleOp.get().getQuantity() < 1) {
            return new ResponseEntity<Object>( new Sale("NO SUCH ITEM", item.getItemId(), 0), HttpStatus.BAD_REQUEST);
        }
        sale = saleOp.get();
        gnome.setGnomeMoney(gnome.getGnomeMoney().add(item.getItemPrice()));
        sale.setQuantity(sale.getQuantity() - 1);
        return new ResponseEntity<Object>(gnome, HttpStatus.OK);
    }

    @RequestMapping("/gnomes")
    public List<Gnome> gnomes() {
        List<Gnome> gnomes = new ArrayList<>();
        gnomeRepository.findAll().forEach(gnomes::add);
        return gnomes;
    }

    @RequestMapping("/")
    public ResponseEntity<?> nihil() {
        return new ResponseEntity<Object>(new Gnome("sdfdsf", "dsfsfda", null), HttpStatus.OK);
    }
}
