package cn.edu.cims.sunwa2.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class EnvThreshold {
    private int id;
    private String maxTemperature;
    private String minTemperature;
    private String maxHumidity;
    private String minHumidity;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
