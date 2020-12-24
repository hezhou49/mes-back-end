package cn.edu.cims.sunwa2.mapper;


import cn.edu.cims.sunwa2.model.DataPLC;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/6/28 18:14
 */
public interface DataPLCMapper {
    List<DataPLC> findByTag(String tag);
}
