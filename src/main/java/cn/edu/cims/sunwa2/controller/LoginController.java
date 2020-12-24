package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.aop.MyLog;
import cn.edu.cims.sunwa2.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.fail("请先登录");
    }

    @GetMapping("/keep_login")
    public RespBean keep(){
        return RespBean.ok("ok");
    }

    // 伪接口，方便做日志
    @MyLog(value = "登入系统")
    @GetMapping("/aop_login")
    public RespBean aop_login(){
        return RespBean.ok("ok");
    }

    // 伪接口，方便做日志
    @MyLog(value = "登出系统")
    @GetMapping("/aop_logout")
    public RespBean aop_logout(){
        return RespBean.ok("ok");
    }

}
