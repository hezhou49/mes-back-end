package cn.edu.cims.sunwa2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author hezhou
 * @Date 2020/6/28 18:11
 */
@Getter
@Setter
@ToString
public class DataPLC {
    private int id;
    private String tag;
    private boolean bool;
    private float value;

}
