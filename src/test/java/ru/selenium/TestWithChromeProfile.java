package ru.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestWithChromeProfile extends BaseTest {

    // Переопределяем настройку, чтобы добавить профиль
    @Override
    protected void setupOptions(ChromeOptions options) {
        super.setupOptions(options); // Сначала вызываем базовую настройку (например, --start-maximized)

        String userDataDir = System.getenv("userDataDir");
        String profileDirectory = System.getenv("profileDirectory");

        options.addArguments("--user-data-dir=" + userDataDir);
        options.addArguments("--profile-directory=" + profileDirectory);
        options.addArguments("--remote-allow-origins=*");
    }

    @Test
    void loggedIn() {
        driver.get("https://mail.ru");
    }
}