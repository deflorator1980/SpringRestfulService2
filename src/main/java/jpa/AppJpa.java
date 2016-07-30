package jpa;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@Slf4j
@SpringBootApplication
public class AppJpa implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AppJpa.class, args);
    }


    @Autowired RepaGnomes repaGnomes;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(repaGnomes.findOne("003"));
        for (Gnomes g : repaGnomes.findAll()){
            System.out.println(g);
        }
        System.out.println("hui");
    }

}