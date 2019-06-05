package cn.itsource.crm.service;

import cn.itsource.crm.query.BaseQuery;
import cn.itsource.crm.util.PageList;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {

    T getById(Serializable id);

    List<T> getAll();

    List<T> getList(BaseQuery query);//条件查询

    PageList<T> getPage(BaseQuery query);//分页查询

    void add(T entity);

    void remove(Serializable id);

    void update(T entity);

}
