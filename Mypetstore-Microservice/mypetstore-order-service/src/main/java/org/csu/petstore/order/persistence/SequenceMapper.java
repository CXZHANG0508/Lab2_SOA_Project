package org.csu.petstore.order.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.petstore.order.entity.Sequence;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceMapper extends BaseMapper<Sequence>{

    Sequence getSequence(Sequence sequence);

    void updateSequence(Sequence sequence);
}
