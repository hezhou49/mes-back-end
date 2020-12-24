package cn.edu.cims.sunwa2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author hezhou
 * @Date 2020/4/7 16:34
 * 记录每日的平均温度和湿度
 */
@Getter
@Setter
@ToString
public class EnvLog {
    private int id;
    private String AverageTemperature;
    private String AverageHumidity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//向前端返回的格式
    private Date recordTime;


}
