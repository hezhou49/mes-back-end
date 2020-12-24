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
public class QualityWarnning {
   private int id;
   //产线名称
   private String lineName;
   //设备名称
   private String equipmentName;
   //订单号
   private String orderNum;
   //报警类型
   private String warnType;
   //报警时间
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式QualityWarnningMapper
   private Date warnTime;

}
