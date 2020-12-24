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
public class Warnning {
    private int id;
    private String lineName;
    private String equipmentName;
    private String warnDetails;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式
    private Date warnTime;
    private String warnState;

    public Warnning() {
    }

    public Warnning(String lineName, String equipmentName, String warnDetails, Date warnTime, String warnState) {
        this.lineName = lineName;
        this.equipmentName = equipmentName;
        this.warnDetails = warnDetails;
        this.warnTime = warnTime;
        this.warnState = warnState;
    }



}
