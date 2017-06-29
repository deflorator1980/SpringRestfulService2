package my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by a on 28.06.17.
 */

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sale_id;
//    @OneToOne
//    @JoinColumn(name = "gnome_id")
    private String gnome_id;
//    @OneToOne
//    @JoinColumn(name = "item_id")
    private String item_id;
    private Integer quantity;

//    @OneToOne(mappedBy = "gnome_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "gnome_id")
//    private Gnome gnome;


//    @OneToOne(mappedBy = "gnome_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "item_id")
//    private Item item;


    public Sale() {
    }

    public Sale(String gnome_id, String item_id, Integer quantity) {
        this.gnome_id = gnome_id;
        this.item_id = item_id;
        this.quantity = quantity;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    @OneToOne
    @JoinColumn(name = "gnome_id")
    public String getGnome_id() {
        return gnome_id;
    }

    public void setGnome_id(String gnome_id) {
        this.gnome_id = gnome_id;
    }

    @OneToOne
    @JoinColumn(name = "item_id")
    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "sale_id=" + sale_id +
                ", gnome_id='" + gnome_id + '\'' +
                ", item_id='" + item_id + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
