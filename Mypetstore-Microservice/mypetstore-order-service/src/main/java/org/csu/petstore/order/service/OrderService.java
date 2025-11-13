package org.csu.petstore.order.service;

import org.csu.petstore.order.common.CommonResponse;
import org.csu.petstore.order.entity.Order;
import org.csu.petstore.order.vo.CartItem;
import org.csu.petstore.order.vo.CartItemListMapper;
import java.util.List;

public interface OrderService {

    // 通过用户名获得订单列表
    CommonResponse<List<Order>> getOrdersByUsername(String username);

    void insertOrder(Order order);

    void finishOrder(Integer orderId, List<CartItem> cartItemList);
}
