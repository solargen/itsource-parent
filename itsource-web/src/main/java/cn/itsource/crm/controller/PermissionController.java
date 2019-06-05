package cn.itsource.crm.controller;

import cn.itsource.crm.domain.Permission;
import cn.itsource.crm.query.PermissionQuery;
import cn.itsource.crm.util.AjaxResult;
import cn.itsource.crm.util.PageList;
import cn.itsource.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author solargen
 * @since 2019-06-05
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 保存
     * @param permission
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult save(@RequestBody Permission permission){
        try {
            if(permission.getId()!=null){
                //添加
                permissionService.add(permission);
            }else{
                //修改
                permissionService.update(permission);
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
            permissionService.remove(id);
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
    public List<Permission> list(){
        return permissionService.getAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "getById",method = RequestMethod.GET)
    public Permission getById(@RequestParam("id") Long id){
        return permissionService.getById(id);
    }

    /**
     * 分页高级查询
     * @param query
     * @return
     */
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public PageList<Permission> query(PermissionQuery query){
        return permissionService.getPage(query);
    }

}
