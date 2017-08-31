package com.onebuy.service.product;

import com.github.pagehelper.PageInfo;
import com.onebuy.domain.product.Product;

/**
 * Created by zhj on 2017/8/31.
 */
public interface ProductService {

    Product get(String id);

    Product create(Product product);

    Product update(Product product);

    Product delUpdate(String id);

    PageInfo<Product> findAll(Integer page, Integer size);

}
