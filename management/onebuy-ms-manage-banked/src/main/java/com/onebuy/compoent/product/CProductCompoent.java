package com.onebuy.compoent.product;

import com.github.pagehelper.PageInfo;
import com.onebuy.domain.product.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhj on 2017/8/31.
 */

@FeignClient("ONEBUY-MS-PRODUCT")
public interface CProductCompoent {

    @GetMapping(value = "/product/{id}")
    Product get(@PathVariable("id") final String id);

    @PostMapping("/product")
    Product create(@RequestBody final Product product);

    @PutMapping(value = "/product/{id}")
    Product update(@PathVariable("id") final String id, @RequestBody final Product product);

    @PutMapping(value = "/product/{id}/delete")
    Product delUpdate(@PathVariable("id") final String id);

    @GetMapping("/product")
    PageInfo<Product> findAll(@RequestParam(value = "page") final Integer page,
                              @RequestParam(value = "size") final Integer size);

}
