package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.ProductNew;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/9/16 19:42
 */
public interface ProductNewService {
    List<ProductNew> listAll();
    List<ProductNew>listSelected(@Param("orderNum") String orderNum, @Param("workpieceNum") String workpieceNum, @Param("lineName") String lineName, @Param("quality") String quality);
    void save(ProductNew product);
}
