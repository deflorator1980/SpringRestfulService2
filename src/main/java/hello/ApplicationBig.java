package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class ApplicationBig implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBig.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        jdbcTemplate.execute("CREATE TABLE sales (" +
                "  sale_id  SERIAL PRIMARY KEY," +
                "  gnome_id VARCHAR(45) NOT NULL," +
                "  item_id  VARCHAR(45) NOT NULL," +
                "  quantity INT      NOT NULL" +
                ")");
        jdbcTemplate.execute("CREATE TABLE gnomes (" +
                "  gnome_id    VARCHAR(45) NOT NULL," +
                "  gnome_name  VARCHAR(45) NOT NULL," +
                "  gnome_money NUMERIC(20, 2)," +
                "  CONSTRAINT gnomes_pkey PRIMARY KEY (gnome_id)" +
                ")");
        jdbcTemplate.execute("CREATE TABLE items (" +
                "  item_id    VARCHAR(45) NOT NULL," +
                "  item_name  VARCHAR(45) NOT NULL," +
                "  item_price NUMERIC (20, 2)," +
                "  PRIMARY KEY (item_id)" +
                ")");
        jdbcTemplate.execute("ALTER TABLE sales ADD CONSTRAINT fk_sales_gnomes FOREIGN KEY (gnome_id) REFERENCES gnomes (gnome_id)");
        jdbcTemplate.execute("ALTER TABLE sales ADD CONSTRAINT fk_sales_items FOREIGN KEY (item_id) REFERENCES items (item_id)");
        jdbcTemplate.execute("INSERT INTO gnomes (gnome_id, gnome_name, gnome_money) VALUES ('003', 'yasha', '100')");
        jdbcTemplate.execute("INSERT INTO items (item_id, item_name, item_price) VALUES ('01', 'sword', 10)");
        jdbcTemplate.execute("INSERT INTO items (item_id, item_name, item_price) VALUES ('02', 'spear', 4)");
        jdbcTemplate.execute("INSERT INTO items (item_id, item_name, item_price) VALUES ('03', 'grenade', 2)");
    }
}
