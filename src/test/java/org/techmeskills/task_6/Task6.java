package org.techmeskills.task_6;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class Task6 {

    private WebDriver webDriver;
    private String priceResult;
    private String productName;

    public Task6(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void inputUserName(String username) {
        webDriver.findElement(By.id("user-name")).sendKeys(username);
    }

    public void inputPassword(String password) {
        webDriver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(By.className("submit-button")).click();
    }

    public void addProductToCart() {
        List<WebElement> elements = webDriver
                .findElement(By.className("inventory_list"))
                .findElements(By.className("inventory_item"));

        for (WebElement element : elements) {
            WebElement pricebar = element.findElement(By.className("pricebar"));
            if (pricebar.findElement(By.className("inventory_item_price")).getText().equals("$7.99")) {
                priceResult = pricebar.findElement(By.className("inventory_item_price")).getText();
                productName = element
                        .findElement(By.className("inventory_item_label"))
                        .findElement(By.className("inventory_item_name")).getText();
                pricebar.findElement(By.className("btn")).click();
            }
        }
    }

    public void openCart() {
        webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    public String equalsFinallyResult() {
        return webDriver.findElement(By.className("inventory_item_name")).getText()
                + webDriver.findElement(By.className("inventory_item_price")).getText();
    }
}