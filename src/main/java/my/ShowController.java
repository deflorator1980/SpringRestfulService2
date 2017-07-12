package my;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {

    private static final Logger log = LoggerFactory.getLogger(ShowController.class);


    @Autowired
    GnomeRepository gnomeRepository;

    @Autowired
    SaleRepository saleRepository;

    @RequestMapping("/gnome")
    public Gnome gnome() {
        Gnome gnome = gnomeRepository.findOne("003");
        log.info(gnome.getGnome_money().toString());
        return gnome;
    }

    @RequestMapping("/buy")
    public Gnome buy() {
        Gnome gnome = gnomeRepository.findOne("003");
        gnome.setGnome_money(new BigDecimal(200));
        gnomeRepository.save(gnome);
        log.info(gnome.getGnome_money().toString());
        Sale sale = saleRepository.findOne(1);
        sale.setGnome_id(gnome.getGnome_id());
        int quant = sale.getQuantity();
        sale.setQuantity(quant+1);
        saleRepository.save(sale);
//        log.info(sale.toString());
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
