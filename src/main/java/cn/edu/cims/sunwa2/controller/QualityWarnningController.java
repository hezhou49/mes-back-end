package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.QualityWarnning;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.QualityWarnningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wu on 2019/12/9.
 */
@RestController
@RequestMapping("/qualitywarnning")
public class QualityWarnningController {
    @Autowired
    private QualityWarnningService qualityWarnningService;

    @RequestMapping("/listAll")
    public RespBean listAll() {
        List<QualityWarnning> list = qualityWarnningService.listAll();
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelected(String lineName, String orderNum, String type, String warnTime) {
        List<QualityWarnning> list = qualityWarnningService.listSelected(lineName, orderNum, type, warnTime);
        return RespBean.ok("ok",list);
    }
}
