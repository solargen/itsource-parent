package cn.itsource.crm.service;

import cn.itsource.crm.domain.Employee;
import cn.itsource.crm.service.IBaseService;

public interface IEmployeeService extends IBaseService<Employee> {

    /**
     * 根据用户名查询并返回员工信息
     * @param username
     * @return
     */
    Employee getByUsername(String username);
}
