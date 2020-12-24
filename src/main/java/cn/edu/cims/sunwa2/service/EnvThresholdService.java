package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.EnvThreshold;

import java.util.List;

/**
 * Created by Wu on 2019/12/11.
 */
public interface EnvThresholdService {
    List<EnvThreshold> listAll();
    void save(EnvThreshold envThreshold);
}
