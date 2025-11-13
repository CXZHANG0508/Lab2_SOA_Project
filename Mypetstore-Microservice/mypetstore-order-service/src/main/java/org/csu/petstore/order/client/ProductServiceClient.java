package org.csu.petstore.order.client;

import org.csu.petstore.order.common.CommonResponse;
import org.csu.petstore.order.vo.ItemVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface ProductServiceClient {

    @GetMapping("/api/catalog/items/{id}")
    CommonResponse<ItemVO> getItem(@PathVariable("id") String itemId);
}