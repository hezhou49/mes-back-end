package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.Energy;

import java.util.Date;
import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/3/15 9:28
 */
public interface EnergyMapper {
    List<Energy> listAll();
    Energy listMostRecent();
    List<Energy> listSelected(String linename, String date);
    List<String> listDistinct(String column);
    Energy listTop(String column, String time);
    void update(int value, Date date);
    void save(Energy energy);
}
