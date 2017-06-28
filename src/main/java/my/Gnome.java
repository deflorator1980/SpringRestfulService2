package my;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Gnome {
    @Id
    private String gnome_id;
    private String gnome_name;
    private BigDecimal gnome_money;

    public Gnome() {
    }

    public Gnome(String gnome_name, BigDecimal gnome_money) {
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    public Gnome(String gnome_id, String gnome_name, BigDecimal gnome_money) {
        this.gnome_id = gnome_id;
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "gnome_id='" + gnome_id + '\'' +
                ", gnome_name='" + gnome_name + '\'' +
                ", gnome_money=" + gnome_money +
                '}';
    }
}
