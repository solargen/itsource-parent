package cn.itsource.crm.controller;

import cn.itsource.crm.domain.Role;
import cn.itsource.crm.query.RoleQuery;
import cn.itsource.crm.util.AjaxResult;
import cn.itsource.crm.util.PageList;
import cn.itsource.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author solargen
 * @since 2019-06-05
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 保存
     * @param role
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult save(@RequestBody Role role){
        try {
            if(role.getId()!=null){
                //添加
                roleService.add(role);
            }else{
                //修改
                roleService.update(role);
            }
            return AjaxResult.me().setMessage("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("保存失败!"+e.getMessage());
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResult delete(@RequestParam("id")Long id){
        try {
            roleService.remove(id);
            return AjaxResult.me().setMessage("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除失败!");
        }
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Role> list(){
        return roleService.getAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public Role getById(@RequestParam("id") Long id){
        return roleService.getById(id);
    }

    /**
     * 分页高级查询
     * @param query
     * @return
     */
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public PageList<Role> query(RoleQuery query){
        return roleService.getPage(query);
    }

}
