package cn.itsource.crm.mapper;

import cn.itsource.crm.domain.Menu;
import cn.itsource.crm.mapper.BaseMapper;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询员工的所有有权限的菜单
     * @param id
     * @return
     */
    List<Menu> selectByEmployeeId(Long id);

    /**
     * 加载所有一级菜单
     * @return
     */
    List<Menu> selectParentMenus();

    /**
     * 根据标识查询菜单
     * @param sn
     * @return
     */
    Menu getBySn(String sn);
}
