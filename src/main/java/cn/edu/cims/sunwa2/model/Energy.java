package cn.edu.cims.sunwa2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author hezhou
 * @Date 2020/3/15 9:24
 */
@Getter
@Setter
@ToString
public class Energy {
    private int id;
    private String linename;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//向前端返回的格式
    private Date date;
    private String year;
    private String month;
    private int total_energy;
    private int year_energy;
    private int month_energy;
    private int day_energy;


}
