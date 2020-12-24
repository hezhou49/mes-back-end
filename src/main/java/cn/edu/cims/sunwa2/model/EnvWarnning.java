package cn.edu.cims.sunwa2.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class EnvWarnning {
    private int id;
    private String recordValue;
    private String warnType;
    private String setMinValue;
    private String setMaxValue;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式
    private Date recordTime;
}
