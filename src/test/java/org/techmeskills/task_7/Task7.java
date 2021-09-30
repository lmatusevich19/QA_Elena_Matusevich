package org.techmeskills.task_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Task7 {

    private final WebDriver webDriver;

    public Task7(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public boolean getValuesFromFirstColumn(String firstsTh) {
        List<WebElement> elements = webDriver.findElements(By.tagName("th"));
        StringBuilder result = new StringBuilder();
        for (int i = 3; i < elements.size(); i += 3) {
            result.append(elements.get(i).getText());
        }
        return Objects.equals(result.toString(), firstsTh);
    }

    public void inputValue(String login) {
        webDriver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(login);
    }

    public void clickCheckBox() {
        webDriver.findElement(By.xpath("//*[@id=\"flexCheckDefault\"]")).click();
    }

    public void selectElementFromList() {
        Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"select\"]/div/select")));
        select.selectByIndex(1);
    }

    public void clickButton() {
        webDriver.findElement(By.xpath("//*[@id=\"button\"]/div/button")).click();
    }

    public boolean isDisplayedImage() {
        return webDriver.findElements(By.xpath("//*[@id=\"image\"]/div/img")).size() > 0;
    }

    public boolean isExistsText(String textTagP) {
        return Objects.equals(webDriver.findElement(By.xpath("//*[@id=\"p\"]/div/p")).getText(), textTagP);
    }

    public boolean isOpenedNewPage() {
        webDriver.findElement(By.xpath("//*[@id=\"a\"]/div/a")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver.findElements(By.xpath("//*[@id=\"nav131755476\"]/div/div[2]/div/a/img")).size() > 0;
    }
}
