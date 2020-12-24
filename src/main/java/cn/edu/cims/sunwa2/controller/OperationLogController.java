package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.OperationLog;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;

    @RequestMapping("/listAll")
    public RespBean listOperationLog() {
        List<OperationLog> list = operationLogService.listAll();
        //String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelected(String operator, String[] time) {
        List<OperationLog> operationLogs = operationLogService.listSelected(operator, time[0], time[1]);
        //String str = JSON.toJSONString(list);
        return RespBean.ok("ok",operationLogs);
    }
}
