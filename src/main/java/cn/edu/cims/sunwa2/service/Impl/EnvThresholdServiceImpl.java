package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EnvThresholdMapper;
import cn.edu.cims.sunwa2.model.EnvThreshold;
import cn.edu.cims.sunwa2.service.EnvThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/11.
 */
@Service
public class EnvThresholdServiceImpl implements EnvThresholdService {
    @Autowired
    private EnvThresholdMapper envThresholdMapper;

    @Override
    public List<EnvThreshold> listAll() {
        return envThresholdMapper.listAll();
    }

    @Override
    public void save(EnvThreshold envThreshold) {
        envThresholdMapper.save(envThreshold);
    }
}
