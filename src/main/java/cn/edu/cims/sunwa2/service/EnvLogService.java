package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.EnvLog;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/4/7 17:01
 */

public interface EnvLogService {
    List<EnvLog> listAll();
    List<EnvLog> listSelected(String recordTime);
    void save(EnvLog envLog);
}
