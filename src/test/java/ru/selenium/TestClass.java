package ru.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.selenium.LoginHelper.*;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void checkLogin() throws InterruptedException {
        driver.get(MainPage.LINK);

        WaitHelper.closeBanners(driver);
        loginMainPageIframe(driver, wait);
        notARobot(driver, wait);
        skipOtp();
        enterPass(driver, wait);

        wait.until(ExpectedConditions.titleContains("Входящие - Почта Mail"));
    }

    @AfterEach
    public void shutdown() {
        //if (driver != null) driver.quit();
    }
}
