package ru.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CapCheckChromeTest {

    private WebDriver driver;

    @Test
    void checkCapabilitiesChrome() {
        // 1. Создаём и настраиваем опции
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

        // 2. Передаём опции в драйвер при создании
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 3. Выводим фактические capabilities, которые "увидел" драйвер
        System.out.println(((ChromeDriver) driver).getCapabilities());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}