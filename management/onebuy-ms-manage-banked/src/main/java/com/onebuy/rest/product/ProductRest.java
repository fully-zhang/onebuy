package com.onebuy.rest.product;

import com.onebuy.domain.product.Product;
import com.onebuy.service.product.ProductService;
import com.onebuy.util.RestResponseUtils;
import com.onebuy.vo.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhj on 2017/8/31.
 */

@RestController
@RequestMapping("/product")
public class ProductRest {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "findProduct")
    public RestResponse findProduct(@RequestParam(defaultValue = "0", required = false) final String id) {
        Product product = productService.get(id);
        return RestResponseUtils.success("获取产品信息", product, "获取产品信息");
    }

}
