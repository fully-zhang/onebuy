package com.onebuy.mapper;

import com.onebuy.base.BaseDao;
import com.onebuy.domain.TProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TProductMapper extends BaseDao<TProduct,String>{

}