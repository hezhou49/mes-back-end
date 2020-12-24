package cn.edu.cims.sunwa2.mapper;

import cn.edu.cims.sunwa2.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wu on 2019/12/17.
 */
public interface ProductMapper {
   List<Product> listAll();
   List<Product>listSelected(@Param("orderNum") String orderNum, @Param("materialId") String materialId, @Param("lineName") String lineName, @Param("endTime") String endTime);
   void save(Product product);
}
