package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.SafeWarnning;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wu on 2019/12/11.
 */
public interface SafeWarnningService {
    List<SafeWarnning> listAll();
    List<SafeWarnning>listSelected(@Param("lineName") String lineName, @Param("departure") String departure);
    void save(SafeWarnning safeWarnning);
}
