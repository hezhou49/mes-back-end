package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.OEE;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.OEEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSON;

@Controller
@RequestMapping("/oeenew")
public class OEEController {
    @Autowired
    private OEEService oeeService;

    @RequestMapping("/listAll")
    @ResponseBody
    public RespBean listAll(){
        List<OEE> list = oeeService.listAll();
        return RespBean.ok("ok",list);
    }
    @RequestMapping("/oeeAll")
    @ResponseBody
    public RespBean oeeListAll() {
        List<OEE> oeeAll = oeeService.listAll();
        List<Double> lineList = new ArrayList<Double>();
        List<Double> R1list = new ArrayList<Double>();
        List<Double> R2list = new ArrayList<Double>();
        List<Double> R3list = new ArrayList<Double>();
        List<Double> M1list = new ArrayList<Double>();
        List<Double> M2list = new ArrayList<Double>();
        List<Double> M3list = new ArrayList<Double>();
        List<String> listtime = new ArrayList<String>();
        for (int i = 0; i < oeeAll.size(); i++) {
            if (oeeAll.get(i).getType().equals("产线")) {
                lineList.add(oeeAll.get(i).getAlloee());
                listtime.add(oeeAll.get(i).getDate());
            } else if (oeeAll.get(i).getName().equals("ROB1")) {
                R1list.add(oeeAll.get(i).getAlloee());
            } else if (oeeAll.get(i).getName().equals("ROB2")) {
                R2list.add(oeeAll.get(i).getAlloee());
            } else if (oeeAll.get(i).getName().equals("ROB3")) {
                R3list.add(oeeAll.get(i).getAlloee());
            } else if (oeeAll.get(i).getName().equals("OP10")) {
                M1list.add(oeeAll.get(i).getAlloee());
            } else if (oeeAll.get(i).getName().equals("OP20")) {
                M2list.add(oeeAll.get(i).getAlloee());
            } else if (oeeAll.get(i).getName().equals("OP30")) {
                M3list.add(oeeAll.get(i).getAlloee());
            }
        }

        String str = toJSON(lineList).toString() + "|" + toJSON(R1list).toString() + "|" + toJSON(R2list).toString() + "|" + toJSON(R3list).toString() + "|" + toJSON(M1list).toString() + "|" + toJSON(M2list).toString() + "|" + toJSON(M3list).toString() + "|" + toJSON(listtime).toString();
        System.out.println(str);
        return RespBean.ok("ok",str);

    }
    @RequestMapping("/oeeOne")
    @ResponseBody
    public RespBean oeeFindOne(@RequestParam("date") String date, @RequestParam("line") String line, @RequestParam("name") String name) {
        OEE target = oeeService.findByDateAndLineAndName(date, line, name);
//        String str=toJSON(target).toString();
//        System.out.println(str);
        if (target==null){
            return RespBean.fail("无对应数据");
        }
        else {
            return RespBean.ok("ok", target);
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<OEE> list(){
        List<String> strings = oeeService.listDistinct();
        for (String string : strings) {
            System.out.println(string);
        }
        return oeeService.listTop(strings);
    }
}
