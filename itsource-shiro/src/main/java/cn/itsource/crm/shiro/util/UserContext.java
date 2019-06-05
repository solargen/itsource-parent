package cn.itsource.crm.shiro.util;

import cn.itsource.crm.domain.Employee;
import org.apache.shiro.SecurityUtils;

public class UserContext {

    public static final String USER = "login_user";

    public static void setUser(Employee employee){
        SecurityUtils.getSubject().getSession().setAttribute(USER,employee);
    }

    public static Employee getUser(){
        return (Employee) SecurityUtils.getSubject().getSession().getAttribute(USER);
    }

}
