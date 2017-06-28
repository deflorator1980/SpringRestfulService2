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
            repository.save(new Gnome("001", "vova", new BigDecimal(10)));
            repository.findAll().forEach(System.out::println);
        };
    }
}
