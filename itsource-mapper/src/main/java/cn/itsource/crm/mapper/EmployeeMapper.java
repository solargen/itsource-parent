package cn.itsource.crm.mapper;

import cn.itsource.crm.domain.Employee;
import cn.itsource.crm.mapper.BaseMapper;

public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 根据用户名查询并返回员工信息
     * @param username
     * @return
     */
    Employee selectByUsername(String username);
}
