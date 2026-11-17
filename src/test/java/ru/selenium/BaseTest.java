package ru.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // 1. Метод для настройки опций. Наследники могут его переопределить,
    // если им нужны специфические настройки (например, профиль).
    protected void setupOptions(ChromeOptions options) {
        options.addArguments("--start-maximized");
    }

    @BeforeEach
    public void start() {
        ChromeOptions options = new ChromeOptions();
        setupOptions(options); // Вызываем метод, который могут переопределить наследники

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
    }
}