package com.onebuy.service.system.impl;

import com.onebuy.service.system.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhj on 2017/9/21 0021.
 */
@Service
public class SystemServiceImpl implements SystemService {

    private Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Override
    public void editSystemTime(String date) {
        String cmd = "/bin/date -s '"+date+"'";
        logger.info("cmd-->"+cmd);
        try {
            String[] comands = new String[] { "/bin/sh", "-c", cmd };
            Process p = Runtime.getRuntime().exec(comands);
            logger.info("完成");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
