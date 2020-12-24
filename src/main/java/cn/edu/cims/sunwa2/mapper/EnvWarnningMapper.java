package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.EnvWarnning;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EnvWarnningMapper {
    List<EnvWarnning> listAll();

    List<EnvWarnning> listSelected(@Param("warnType") String warnType, @Param("recordTime") String recordTime);

    void save(EnvWarnning envWarnning);
}
