package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.EquipmentList;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.EquipmentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/monitor")
public class MonitorController {


   @Autowired
   private EquipmentListService equipmentListService;



   @RequestMapping("/equipmentList")
    public RespBean equipmentList(String lineName){
      List<EquipmentList> list = equipmentListService.listSelected(lineName);
       //String str = JSON.toJSONString(list);
       return  RespBean.ok("ok",list);
   }
    @RequestMapping("/equipmentListAll")
    public RespBean equipmentList(){
        List<EquipmentList> list = equipmentListService.listAll();
        //String str = JSON.toJSONString(list);
        return  RespBean.ok("ok",list);
    }
}
