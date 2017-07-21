package my.model;

import javax.persistence.*;

/**
 * Created by a on 28.06.17.
 */

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer saleId;
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

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
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
                "saleId=" + saleId +
                ", gnomeId='" + gnomeId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
