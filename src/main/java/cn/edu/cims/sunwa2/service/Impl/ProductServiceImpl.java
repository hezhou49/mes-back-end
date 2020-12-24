package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.ProductMapper;
import cn.edu.cims.sunwa2.model.Product;
import cn.edu.cims.sunwa2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/17.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> listAll() {
        return productMapper.listAll();
    }

    @Override
    public List<Product> listSelected(String orderNum, String materialId, String lineName, String endTime) {
        return productMapper.listSelected(orderNum, materialId, lineName, endTime);
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }
}
