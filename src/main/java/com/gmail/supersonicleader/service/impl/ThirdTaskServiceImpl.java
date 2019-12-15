package com.gmail.supersonicleader.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmail.supersonicleader.service.ThirdTaskService;
import com.gmail.supersonicleader.service.model.Car;
import com.gmail.supersonicleader.service.model.CarModelEnum;
import com.gmail.supersonicleader.service.util.RandomUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThirdTaskServiceImpl implements ThirdTaskService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void runThirdTask() {
        int numberOfCars = 10;
        int minEngineCapacity = 1;
        int maxEngineCapacity = 3;
        int minNumberOfCarModel = 1;
        int maxNumberOfCarModel = 3;
        Map<Integer, List<Car>> carMap = new HashMap<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            int numberOfCarModel = RandomUtil.getNumberInRange(minNumberOfCarModel, maxNumberOfCarModel);
            int engineCapacity = RandomUtil.getNumberInRange(minEngineCapacity, maxEngineCapacity);
            Car car = new Car("Car" + i, getCarModel(numberOfCarModel), engineCapacity);
            if (carMap.containsKey(engineCapacity)) {
                carMap.get(engineCapacity).add(car);
            } else {
                carMap.put(engineCapacity, new ArrayList<>());
                carMap.get(engineCapacity).add(car);
            }

        }
        String directoryName = "output";
        File directory = new File(directoryName);
        createDirectoriesChain(directory);
        String fileName = "cars.txt";
        File file = new File(directoryName + File.separator + fileName);
        int engineCapacity = 0;
        try {
            engineCapacity = RandomUtil.getRandomNumber();
            if (engineCapacity < minEngineCapacity || engineCapacity > maxEngineCapacity) {
                throw new IllegalArgumentException("You entered wrong engine capacity!");
            }
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
        writeCarsInFile(carMap, file, engineCapacity);

    }

    private static void createDirectoriesChain(File newFile) {
        try {
            if (!newFile.exists()) {
                boolean isCreated = newFile.mkdir();
                if (!isCreated) {
                    isCreated = newFile.mkdirs();
                    if (!isCreated) {
                        throw new IllegalAccessException("Cannot create directory");
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void writeCarsInFile(Map<Integer, List<Car>> carMap, File file, int requiredEngineCapacity) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<Integer, List<Car>> cars : carMap.entrySet()) {
                if (cars.getKey() == requiredEngineCapacity) {
                    for (Car car : cars.getValue()) {
                        bufferedWriter.write(car.toString());
                    }
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private CarModelEnum getCarModel(int numberOfCarModel) {
        switch (numberOfCarModel) {
            case 1:
                return CarModelEnum.BMW;
            case 2:
                return CarModelEnum.AUDI;
            case 3:
                return CarModelEnum.PORSCHE;
            default:
                throw new IllegalArgumentException("You entered wrong number of car model!");
        }
    }

}
