package cn.itsource.crm.service.impl;

import cn.itsource.crm.domain.Employee;
import cn.itsource.crm.mapper.EmployeeMapper;
import cn.itsource.crm.service.impl.BaseServiceImpl;
import cn.itsource.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 根据用户名查询并返回员工信息
     * @param username
     * @return
     */
    @Override
    public Employee getByUsername(String username) {
        return employeeMapper.selectByUsername(username);
    }
}
