package com.onebuy.service.impl;

import com.onebuy.base.BaseDao;
import com.onebuy.base.BaseServiceImpl;
import com.onebuy.mapper.TProductMapper;
import com.onebuy.domain.TProduct;
import com.onebuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhj on 2017/8/30.
 */

@Service
public class ProductServiceImpl extends BaseServiceImpl<TProduct> implements ProductService {

    @Autowired
    private TProductMapper productMapper;

    @Override
    protected BaseDao<TProduct, String> getDao() {
        return productMapper;
    }

}
