package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.Energy;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/3/15 10:11
 */
@RestController
@RequestMapping("/energy")
public class EnergyController {
    @Autowired
    EnergyService energyService;
    @RequestMapping("/listAll")
    public RespBean getEnergyList() {
        List<Energy> list = energyService.listAll();
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listMostRecent")
    public RespBean listMostRecent() {
        Energy energy = energyService.listMostRecent();
        return RespBean.ok("ok",energy);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelectedEnergyList( String lineName, String date) {
        List<Energy> list = energyService.listSelected(lineName, date);
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }
    @RequestMapping("/listTop")
    public RespBean listTop(String column){
        List<Energy> listTops=new ArrayList<>();
        List<String> stringList = energyService.listDistinct(column);
//        System.out.println(stringList);
        for (String s : stringList) {
            Energy energy = energyService.listTop(column, s);
//            System.out.println(energy);
            listTops.add(energy);
        }
        return RespBean.ok("ok",listTops);
    }
}
