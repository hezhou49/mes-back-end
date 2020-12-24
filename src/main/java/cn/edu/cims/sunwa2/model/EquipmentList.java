package cn.edu.cims.sunwa2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//设备清单，对应数据库表equipmentList
@Getter
@Setter
public class EquipmentList {
    private int id;   //id
    private String lineName;  //产线名
    private String equipmentName;  //设备名

}
