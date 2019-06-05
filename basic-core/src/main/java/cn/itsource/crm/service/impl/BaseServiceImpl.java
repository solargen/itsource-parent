package cn.itsource.crm.service.impl;

import cn.itsource.crm.mapper.BaseMapper;
import cn.itsource.crm.query.BaseQuery;
import cn.itsource.crm.service.IBaseService;
import cn.itsource.crm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;


    @Override
    public T getById(Serializable id) {
        return mapper.selectById(id);
    }

    @Override
    public List<T> getAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> getList(BaseQuery query) {
        return mapper.selectList(query);
    }

    @Override
    public PageList<T> getPage(BaseQuery query) {
        Long total = mapper.countList(query);
        List<T> rows = mapper.selectList(query);
        return new PageList<>(total,rows);
    }

    @Override
    @Transactional
    public void add(T entity) {
        mapper.insert(entity);
    }

    @Override
    @Transactional
    public void remove(Serializable id) {
        mapper.deleteById(id);
    }

    @Override
    @Transactional
    public void update(T entity) {
        mapper.updateById(entity);
    }
}
