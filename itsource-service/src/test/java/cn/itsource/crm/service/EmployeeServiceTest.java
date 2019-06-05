package cn.itsource.crm.service;

import cn.itsource.crm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-service.xml","classpath:applicationContext-mapper.xml"})
public class EmployeeServiceTest {

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void test()throws Exception{
        for (Employee employee : employeeService.getAll()) {
            System.out.println(employee.getUsername());
        }
    }

}
