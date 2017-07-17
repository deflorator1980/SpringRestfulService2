package my;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShowController {

    private static final Logger log = LoggerFactory.getLogger(ShowController.class);


    @Autowired
    GnomeRepository gnomeRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/gnome")
    public Gnome gnome() {
        Gnome gnome = gnomeRepository.findOne("003");
        log.info(gnome.getGnomeMoney().toString());
        return gnome;
    }

    @Transactional
    @RequestMapping("/buy")
    public Gnome buy(@RequestParam(value = "item_id") String item_id) {
        Sale sale;
        Gnome gnome = gnomeRepository.findOne("003");
        Item item = itemRepository.findOne(item_id);
        gnome.setGnomeMoney(gnome.getGnomeMoney().subtract(item.getItemPrice()));
        gnomeRepository.save(gnome);
        log.info(gnome.getGnomeMoney().toString());

//        Sale sale = saleRepository.findOne(1);
//        Sale sale = saleRepository.findByGnomeId("003");
//        Sale sale = saleRepository.findByGnomeIdAndItemId("003", item.getItemId());
        Optional<Sale> saleOp = saleRepository.findByGnomeIdAndItemId("003", item.getItemId());
        if (saleOp.isPresent()) {
            sale = saleOp.get();
            sale.setGnomeId(gnome.getGnomeId());
            int quant = sale.getQuantity();
            sale.setQuantity(++quant);
            saleRepository.save(sale);
            log.info(sale.toString());
            log.info(saleRepository.findAll().toString());
            return gnome;
        } else {
            sale = new Sale(gnome.getGnomeId(), item.getItemId(), 1);
        }
        saleRepository.save(sale);
        log.info(sale.toString());
        log.info(saleRepository.findAll().toString());
        return gnome;
    }

    @RequestMapping("/gnomes")
    public List<Gnome> gnomes() {
        List<Gnome> gnomes = new ArrayList<>();
        gnomeRepository.findAll().forEach(gnomes::add);
        return gnomes;
    }
}
