package my;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gnome {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gnome_name;
    private String gnome_money;

    public Gnome() {
    }

    public Gnome(String gnome_name, String gnome_money) {
        this.gnome_name = gnome_name;
        this.gnome_money = gnome_money;
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "id=" + id +
                ", gnome_name='" + gnome_name + '\'' +
                ", gnome_money='" + gnome_money + '\'' +
                '}';
    }
}
