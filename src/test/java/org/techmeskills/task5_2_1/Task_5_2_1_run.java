package org.techmeskills.task5_2_1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techmeskills.ConfProperties;

import java.util.concurrent.TimeUnit;

public class Task_5_2_1_run {
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
    public void task_5_2_1_test() {
        Task_5_2_1 task_5_2_1 = new Task_5_2_1(webDriver);
        task_5_2_1.inputSearchQuery(ConfProperties.getProperty("searchQuery"));
        task_5_2_1.scrollDownEndPage();
        task_5_2_1.clickLastLinkOnPage();
        webDriver.close();
    }
}
