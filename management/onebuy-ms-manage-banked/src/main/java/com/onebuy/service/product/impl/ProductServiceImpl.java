package com.onebuy.service.product.impl;

import com.github.pagehelper.PageInfo;
import com.onebuy.compoent.product.CProductCompoent;
import com.onebuy.domain.product.Product;
import com.onebuy.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhj on 2017/8/31.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CProductCompoent productCompoent;

    @Override
    public Product get(String id) {
        return productCompoent.get(id);
    }

    @Override
    public Product create(Product product) {
        return productCompoent.create(product);
    }

    @Override
    public Product update(Product product) {
        return productCompoent.update(product.getId(), product);
    }

    @Override
    public Product delUpdate(String id) {
        return productCompoent.delUpdate(id);
    }

    @Override
    public PageInfo<Product> findAll(Integer page, Integer size) {
        return productCompoent.findAll(page, size);
    }
}
