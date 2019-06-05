package cn.itsource.crm.mapper;

import cn.itsource.crm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test()throws Exception{
        List<Employee> employees = employeeMapper.selectAll();
        for (Employee employee : employees) {
            System.out.println(employee.getUsername());
        }
    }


}
