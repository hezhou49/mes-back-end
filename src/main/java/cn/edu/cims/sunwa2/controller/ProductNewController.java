package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.ProductNew;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.ProductNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/9/16 19:50
 */
@RestController
@RequestMapping("/product_new")
public class ProductNewController {
    @Autowired
    ProductNewService productNewService;

    @RequestMapping("/listAll")
    public RespBean getProductList() {
        List<ProductNew> list = productNewService.listAll();
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelectedProductList(String orderNum, String workpieceNum, String lineName,String quality) {
        List<ProductNew> list = productNewService.listSelected(orderNum, workpieceNum, lineName,quality);
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }

}
