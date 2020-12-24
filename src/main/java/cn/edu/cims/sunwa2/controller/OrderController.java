package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.core.ExcelUtils;
import cn.edu.cims.sunwa2.model.Order;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/listAllByStatus")
    public RespBean getOrderList(String status) {
        List<Order> list = orderService.listAllByStatus(status);
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelectedOrderList(String status,String ordernumber,String lineName, String guige,String[] starttime) {
        //System.out.println();
        List<Order> list = orderService.listSelected(status,ordernumber,lineName,guige,starttime[0],starttime[1]);
        return RespBean.ok("ok",list);
    }
    @RequestMapping("/delete")
    public RespBean delete(String status,String ordernumber) {
        orderService.delete(ordernumber,status);
        return RespBean.ok("ok");
    }
    @PostMapping("/import")
    public  RespBean importExcel(MultipartFile file){
//        System.out.println("收到文件");
        List<Order> orders = ExcelUtils.excelToOrder(file);
        String msg="";
        for (Order order : orders) {
            if (orderService.listSelected(null,order.getOrdernumber(),null, null,null,null).isEmpty()){
                orderService.save(order);
            }
            else
                msg="，但部分数据已存在";
        }
        return RespBean.ok("导入成功"+msg);
    }
}
