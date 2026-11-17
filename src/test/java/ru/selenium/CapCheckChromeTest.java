package ru.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapCheckChromeTest extends BaseTest {

    @Test
    void checkCapabilitiesChrome() {
        WebDriver driver = DriverManager.getDriver(); // <-- Получаем драйвер
        System.out.println(((ChromeDriver) driver).getCapabilities());
    }
}