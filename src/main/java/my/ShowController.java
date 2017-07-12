package my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {

    @Autowired
    GnomeRepository gnomeRepository;

    @RequestMapping("/")
    public Gnome g() {
        return new Gnome("001", "Hui", new BigDecimal(10));
    }

    @RequestMapping("/gnome")
    public Gnome gnome() {
        return gnomeRepository.findOne("002");
    }

    @RequestMapping("/gnomes")
    public List<Gnome> gnomes() {
        List<Gnome> gnomes = new ArrayList<>();
//        gnomes.add(new Gnome("001", "One", new BigDecimal(10)));
//        gnomes.add(new Gnome("002", "Two", new BigDecimal(10)));
        gnomeRepository.findAll().forEach(gnomes::add);
        return gnomes;
    }
}
