package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.Warnning;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface WarnningMapper {
    List<Warnning> listAll();

    List<Warnning> listSelected(@Param("lineName") String lineName, @Param("equipmentName") String equipmentName, String startTime, String endTime);

    List<Warnning> unhandled(@Param("warnState") String warnstate);

    void update(@Param("state") String state, @Param("id") int id);

    //MyBatis通过RowBounds分页
    List<Warnning> fenye(@Param("warnState") String warnstate, RowBounds rowBounds);

    //新增报警记录
    void save(Warnning warnning);

    int count(String equipmentName);

}
