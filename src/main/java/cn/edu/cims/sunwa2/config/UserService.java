package cn.edu.cims.sunwa2.config;

import cn.edu.cims.sunwa2.mapper.EmployeeMapper;
import cn.edu.cims.sunwa2.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee=employeeMapper.findByUsername(s);
        if (employee==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new User(s,employee.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(employee.getRole()));
    }
}
