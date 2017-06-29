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
    public CommandLineRunner gnomes(GnomeRepository repository) {

        return (args) -> {
            repository.save(new Gnome("001", "vova", new BigDecimal(10)));
            repository.save(new Gnome("002", "dasha", new BigDecimal(1)));
            repository.save(new Gnome("003", "yasha", new BigDecimal(100)));
            repository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner items(ItemRepository repository) {
        return (args) -> {
            repository.save(new Item("01", "sward", new BigDecimal(10)));
            repository.save(new Item("02", "spear", new BigDecimal(4)));
            repository.save(new Item("03", "grenade", new BigDecimal(2)));
            repository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner sales(SaleRepository repository) {
        return (args) -> {
            repository.save(new Sale("001", "01", 1));
            repository.findAll().forEach(System.out::println);
        };
    }
}
