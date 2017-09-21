package com.onebuy.rest.system;

import com.onebuy.service.system.SystemService;
import com.onebuy.util.RestResponseUtils;
import com.onebuy.vo.RestResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhj on 2017/9/21 0021.
 */

@RestController
@RequestMapping("/system")
public class SystemRest {

    @Autowired
    private SystemService systemService;

    @ApiOperation(value="根据date修改服务器时间", notes="根据url的date来修改服务器时间")
    @ApiImplicitParam(name = "date", value = "要修改的时间", required = true, dataType = "String", paramType="query")
    @GetMapping("/editSystemTime")
    public RestResponse editSystemTime(@RequestParam String date) {
        try {
            systemService.editSystemTime(date);
        } catch (Exception e) {
            return RestResponseUtils.error("修改系统时间","修改失败","修改系统时间时出错！");
        }
        return RestResponseUtils.success("修改系统时间","修改成功","修改系统时间成功！");

    }

}
