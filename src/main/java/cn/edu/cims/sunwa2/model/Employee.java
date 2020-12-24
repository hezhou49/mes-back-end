package cn.edu.cims.sunwa2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author hezhou
 * @Date 2020/12/22 20:47
 */
@Getter
@Setter
@ToString
public class Employee {
    private int id;
    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String fullName;
    //部门
    private String department;
    //手机号
    private String phone;
    //角色
    private String role;
    //注册时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")//向前端返回的格式
    private Date regTime;
}
