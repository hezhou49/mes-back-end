package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.OrderMapper;
import cn.edu.cims.sunwa2.model.Order;
import cn.edu.cims.sunwa2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> listAllByStatus(String status) {
        return orderMapper.listAllByStatus(status);
    }

    @Override
    public List<Order> listSelected(String status,String ordernumber, String linename, String guige, String startTime,String endTime) {
        return orderMapper.listSelected(status,ordernumber,linename,guige,startTime,endTime);
    }

    @Override
    public void delete(String ordernumber, String status) {
        orderMapper.delete(ordernumber,status);
    }

    @Override
    public void save(Order order) {
        orderMapper.save(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.update(order);
    }
}
