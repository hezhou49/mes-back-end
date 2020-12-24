package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.OperationLog;

import java.util.List;

/**
 * Created by Wu on 2019/12/5.
 */
public interface OperationLogService {
    List<OperationLog> listAll();
    void save(OperationLog operationLog);
    List<OperationLog>listSelected(String operator, String startTime, String endTime);
}
