package com.gmail.supersonicleader.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import com.gmail.supersonicleader.service.SecondTaskService;
import com.gmail.supersonicleader.service.util.RandomUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondTaskServiceImpl implements SecondTaskService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void runSecondTask() {
        int arrayCapacity = 10;
        int[] numbersArray = new int[arrayCapacity];
        int minForNumberInRange = -300;
        int maxForNumberInRange = 300;
        for (int i = 0; i < arrayCapacity; i++) {
            numbersArray[i] = RandomUtil.getNumberInRange(minForNumberInRange, maxForNumberInRange);
        }
        int max = numbersArray[0];
        int min = numbersArray[0];
        int indexOfMax = 0;
        for (int i = 0; i < arrayCapacity; i++) {
            if (numbersArray[i] > max) {
                max = numbersArray[i];
                indexOfMax = i;
            }
            if (numbersArray[i] < min) {
                min = numbersArray[i];
            }
        }
        logger.info("Max number in array = " + max);
        logger.info("Min number in array = " + min);
        numbersArray[indexOfMax] *= min;
        logger.error(Arrays.toString(numbersArray));

    }

}
