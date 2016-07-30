package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by a on 30.07.16.
 */
@Entity
public class Gnomes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String gnome_id;
    private String gnome_name;
    private BigDecimal gnome_money;

    public Gnomes() {
    }

    public Gnomes(String gnome_name, BigDecimal gnome_money) {
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    public Gnomes(String gnome_id, String gnome_name, BigDecimal gnome_money) {
        this.gnome_id = gnome_id;
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    public String getGnome_id() {
        return gnome_id;
    }

    public void setGnome_id(String gnome_id) {
        this.gnome_id = gnome_id;
    }

    public String getGnome_name() {
        return gnome_name;
    }

    public void setGnome_name(String gnome_name) {
        this.gnome_name = gnome_name;
    }

    public BigDecimal getGnome_money() {
        return gnome_money;
    }

    public void setGnome_money(BigDecimal gnome_money) {
        this.gnome_money = gnome_money;
    }

    @Override
    public String toString() {
        return "Gnomes{" +
                "gnome_id='" + gnome_id + '\'' +
                ", gnome_name='" + gnome_name + '\'' +
                ", gnome_money=" + gnome_money +
                '}';
    }
}
