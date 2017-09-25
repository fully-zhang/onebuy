package com.onebuy.rest.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhj on 2017/9/25 0025.
 */

@Controller
public class PageRest {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
