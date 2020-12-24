package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.aop.MyLog;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.model.Warnning;
import cn.edu.cims.sunwa2.model.WarnningResume;
import cn.edu.cims.sunwa2.service.WarnningResumeService;
import cn.edu.cims.sunwa2.service.WarnningService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//import cn.edu.cims.sunwa.transaction.MyLog;


@RestController
@RequestMapping("/warnning")
public class WarnningController {

    @Autowired
    private WarnningService warnningService;
    @Autowired
    private WarnningResumeService warnningResumeService;

    private static final String state = "已处理";
    private static Logger LOG = LoggerFactory.getLogger(WarnningController.class);

    @RequestMapping("/listAll")//@MyLog("列出全部报警")
    public RespBean warnningList() {
        List<Warnning> list = warnningService.listAll();
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean warnningList(String lineName, String equipmentName, String[] warntime) {
        //前端设置保障warntime始终为长度为2地数组，防止ArrayIndexOutOfBoundsException
        List<Warnning> list = warnningService.listSelected(lineName, equipmentName, warntime[0],warntime[1]);
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/warnResumeListAll")
    public RespBean warnResume() {
        List<WarnningResume> list = warnningResumeService.listAll();
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

    /*                data:{lineName:lineName2,equipmentName:equipmentName2,handlTime:time},
     */
    @RequestMapping("/warnResumeListSelected")
    public RespBean warnResumeListSelected(String lineName, String equipmentName, String[] warntime) {
        //前端设置保障warntime始终为长度为2地数组，防止ArrayIndexOutOfBoundsException
        List<WarnningResume> list = warnningResumeService.listSelected(lineName, equipmentName,  warntime[0], warntime[1]);
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

    //更新warn报警
    @MyLog(value = "处理报警")
    @RequestMapping("/warnUpdate")
    public RespBean warnUpdate(int id) {
        warnningService.update(state, id);
        return RespBean.ok("报警处理情况已更新");
    }

    //是否处理
    @RequestMapping("/handled")
    public RespBean handled(String warnstate) {
        List<Warnning> list = warnningService.unhandled(warnstate);
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/saveWarnResume")
    public RespBean saveWarn(String warnResume) {
        //Json转成对象
        WarnningResume warnningResume = JSON.parseObject(warnResume, WarnningResume.class);
        warnningResume.setHandletime(new Date());
        warnningResumeService.save(warnningResume);
        return RespBean.ok("报警履历更新成功");
    }
}
