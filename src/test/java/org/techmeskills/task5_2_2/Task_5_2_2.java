package org.techmeskills.task5_2_2;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.techmeskills.ConfProperties;

import java.io.IOException;

@Data
@NoArgsConstructor
public class Task_5_2_2 {

    private WebDriver webDriver;

    public Task_5_2_2(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void inputSearchQuery(String searchQueryIsNotValid) {
        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(searchQueryIsNotValid, Keys.ENTER);
    }

    public void checkResult() {
        String searchResult = webDriver.findElement(By.xpath("//*[@id=\"res\"]")).getText();
        try {
            if (!searchResult.equals(ConfProperties.getProperty("searchResult"))) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
