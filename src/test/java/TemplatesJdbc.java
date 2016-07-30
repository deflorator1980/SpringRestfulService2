import hello.ApplicationBig;
import hello.TemplatesBig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by a on 29.07.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBig.class)
public class TemplatesJdbc {

    @Autowired TemplatesBig templatesBig;

    @Test
    public void huyack() {
        System.out.println(templatesBig.showValuesGnome("003"));
    }
}
