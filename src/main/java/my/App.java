package my;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

/**
 * Created by a on 28.06.17.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner my(GnomeRepository repository) {

        return (args) -> {
//            Gnome gnome = new Gnome("001", "vova", new BigDecimal(10));


//            repository.save(new Huyastomer("Jack", "Bauer"));
//            repository.save(new Huyastomer("Chloe", "O'Brian"));
//            repository.save(new Huyastomer("Kim", "Bauer"));
//            repository.save(new Huyastomer("David", "Palmer"));
//            repository.save(new Huyastomer("Michelle", "Dessler"));
            repository.save(new Gnome("one1", "one2"));
            repository.findAll().forEach(System.out::println);
        };
    }
}
