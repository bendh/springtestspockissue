package nl.benooms.reproduce;

import lombok.Value;

import java.math.BigDecimal;

/**
 * Created by Ben Ooms on 3-8-16.
 */
@Value
public class ProductVO {
    private String description;
    private BigDecimal price;

}
