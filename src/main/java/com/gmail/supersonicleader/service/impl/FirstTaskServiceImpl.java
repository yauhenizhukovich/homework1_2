package com.gmail.supersonicleader.service.impl;

import java.lang.invoke.MethodHandles;

import com.gmail.supersonicleader.service.FirstTaskService;
import com.gmail.supersonicleader.service.util.RandomUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstTaskServiceImpl implements FirstTaskService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void runFirstTask() {
        long x = RandomUtil.getRandomNumber();
        long y = RandomUtil.getRandomNumber();
        long z = RandomUtil.getRandomNumber();
        if (x > z) {
            logger.debug("x + y = " + (x + y));
        } else {
            logger.debug("z = " + z);
        }
        int countOfNumbers = 3;
        logger.info("Average = " + (x + y + z) / countOfNumbers);
    }

}
