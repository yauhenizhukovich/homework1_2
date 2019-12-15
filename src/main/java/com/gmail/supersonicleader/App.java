package com.gmail.supersonicleader;

import com.gmail.supersonicleader.service.FirstTaskService;
import com.gmail.supersonicleader.service.SecondTaskService;
import com.gmail.supersonicleader.service.ThirdTaskService;
import com.gmail.supersonicleader.service.impl.FirstTaskServiceImpl;
import com.gmail.supersonicleader.service.impl.SecondTaskServiceImpl;
import com.gmail.supersonicleader.service.impl.ThirdTaskServiceImpl;

public class App {

    public static void main(String[] args) {
        FirstTaskService firstSecondHomeworkService = new FirstTaskServiceImpl();
        firstSecondHomeworkService.runFirstTask();

        SecondTaskService secondTaskService = new SecondTaskServiceImpl();
        secondTaskService.runSecondTask();

        ThirdTaskService thirdTaskService = new ThirdTaskServiceImpl();
        thirdTaskService.runThirdTask();

    }

}
