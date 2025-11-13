package org.csu.petstore.user.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.petstore.user.entity.SignOn;
import org.springframework.stereotype.Repository;

@Repository
public interface SignOnMapper extends BaseMapper<SignOn> {
}
