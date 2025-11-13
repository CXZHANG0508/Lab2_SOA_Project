package org.csu.petstore.product.controller;

import org.csu.petstore.product.common.CommonResponse;
import org.csu.petstore.product.annotation.LogAccount;
import org.csu.petstore.product.service.CatalogService;
import org.csu.petstore.product.vo.CategoryVO;
import org.csu.petstore.product.vo.ItemVO;
import org.csu.petstore.product.vo.ProductVO;
import org.csu.petstore.product.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @LogAccount
    @GetMapping("index")
    public String index(){
        return "catalog/main";
    }

    @LogAccount
    @GetMapping("categories/{id}")
    public CommonResponse<CategoryVO> viewCategory(@PathVariable("id") String categoryId){
        return catalogService.getCategory(categoryId);
    }


    @LogAccount
    @GetMapping("products/{id}")
    public CommonResponse<ProductVO> viewProduct(@PathVariable("id") String productId){
        return catalogService.getProduct(productId);
    }


    @LogAccount
    @GetMapping("items/{id}")
    public CommonResponse<ItemVO> viewItem(@PathVariable("id") String itemId){
        return catalogService.getItem(itemId);
    }


    @LogAccount
    @PostMapping("products/{keyword}")
    public CommonResponse<List<SearchVO>> searchProducts(@PathVariable("keyword") String keyword){
        return catalogService.getSearch(keyword);
    }

}

