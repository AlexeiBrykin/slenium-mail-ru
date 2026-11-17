package ru.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapCheckChromeTest extends BaseTest {

    @Test
    void checkCapabilitiesChrome() {
        // Драйвер уже создан и передан в BaseTest.
        // Мы просто выводим capabilities.
        System.out.println(((ChromeDriver) driver).getCapabilities());
    }
}