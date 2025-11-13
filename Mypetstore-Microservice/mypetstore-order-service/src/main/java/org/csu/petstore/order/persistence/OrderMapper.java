package org.csu.petstore.order.persistence;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.petstore.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {

}
