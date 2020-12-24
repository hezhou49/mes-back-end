package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.Product;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wu on 2019/12/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/listAll")
    public RespBean getProductList() {
        List<Product> list = productService.listAll();
        return RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelectedProductList(String orderNum, String materialId, String lineName, String endTime) {
        List<Product> list = productService.listSelected(orderNum, materialId, lineName, endTime);
//        String str = JSON.toJSONString(list);
        return RespBean.ok("ok",list);
    }
}
