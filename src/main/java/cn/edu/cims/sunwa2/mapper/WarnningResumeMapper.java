package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.WarnningResume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wu on 2019/12/3.
 */
public  interface WarnningResumeMapper {
     List<WarnningResume> listAll();
     List<WarnningResume>listSelected(@Param("line") String lineName, @Param("equipmentname") String equipmentname, String startTime, String endTime);
     void save(WarnningResume warnningResume);
}
