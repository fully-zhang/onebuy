package com.onebuy;

import com.onebuy.domain.TProduct;
import com.onebuy.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnebuyMsProductApplicationTests {

	@Autowired
	ProductService productService;

	@Test
	public void contextLoads() {

        TProduct tProduct = productService.get("1");
        System.out.println(tProduct.toString());

    }

}
