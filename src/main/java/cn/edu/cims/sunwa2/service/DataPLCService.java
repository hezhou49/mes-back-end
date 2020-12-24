package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.DataPLC;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/6/28 18:16
 */
public interface DataPLCService {
    List<DataPLC> findByTag(String tag);
}
