package org.techmeskills.task5_1_1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techmeskills.ConfProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Task5_1_1_run {
    private static WebDriver webDriver;
    private static Task5_1_1 task5_1_1;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("pageURL"));
    }

    @Test
    public void Test5_1_1() {
        task5_1_1 = new Task5_1_1(webDriver);
        task5_1_1.inputLengthRoom(ConfProperties.getProperty("lengthRoom"));
        task5_1_1.inputWidthRoom(ConfProperties.getProperty("widthRoom"));
        task5_1_1.inputLengthLaminate(ConfProperties.getProperty("lengthLaminate"));
        task5_1_1.inputWidthLaminate(ConfProperties.getProperty("widthLaminate"));
        task5_1_1.inputCountInPackage(ConfProperties.getProperty("countInPackage"));
        task5_1_1.inputPrice(ConfProperties.getProperty("price"));
        task5_1_1.inputLayDirectionLengthRoom(ConfProperties.getProperty("layDirectionLengthRoom"));
        task5_1_1.inputOffsetRows(ConfProperties.getProperty("offsetRows"));
        task5_1_1.inputDistanceFromWall(ConfProperties.getProperty("distanceFromWall"));
        task5_1_1.clickButtonCalc();
        boolean checkResultSquare = task5_1_1.checkResultSquare(ConfProperties.getProperty("resultSquare"));
        boolean checkCountPanelsResult = task5_1_1.checkCountPanelsResult(ConfProperties.getProperty("countPanelsResult"));
        boolean countPackageResult = task5_1_1.checkCountPackageResult(ConfProperties.getProperty("countPackageResult"));
        boolean priceResult = task5_1_1.checkPriceResult(ConfProperties.getProperty("priceResult"));
        boolean checkOver = task5_1_1.checkOver(ConfProperties.getProperty("over"));
        boolean checkTrash = task5_1_1.checkTrash(ConfProperties.getProperty("trash"));

        boolean result = checkResultSquare
                && checkCountPanelsResult
                && countPackageResult
                && priceResult
                && checkOver
                && checkTrash;

        try {
            if (!result) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webDriver.close();
        }
    }

}
