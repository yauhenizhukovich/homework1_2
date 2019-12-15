package com.gmail.supersonicleader.service.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();

    public static int getNumberInRange(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumber() {
        return RANDOM.nextInt();
    }

}