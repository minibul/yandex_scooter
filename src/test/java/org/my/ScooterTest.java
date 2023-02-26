package org.my;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class ScooterTest {

    @Test
    public void orderTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.className("Header_Link__1TAG7")).click();
        driver.findElement(By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']")).sendKeys("1");
        driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']")).click();

        boolean result = driver.findElement(By.className("Track_NotFound__6oaoY")).isDisplayed();
        driver.quit();
        assertTrue(result);

    }
}
