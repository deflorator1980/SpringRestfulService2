package my.model;

import javax.persistence.*;

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
    private Integer saleId;
//    @OneToOne
//    @JoinColumn(name = "gnomeId")
    private String gnomeId;
//    @OneToOne
//    @JoinColumn(name = "itemId")
    private String itemId;
    private Integer quantity;

//    @OneToOne(mappedBy = "gnomeId")
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "gnomeId")
//    private Gnome gnome;


//    @OneToOne(mappedBy = "gnomeId")
//    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
//    @JoinColumn(name = "itemId")
//    private Item item;


    public Sale() {
    }

    public Sale(String gnomeId, String itemId, Integer quantity) {
        this.gnomeId = gnomeId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    @OneToOne
    @JoinColumn(name = "gnome_id")
    public String getGnomeId() {
        return gnomeId;
    }

    public void setGnomeId(String gnomeId) {
        this.gnomeId = gnomeId;
    }

    @OneToOne
    @JoinColumn(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
                "saleId=" + saleId +
                ", gnomeId='" + gnomeId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
