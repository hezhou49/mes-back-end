package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.QualityWarnning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityWarnningService {
    List<QualityWarnning> listAll();
    List<QualityWarnning>listSelected(@Param("lineName") String lineName, @Param("orderNum") String orderNum, @Param("warnType") String warnType, @Param("warnTime") String warnTime);
    void save(QualityWarnning qualityWarnning);
}
