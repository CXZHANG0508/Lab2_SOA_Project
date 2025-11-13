package org.csu.petstore.order.service;


import org.csu.petstore.order.common.CommonResponse;
import org.csu.petstore.order.entity.Cart;
import org.csu.petstore.order.vo.CartItem;
import org.csu.petstore.order.vo.CartItemListMapper;

import java.util.List;

public interface CartService {

    // 通过用户获取数据库表中的购物车
    List<Cart> getCartListByUserId(String userId);

    // 获取购物车内商品
    CommonResponse<List<CartItem>> getCartItemListByUserId(String userId);

    void addItemToCart(String username, String itemId);

    void updateCart(String username, String itemId, int quantity);

    void removeItem(String username, String itemId);

    void clearCart(String username);

    // 通过购物车内商品更新购物车
    void updateCartByCartItemList(List<CartItem> cartItemList, String userid);
}
