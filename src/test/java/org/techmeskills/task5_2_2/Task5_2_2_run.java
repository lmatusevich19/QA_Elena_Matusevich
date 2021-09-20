package org.techmeskills.task5_2_2;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techmeskills.ConfProperties;

import java.util.concurrent.TimeUnit;

public class Task5_2_2_run {
    private static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("googleUrl"));
    }

    @Test
    public void task_5_2_2_test() {
        Task_5_2_2 task_5_2_2 = new Task_5_2_2(webDriver);
        task_5_2_2.inputSearchQuery(ConfProperties.getProperty("searchQueryIsNotValid"));
        task_5_2_2.checkResult();
        webDriver.close();
    }
}
