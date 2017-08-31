package com.onebuy.rest;

import com.onebuy.base.BaseRest;
import com.onebuy.domain.TProduct;
import com.onebuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhj on 2017/8/31.
 */

@RestController
@RequestMapping("/product")
public class ProductRest extends BaseRest<TProduct, ProductService>{

    @Override
    @Autowired
    protected void setService(ProductService service) {
        super.bService = service;
    }

}
