package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.OperationLog;

import java.util.List;


public interface OperationLogMapper {
    List<OperationLog> listAll();
    void save(OperationLog operationLog);
    List<OperationLog>listSelected(String operator, String startTime, String endTime);
}
