package cn.edu.cims.sunwa2.service;

import cn.edu.cims.sunwa2.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Wu on 2019/12/12.
 */
public interface EmployeeService {
    List<Employee> listAll();
    List<Employee>listSelected(@Param("department") String department, @Param("role") String role, @Param("regTime") String regTime);
    void delete(int id);
    void update(Employee employee);
    void save(Employee employee);
}
