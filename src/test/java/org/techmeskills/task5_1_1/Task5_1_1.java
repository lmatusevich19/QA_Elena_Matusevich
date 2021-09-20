package org.techmeskills.task5_1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Task5_1_1 {

    private WebDriver webDriver;

    public Task5_1_1(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void inputLengthRoom(String lengthRoom) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[1]/div[2]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), lengthRoom);
    }

    public void inputWidthRoom(String widthRoom) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[1]/div[3]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), widthRoom);
    }

    public void inputLengthLaminate(String lengthLaminate) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[2]/div[2]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), lengthLaminate);
    }

    public void inputWidthLaminate(String widthLaminate) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[2]/div[3]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), widthLaminate);
    }

    public void inputCountInPackage(String countInPackage) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[2]/div[4]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), countInPackage);
    }

    public void inputPrice(String price) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[2]/div[5]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), price);
    }

    public void inputLayDirectionLengthRoom(String layDirectionLengthRoom) {
        Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[2]/div/span[2]/select")));
        select.selectByVisibleText(layDirectionLengthRoom);

    }

    public void inputLayDirectionWidthRoom(String layDirectionWidthRoom) {
        Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[2]/div/span[2]/select")));
        select.selectByVisibleText(layDirectionWidthRoom);
    }

    public void inputOffsetRows(String offsetRows) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[3]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), offsetRows);
    }

    public void inputDistanceFromWall(String distanceFromWall) {
        webDriver
                .findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[4]/div/span[2]/input"))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), distanceFromWall);
    }

    public void clickButtonCalc() {
        webDriver.findElement(By.xpath("//*[@id=\"inputcalc\"]/div/div[3]/div[7]/div/input")).click();
    }

    public boolean checkResultSquare(String resultSquare) {
        return webDriver.findElement(By.xpath("//*[@id=\"s_lam\"]/b")).getText().equals(resultSquare);
    }

    public boolean checkCountPanelsResult(String countPanelsResult) {
        return webDriver.findElement(By.xpath("//*[@id=\"l_count\"]/b")).getText().equals(countPanelsResult);
    }

    public boolean checkCountPackageResult(String countPackageResult) {
        return webDriver.findElement(By.xpath("//*[@id=\"l_packs\"]/b")).getText().equals(countPackageResult);
    }

    public boolean checkPriceResult(String priceResult) {
        return webDriver.findElement(By.xpath("//*[@id=\"l_price\"]/b")).getText().equals(priceResult);
    }

    public boolean checkOver(String over) {
        return webDriver.findElement(By.xpath("//*[@id=\"l_over\"]/b")).getText().equals(over);
    }

    public boolean checkTrash(String trash) {
        return webDriver.findElement(By.xpath("//*[@id=\"l_trash\"]/b")).getText().equals(trash);
    }
}
