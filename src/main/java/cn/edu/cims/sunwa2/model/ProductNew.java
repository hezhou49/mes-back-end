package cn.edu.cims.sunwa2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author hezhou
 * @Date 2020/9/16 19:34
 */
@Getter
@Setter
@ToString
public class ProductNew {
    private int id;
    private String orderNum;    //订单号
    private String workpieceNum;    //工件号
    private String lineName;    //加工产线
    private int workTime;
    private String quality;    //工件质量


}
