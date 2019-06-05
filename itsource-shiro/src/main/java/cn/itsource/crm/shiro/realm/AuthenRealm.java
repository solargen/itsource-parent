package cn.itsource.crm.shiro.realm;

import cn.itsource.crm.domain.Employee;
import cn.itsource.crm.service.IEmployeeService;
import cn.itsource.crm.shiro.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义身份认证Realm
 */
public class AuthenRealm extends AuthenticatingRealm {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Employee employee = employeeService.getByUsername(username);
        if(employee==null){
            throw new UnknownAccountException(username);
        }
        Object principal = employee;
        Object hashedCredentials = employee.getPassword();
        ByteSource credentialsSalt = ByteSource.Util.bytes(MD5Util.SALT);
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,hashedCredentials,credentialsSalt,realmName);
        return info;
    }

}
