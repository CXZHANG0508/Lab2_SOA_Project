package org.csu.petstore.order.service.impl;

import org.csu.petstore.order.entity.Log;
import org.csu.petstore.order.persistence.LogMapper;
import org.csu.petstore.order.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void saveLog(Log Log) {
        logMapper.insert(Log);
    }
}
