package ru.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static ru.selenium.LoginHelper.*;

public class TestClass extends BaseTest {

    @Test
    public void checkLogin() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver(); // <-- Получаем драйвер здесь

        driver.get(MainPage.LINK);

        WaitHelper.closeBanners(driver);
        loginMainPageIframe(driver, wait);
        notARobot(driver, wait);
        skipOtp();
        enterPass(driver, wait);
        wait.until(ExpectedConditions.titleContains("Входящие - Почта Mail"));
    }
}