package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.EquipmentList;

import java.util.List;


public  interface EquipmentListMapper {
     List<EquipmentList> listAll();
     List<EquipmentList>listSelected(String lineName);
}
