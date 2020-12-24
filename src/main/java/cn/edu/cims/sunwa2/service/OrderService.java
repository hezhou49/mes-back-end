package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> listAllByStatus(String status);
    List<Order> listSelected(String status, String ordernumber, String linename, String guige, String startTime, String endTime);
    void delete(String ordernumber, String status);
    void save(Order order);
    void update(Order order);
}
