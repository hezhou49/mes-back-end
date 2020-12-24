package cn.edu.cims.sunwa2.controller;

import cn.edu.cims.sunwa2.model.Employee;
import cn.edu.cims.sunwa2.model.RespBean;
import cn.edu.cims.sunwa2.service.EmployeeService;
import com.alibaba.fastjson.JSON;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/listAll")
    public RespBean getEmployeeList() {
        List<Employee> list = employeeService.listAll();
//        String str = JSON.toJSONString(list);
        return  RespBean.ok("ok",list);
    }

    @RequestMapping("/listSelected")
    public RespBean listSelected(String department, String role, String regTime) {
        List<Employee> list = employeeService.listSelected(department, role, regTime);
//        String str = JSON.toJSONString(list);
        return  RespBean.ok("ok",list);
    }

    @RequestMapping("/deleteById")
    public RespBean deleteByid(int id) {
        employeeService.delete(id);
        return  RespBean.ok("删除成功");
    }

    @RequestMapping("/update")
    public RespBean update(String employeeStr) {
        Employee employee = JSON.parseObject(employeeStr, Employee.class);
        employeeService.update(employee);
        return  RespBean.ok("编辑成功");
    }
    
    @RequestMapping("/save")
    public RespBean save(String employeeStr){
        Employee employee = JSON.parseObject(employeeStr, Employee.class);
        String passwordEncode = new BCryptPasswordEncoder().encode(employee.getPassword());
        employee.setPassword(passwordEncode);
        employee.setRegTime(new Date());
        employeeService.save(employee);
        return  RespBean.ok("添加成功");
    }

}
