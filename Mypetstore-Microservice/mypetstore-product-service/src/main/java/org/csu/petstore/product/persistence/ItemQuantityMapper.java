package org.csu.petstore.product.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.petstore.product.entity.ItemQuantity;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemQuantityMapper extends BaseMapper<ItemQuantity> {
}
