package my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Gnome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gnome_id;
    private String gnome_name;
    private String gnome_money;

    public Gnome() {
    }

    public Gnome(String gnome_name, String gnome_money) {
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    public Gnome(Long gnome_id, String gnome_name, String gnome_money) {
        this.gnome_id = gnome_id;
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "gnome_id=" + gnome_id +
                ", gnome_name='" + gnome_name + '\'' +
                ", gnome_money='" + gnome_money + '\'' +
                '}';
    }
}
