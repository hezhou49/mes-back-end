package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.WarnningResume;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface WarnningResumeService {
    List<WarnningResume> listAll();
    List<WarnningResume>listSelected(@Param("line") String lineName, @Param("equipmentname") String equipmentname, String startTime, String endTime);
    void save(WarnningResume warnningResume);
}
