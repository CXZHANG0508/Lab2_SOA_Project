package org.csu.petstore.product.service.impl;

import org.csu.petstore.product.entity.Log;
import org.csu.petstore.product.persistence.LogMapper;
import org.csu.petstore.product.service.LogService;
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
