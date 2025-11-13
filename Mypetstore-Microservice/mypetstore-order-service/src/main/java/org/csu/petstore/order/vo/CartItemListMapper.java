package org.csu.petstore.order.vo;


import lombok.Data;
import org.csu.petstore.order.entity.LineItem;

import java.util.List;

@Data
public class CartItemListMapper {

    private List<CartItem> cartItemList;

}
