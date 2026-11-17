package ru.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestWithChromeProfile extends BaseTest {

    @Override
    @BeforeEach
    public void start() {
        // Создаем специфичные опции
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getenv("userDataDir"));
        options.addArguments("--profile-directory=" + System.getenv("profileDirectory"));
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        // Инициализируем драйвер через менеджер с этими опциями
        DriverManager.initDriver(options);

        // Настраиваем wait
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    @Test
    void loggedIn() {
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://mail.ru");
    }
}