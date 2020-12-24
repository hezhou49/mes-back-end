package cn.edu.cims.sunwa2.service.Impl;

import cn.edu.cims.sunwa2.mapper.EmployeeMapper;
import cn.edu.cims.sunwa2.model.Employee;
import cn.edu.cims.sunwa2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wu on 2019/12/12.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @Override
    public List<Employee> listSelected(String department, String role, String regTime) {
        return employeeMapper.listSelected(department, role, regTime);
    }

    @Override
    public void delete(int id) {
        employeeMapper.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }
}
