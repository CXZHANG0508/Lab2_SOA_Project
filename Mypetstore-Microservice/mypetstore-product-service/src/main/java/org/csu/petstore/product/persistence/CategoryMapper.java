package org.csu.petstore.product.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.petstore.product.entity.Category;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryMapper extends BaseMapper<Category> {
}
