package ru.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {

    // Убираем поле private WebDriver driver;
    // Теперь драйвер берется из DriverManager

    protected WebDriverWait wait;

    @BeforeEach
    public void start() {
        DriverManager.initDriver(); // Инициализируем драйвер в менеджере
        WebDriver driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void shutdown() {
        DriverManager.quitDriver(); // Закрываем и очищаем
    }
}