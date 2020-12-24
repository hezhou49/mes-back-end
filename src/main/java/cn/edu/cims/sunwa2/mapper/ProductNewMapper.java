package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.ProductNew;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hezhou
 * @Date 2020/9/16 19:37
 */
public interface ProductNewMapper {
    List<ProductNew> listAll();
    List<ProductNew>listSelected(@Param("orderNum") String orderNum, @Param("workpieceNum") String workpieceNum, @Param("lineName") String lineName, @Param("quality") String quality);
    void save(ProductNew product);
}
