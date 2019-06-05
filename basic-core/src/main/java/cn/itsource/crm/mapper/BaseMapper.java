package cn.itsource.crm.mapper;

import cn.itsource.crm.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T> {

    T selectById(Serializable id);

    List<T> selectAll();

    List<T> selectList(BaseQuery query);

    Long countList(BaseQuery query);//查询总数

    void insert(T entity);

    void deleteById(Serializable id);

    void updateById(T entity);

}
