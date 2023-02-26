package org.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {

    private  final WebDriver driver;

    private final By orderNotFoundImage = By.className("Track_NotFound__6oaoY");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderNotFoundImageDisplayed() {
        return driver.findElement(orderNotFoundImage).isDisplayed();
    }
}
