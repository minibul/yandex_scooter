package org.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

     public static final String URL = "https://qa-scooter.praktikum-services.ru/";
     private  final WebDriver driver;
     private final By orderStatusButton = By.className("Header_Link__1TAG7");
     private final By orderNumberInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
     private final By searchOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

     public MainPage(WebDriver driver) {
          this.driver = driver;
     }

     public MainPage clickOrderStatusButton() {
          driver.findElement(orderStatusButton).click();
          return this;
     }

     public MainPage enterOrderNumber(String orderNumber) {
          driver.findElement(orderNumberInput).sendKeys(orderNumber);
          return this;
     }

     public OrderStatusPage clickSearchOrderButton() {
          driver.findElement(searchOrderButton).click();
          return new OrderStatusPage(driver);
     }
}