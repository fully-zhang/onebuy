package com.onebuy.base;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhj on 2017/8/30.
 */

public interface BaseDao<T extends BaseEntity, ID extends Serializable> {

    List<T> findAll(Map<String, Object> map);

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
