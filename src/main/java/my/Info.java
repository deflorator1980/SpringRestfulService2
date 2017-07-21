package my;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Info {
    private String gnomeName;
    private BigDecimal gnomeMoney;
    private Map<String, Integer> items;
}