package org.techmeskills.task_7;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.techmeskills.ConfProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Task7_run {

    private static WebDriver webDriver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("task7BaseUrl"));
    }

    @Test
    public void Task6() throws InterruptedException {
        Task7 task7 = new Task7(webDriver);
        int currentCountTagA = 0;
        WebElement currentA;

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        boolean firstsTh = task7.getValuesFromFirstColumn(ConfProperties.getProperty("firstsTh"));
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        task7.inputValue(ConfProperties.getProperty("inputText"));
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        task7.clickCheckBox();
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        task7.selectElementFromList();
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        task7.clickButton();
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        boolean displayedImage = task7.isDisplayedImage();
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        boolean textTagP = task7.isExistsText(ConfProperties.getProperty("textTagP"));
        Thread.sleep(1000);
        currentA.click();

        currentA = getCurrentWebElement(++currentCountTagA);
        currentA.click();
        boolean openedNewPage = task7.isOpenedNewPage();
        Thread.sleep(1000);

        try {
            if (!firstsTh || !displayedImage || !textTagP || !openedNewPage) {
                throw new TimeoutException();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            webDriver.close();
        }
    }

    private WebElement getCurrentWebElement(int currentCountTagA) {
        return webDriver.findElement(By.xpath("/html/body/p/a[" + currentCountTagA + "]"));
    }
}
