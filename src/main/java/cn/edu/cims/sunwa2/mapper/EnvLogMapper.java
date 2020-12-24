package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.EnvLog;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/4/7 16:38
 */
public interface EnvLogMapper {
    List<EnvLog> listAll();
    List<EnvLog> listSelected(String recordTime);
    void save(EnvLog envLog);
}
