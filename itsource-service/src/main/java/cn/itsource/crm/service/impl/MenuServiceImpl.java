package cn.itsource.crm.service.impl;

import cn.itsource.crm.domain.Menu;
import cn.itsource.crm.mapper.MenuMapper;
import cn.itsource.crm.service.impl.BaseServiceImpl;
import cn.itsource.crm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService{

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 初始化员工菜单
     * @param employeeId
     * @return
     */
    @Override
    public List<Menu> initMenu(Long employeeId) {
        List<Menu> list =  menuMapper.selectByEmployeeId(employeeId);
        return list;
    }

    /**
     * 加载所有一级菜单
     * @return
     */
    @Override
    public List<Menu> getParentMenus() {
        return menuMapper.selectParentMenus();
    }

    /**
     * 验证菜单标识
     * @param sn
     * @return
     */
    @Override
    public boolean validateSn(String sn) {
        Menu menu = menuMapper.getBySn(sn);
        if(menu==null){
            return true;
        }
        return false;
    }
}
