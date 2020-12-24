package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.OperationLogMapper;
import cn.edu.cims.sunwa2.model.OperationLog;
import cn.edu.cims.sunwa2.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/5.
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public List<OperationLog> listAll() {
        return operationLogMapper.listAll();
    }

    @Override
    public void save(OperationLog operationLog) {
        operationLogMapper.save(operationLog);
    }

    @Override
    public List<OperationLog> listSelected(String operator, String startTime, String endTime) {
        return operationLogMapper.listSelected(operator, startTime, endTime);
    }
}
