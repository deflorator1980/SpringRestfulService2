package my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by a on 28.06.17.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private String itemId;
    private String itemName;
    private BigDecimal itemPrice;
}
