package dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;

@Data
public class ValuesMapBig {
    private String gnome_name;
    private BigDecimal gnome_money;
    private HashMap<String, Integer> items;

 }
