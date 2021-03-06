package cn.itsource.crm.controller;

import cn.itsource.crm.domain.Menu;
import cn.itsource.crm.query.MenuQuery;
import cn.itsource.crm.util.AjaxResult;
import cn.itsource.crm.util.PageList;
import cn.itsource.crm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author solargen
 * @since 2019-06-05
 */
@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

    public MenuController(){
        System.out.println("MenuController");
    }

    @Autowired
    private IMenuService menuService;

    /**
     * 保存
     * @param menu
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult save(@RequestBody Menu menu){
        try {
            if(menu.getId()==null){
                //添加
                if(menu.getParentId()==null)
                    menu.setParentId(0L);
                menuService.add(menu);
            }else{
                //修改
                menuService.update(menu);
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
            menuService.remove(id);
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
    public List<Menu> list(){
        return menuService.getAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public Menu getById(@RequestParam("id") Long id){
        return menuService.getById(id);
    }

    /**
     * 分页高级查询
     * @param query
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public PageList<Menu> query(@RequestBody MenuQuery query){
        return menuService.getPage(query);
    }

    /**
     * 加载所有一级菜单
     * @return
     */
    @RequestMapping(value = "/getParentMenus",method = RequestMethod.GET)
    public List<Menu> getParentMenus(){
        return menuService.getParentMenus();
    }

    /**
     * 验证菜单标识是否已经存在
     * @param sn
     * @return
     */
    @RequestMapping(value = "/validateSn",method = RequestMethod.GET)
    public boolean validateSn(@RequestParam("sn") String sn){
        return menuService.validateSn(sn);
    }

}
