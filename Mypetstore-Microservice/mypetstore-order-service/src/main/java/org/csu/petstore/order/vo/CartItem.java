package org.csu.petstore.order.vo;

import lombok.Data;
import org.csu.petstore.order.entity.Cart;

import java.math.BigDecimal;

@Data
public class CartItem {
    private ItemVO itemVO;
    private Cart cart;
    private int inStock;
    private BigDecimal total;

}
