package org.csu.petstore.product.service;

import org.csu.petstore.product.common.CommonResponse;
import org.csu.petstore.product.vo.CategoryVO;
import org.csu.petstore.product.vo.ItemVO;
import org.csu.petstore.product.vo.ProductVO;
import org.csu.petstore.product.vo.SearchVO;

import java.util.List;

public interface CatalogService {

    CommonResponse<CategoryVO> getCategory(String categoryId);

    CommonResponse<ProductVO> getProduct(String productId);

    CommonResponse<ItemVO> getItem(String itemId);

    CommonResponse<List<SearchVO>> getSearch(String keyword);
}

