import hello.ApplicationBig;
import jpa.AppJpa;
import jpa.Gnomes;
import jpa.RepaGnomes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by a on 30.07.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppJpa.class)
public class TemplatesJpa {

    @Autowired
    RepaGnomes repaGnomes;

    @Test
    public void pisda() {
        for (Gnomes g : repaGnomes.findAll()) {
            System.out.println(g);
        }
//        System.out.println(repaGnomes.findOne("003"));

    }

}
