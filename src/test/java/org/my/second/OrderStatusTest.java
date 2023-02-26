package org.my.second;

import org.junit.Test;
import org.my.MainPage;
import org.my.OrderStatusPage;

import static org.junit.Assert.assertTrue;

public class OrderStatusTest extends BaseUITest{

    @Test
    public void checkOrderStatusForNonExistingOrder() {
        driver.get(MainPage.URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("1");
        mainPage.clickSearchOrderButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);
        boolean isOrderNotFoundImageDisplayed = orderStatusPage.isOrderNotFoundImageDisplayed();

        assertTrue("Order not found image is not displayed", isOrderNotFoundImageDisplayed);

    }

    @Test
    public void checkOrderStatusForNonExistingOrder2() {
        driver.get(MainPage.URL);

        boolean isOrderNotFoundImageDisplayed = new MainPage(driver)
                .clickOrderStatusButton()
                .enterOrderNumber("1")
                .clickSearchOrderButton()
                .isOrderNotFoundImageDisplayed();

        assertTrue("Order not found image is not displayed", isOrderNotFoundImageDisplayed);

    }
}
