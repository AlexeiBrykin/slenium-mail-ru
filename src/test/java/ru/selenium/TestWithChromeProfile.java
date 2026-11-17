package ru.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestWithChromeProfile {
    private final String USERDATADIR = System.getenv("userDataDir");
    private final String PROFILEDIRECTORY = System.getenv("profileDirectory");
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + USERDATADIR);
        options.addArguments("--profile-directory=" + PROFILEDIRECTORY);
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void loggedIn() {
        driver.get("https://mail.ru");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
