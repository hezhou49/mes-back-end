package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.Warnning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wu on 2019/12/3.
 */
public interface WarnningService {
    List<Warnning> listAll();
    List<Warnning>listSelected(@Param("lineName") String lineName, @Param("equipmentName") String equipmentName, String startTime, String endTime);
    List<Warnning> unhandled(@Param("warnState") String warnstate);
    void update(@Param("state") String state, @Param("id") int id);
    List<Warnning> fenye(@Param("warnState") String warnstate, int start, int limit);
    //新增报警记录
    void save(Warnning warnning);
    int count(String equipmentName);

}
