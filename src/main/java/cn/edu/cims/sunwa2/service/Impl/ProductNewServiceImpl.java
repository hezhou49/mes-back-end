package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.ProductNewMapper;
import cn.edu.cims.sunwa2.model.ProductNew;
import cn.edu.cims.sunwa2.service.ProductNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/9/16 19:42
 */
@Service
public class ProductNewServiceImpl implements ProductNewService {
    @Autowired
    ProductNewMapper productNewMapper;
    @Override
    public List<ProductNew> listAll() {
        return productNewMapper.listAll();
    }

    @Override
    public List<ProductNew> listSelected(String orderNum, String workpieceNum, String lineName,String quality) {
        return productNewMapper.listSelected(orderNum,workpieceNum,lineName,quality);
    }

    @Override
    public void save(ProductNew product) {
        productNewMapper.save(product);
    }
}
