package org.techmeskills.task5_2_1;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Data
@NoArgsConstructor
public class Task_5_2_1 {

    private WebDriver webDriver;

    public Task_5_2_1(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void inputSearchQuery(String searchQuery) {
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(searchQuery, Keys.ENTER);
    }

    public void scrollDownEndPage() {
        try {
            Object lastHeight = ((JavascriptExecutor) webDriver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                Object newHeight = ((JavascriptExecutor) webDriver).executeScript("return document.body.scrollHeight");
                if (newHeight.equals(lastHeight)) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickLastLinkOnPage() {
        webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[7]/div/div/div/div[1]/a")).click();
    }

}
