package com.onebuy.rest.product;

import com.onebuy.domain.product.Product;
import com.onebuy.service.product.ProductService;
import com.onebuy.util.RestResponseUtils;
import com.onebuy.vo.RestResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="根据ID查询产品详细信息", notes="根据url的id来查询产品详细信息")
    @ApiImplicitParam(name = "id", value = "产品ID", dataType = "String", paramType="query")
    @GetMapping(value = "findProduct")
    public RestResponse findProduct(@RequestParam(defaultValue = "0") final String id) {
        Product product = productService.get(id);
        return RestResponseUtils.success("获取产品信息", product, "获取产品信息");
    }

}
