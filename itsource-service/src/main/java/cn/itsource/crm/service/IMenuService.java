package cn.itsource.crm.service;

import cn.itsource.crm.domain.Menu;
import cn.itsource.crm.service.IBaseService;

import java.util.List;

public interface IMenuService extends IBaseService<Menu> {

    /**
     * 初始化员工菜单
     * @param id
     * @return
     */
    List<Menu> initMenu(Long id);

    /**
     * 加载所有一级菜单
     * @return
     */
    List<Menu> getParentMenus();

    /**
     * 验证菜单标识
     * @param sn
     * @return
     */
    boolean validateSn(String sn);
}
