package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.EnvLog;
import cn.edu.cims.sunwa2.model.EnvThreshold;
import cn.edu.cims.sunwa2.model.EnvWarnning;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.EnvLogService;
import cn.edu.cims.sunwa2.service.EnvThresholdService;
import cn.edu.cims.sunwa2.service.EnvWarnningService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/env")
public class EnvWarnningController {
   @Autowired
    private EnvWarnningService envWarnningService;
   @Autowired
   private EnvThresholdService envThresholdService;
   @Autowired
   private EnvLogService envLogService;
   @RequestMapping("/listAll")
    public RespBean listAll(){
       List<EnvLog> list = envLogService.listAll();
       return RespBean.ok("ok",list);
   }
   @RequestMapping("/warnning/listAll")
       public RespBean listWarnAll() {
       List<EnvWarnning> list = envWarnningService.listAll();
       //String str = JSON.toJSONString(list);
       return  RespBean.ok("ok",list);
   }
    @RequestMapping("/warnning/listSelected")
    public RespBean listWarnSelected(String type,String time) {
        List<EnvWarnning> list = envWarnningService.listSelected(type, time);
//        String str = JSON.toJSONString(list);
        return  RespBean.ok("ok",list);
    }
    @RequestMapping("/warnning/insert")
    public RespBean insert(String warnResume) {
        System.out.println(warnResume);
        EnvThreshold envThreshold = JSON.parseObject(warnResume, EnvThreshold.class);
        System.out.println(envThreshold.toString());
        envThreshold.setUpdateTime(new Date());
        envThresholdService.save(envThreshold);
        return  RespBean.ok("修改成功");
    }
    @RequestMapping("/warnning//listTop")
    public RespBean listTop() {
           List<EnvThreshold> list = envThresholdService.listAll();
           EnvThreshold envThreshold =list.get(0);
//           String str = JSON.toJSONString(temperature);
        return  RespBean.ok("ok",list);
    }
}

