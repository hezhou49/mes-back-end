package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EnvWarnningMapper;
import cn.edu.cims.sunwa2.model.EnvWarnning;
import cn.edu.cims.sunwa2.service.EnvWarnningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnvWarnningServiceImpl implements EnvWarnningService {
    @Autowired
    private EnvWarnningMapper envWarnningMapper;

    @Override
    public List<EnvWarnning> listAll() {
        return envWarnningMapper.listAll();
    }

    @Override
    public List<EnvWarnning> listSelected(String type, String recordTime) {
        return envWarnningMapper.listSelected(type, recordTime);
    }

    @Override
    public void save(EnvWarnning envWarnning) {
        envWarnningMapper.save(envWarnning);
    }
}
