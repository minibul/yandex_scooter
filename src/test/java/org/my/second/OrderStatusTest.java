package org.my.second;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.my.MainPage;
import org.my.OrderStatusPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest {

    private WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkOrderStatusForNonExistingOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("1");
        mainPage.clickSearchOrderButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        boolean isOrderNotFoundImageDisplayed = orderStatusPage.isOrderNotFoundImageDisplayed();

        assertTrue("Order not found image is not displayed", isOrderNotFoundImageDisplayed);

    }
}
