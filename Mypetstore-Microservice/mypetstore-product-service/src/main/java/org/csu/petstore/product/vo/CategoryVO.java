package org.csu.petstore.product.vo;

import lombok.Data;
import org.csu.petstore.product.entity.Product;

import java.util.List;

@Data
public class CategoryVO {
    private String categoryId;
    private String categoryName;
    private List<Product> productList;
}
