package cn.itsource.crm.controller;

import cn.itsource.crm.domain.Employee;
import cn.itsource.crm.domain.Menu;
import cn.itsource.crm.service.IMenuService;
import cn.itsource.crm.util.AjaxResult;
import cn.itsource.crm.shiro.util.UserContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private IMenuService menuService;

    /**
     * 身份认证--登录
     * @param employee
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee){
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){

            try {
                UsernamePasswordToken token = new UsernamePasswordToken(employee.getUsername(),employee.getPassword());
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("用户名不存在!");
            } catch (IncorrectCredentialsException e){
                e.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("密码错误!");
            } catch (AuthenticationException e){
                e.printStackTrace();
                return AjaxResult.me().setSuccess(false).setMessage("系统异常！");
            }

        }
        Employee principal = (Employee) currentUser.getPrincipal();
        principal.setPassword(null);
        UserContext.setUser(principal);

        Map<String,Object> resObj = new HashMap<>();
        resObj.put("token",currentUser.getSession().getId());
        resObj.put("user",principal);
        //获取动态菜单
        List<Menu> menus = menuService.initMenu(employee.getId());
        resObj.put("menus",menus);
        return AjaxResult.me().setResObj(resObj);
    }

}
