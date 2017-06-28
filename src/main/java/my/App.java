package my;

//import hello.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

/**
 * Created by a on 28.06.17.
 */
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner my(GnomeRepository repository) {

        return (args) -> {
//            Gnome gnome = new Gnome("001", "vova", new BigDecimal(10));

            repository.save(new Gnome("one1", "one2"));

//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
            repository.findAll().forEach(System.out::println);
        };
    }
}
