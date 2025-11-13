package org.csu.petstore.product.vo;

import lombok.Data;
import org.csu.petstore.product.entity.Item;

import java.util.List;

@Data
public class ProductVO {

    private String productId;
    private String categoryId;
    private String productName;

    private List<Item> itemList;
}
