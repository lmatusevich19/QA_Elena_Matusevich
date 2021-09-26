package org.techmeskills.task_6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techmeskills.ConfProperties;

import java.util.concurrent.TimeUnit;

public class Task6_run {
    private static WebDriver webDriver;
    private static Task6 task6;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("task6BaseUrl"));
    }

    @Test
    public void Task6() {
        task6 = new Task6(webDriver);
        task6.inputUserName(ConfProperties.getProperty("username"));
        task6.inputPassword(ConfProperties.getProperty("password"));
        task6.clickLoginButton();
        task6.addProductToCart();
        task6.openCart();
        Assert.assertEquals(task6.equalsFinallyResult(), (task6.getProductName() + task6.getPriceResult()));
        webDriver.close();
    }

}
