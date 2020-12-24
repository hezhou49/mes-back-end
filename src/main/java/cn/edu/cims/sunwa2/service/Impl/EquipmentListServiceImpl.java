package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EquipmentListMapper;
import cn.edu.cims.sunwa2.model.EquipmentList;
import cn.edu.cims.sunwa2.service.EquipmentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EquipmentListServiceImpl implements EquipmentListService {
   @Autowired
    private EquipmentListMapper equipmentListMapper;

    @Override
    public List<EquipmentList> listAll() {
        return equipmentListMapper.listAll();
    }

    @Override
    public List<EquipmentList> listSelected(String lineName) {
        return equipmentListMapper.listSelected(lineName);
    }
}
