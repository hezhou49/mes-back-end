package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.EquipmentList;

import java.util.List;


public interface EquipmentListService {
    List<EquipmentList> listAll();
    List<EquipmentList>listSelected(String lineName);
}
