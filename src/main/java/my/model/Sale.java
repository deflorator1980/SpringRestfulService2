package my.model;

import javax.persistence.*;

/**
 * Created by a on 28.06.17.
 */

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String gnomeId;
    private String itemId;
    private Integer quantity;

    public Sale() {
    }

    public Sale(String gnomeId, String itemId, Integer quantity) {
        this.gnomeId = gnomeId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGnomeId() {
        return gnomeId;
    }

    public void setGnomeId(String gnomeId) {
        this.gnomeId = gnomeId;
    }

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
                "id=" + id +
                ", gnomeId='" + gnomeId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
