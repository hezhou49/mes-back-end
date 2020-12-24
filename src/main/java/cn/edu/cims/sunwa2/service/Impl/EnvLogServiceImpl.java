package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EnvLogMapper;
import cn.edu.cims.sunwa2.model.EnvLog;
import cn.edu.cims.sunwa2.service.EnvLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/4/7 17:02
 */
@Service
public class EnvLogServiceImpl implements EnvLogService {
    @Autowired
    private EnvLogMapper envLogMapper;
    @Override
    public List<EnvLog> listAll() {
        return envLogMapper.listAll();
    }

    @Override
    public List<EnvLog> listSelected(String recordTime) {
        return envLogMapper.listSelected(recordTime);
    }

    @Override
    public void save(EnvLog envLog) {
        envLogMapper.save(envLog);
    }
}
