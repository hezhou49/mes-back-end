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
public class WarnningResume {
    private int id;
    private String line;
    private String equipmentname;
    private String warndetails;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式
    private Date warntime;
    private String handlemeasure;
    private String handleperson;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式
    private Date handletime;

//    public WarnningResume() {
//
//    }
//    public WarnningResume(String line, String equipmentname, String warndetails, Date warntime, String handlemeasure, String handleperson, Date handletime) {
//        this.line = line;
//        this.equipmentname = equipmentname;
//        this.warndetails = warndetails;
//        this.warntime = warntime;
//        this.handlemeasure = handlemeasure;
//        this.handleperson = handleperson;
//        this.handletime = handletime;
//    }


}
