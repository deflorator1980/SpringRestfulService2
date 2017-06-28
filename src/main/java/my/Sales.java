package my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by a on 28.06.17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sale_id;
    private String gnome_id;
    private String item_id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "gnome_id")
    private Gnome gnome;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
