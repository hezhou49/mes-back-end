package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.model.SafeWarnning;
import cn.edu.cims.sunwa2.service.SafeWarnningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/safewarnning")
public class SafeWarnningController {
  @Autowired
    private SafeWarnningService safeWarnningService;
  @RequestMapping("/listAll")
    public RespBean listAll(){
      List<SafeWarnning> list = safeWarnningService.listAll();
      //String str = JSON.toJSONString(list);
      return RespBean.ok("ok",list);
  }
    @RequestMapping("/listSelected")
    public RespBean listSelected(String lineName,String time){
        List<SafeWarnning> list = safeWarnningService.listSelected(lineName, time);
        //String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }
}
