package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.OEE;

import java.util.List;

public interface OEEMapper {
    List<OEE> listAll();
    List<String> listDistinct();
    List<OEE> listTop(List<String> list);
    OEE findByDateAndLineAndName(String date, String line, String name);
}
