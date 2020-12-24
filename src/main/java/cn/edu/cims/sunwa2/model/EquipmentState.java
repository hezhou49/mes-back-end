package cn.edu.cims.sunwa2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EquipmentState {
    private int id;
    private String equipmentname;    //设备的状态
    private boolean state;
    //表示机器人的位置
    private String position;

}
