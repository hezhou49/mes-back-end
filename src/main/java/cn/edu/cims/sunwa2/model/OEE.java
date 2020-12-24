package cn.edu.cims.sunwa2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OEE {

    private int id;

    private String line;

    private String name;

    private String type;

    private double timeoee;

    private double propertyoee;

    private double qualityoee;

    private double alloee;

    private String date;

}
