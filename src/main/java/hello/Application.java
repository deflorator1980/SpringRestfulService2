package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(HuyastomerRepository repository) {
		return (args) -> {
//			// save a couple of customers
//			repository.save(new Huyastomer("Jack", "Bauer"));
//			repository.save(new Huyastomer("Chloe", "O'Brian"));
//			repository.save(new Huyastomer("Kim", "Bauer"));
//			repository.save(new Huyastomer("David", "Palmer"));
//			repository.save(new Huyastomer("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Huyastomer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Huyastomer customer = repository.findOne(5L);
//			log.info("Huyastomer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Huyastomer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Huyastomer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
//            repository.save(new Huyastomer("Jack", "Bauer"));
//            repository.save(new Huyastomer("Chloe", "O'Brian"));
//            repository.save(new Huyastomer("Kim", "Bauer"));
//            repository.save(new Huyastomer("David", "Palmer"));
            repository.save(new Huyastomer("Michelle", "Dessler"));
            repository.findAll().forEach(System.out::println);
		};
	}

}
