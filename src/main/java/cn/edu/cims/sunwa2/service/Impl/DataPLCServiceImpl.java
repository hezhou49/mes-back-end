package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.DataPLCMapper;
import cn.edu.cims.sunwa2.model.DataPLC;
import cn.edu.cims.sunwa2.service.DataPLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/6/28 18:16
 */
@Service
public class DataPLCServiceImpl implements DataPLCService {
    @Autowired
    DataPLCMapper dataPLCMapper;
    @Override
    public List<DataPLC> findByTag(String tag) {
        return dataPLCMapper.findByTag(tag);
    }
}
