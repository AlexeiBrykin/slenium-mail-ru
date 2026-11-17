package ru.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    // Хранилище драйверов, изолированное для каждого потока
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // Метод для инициализации драйвера (можно передавать настройки)
    public static void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Здесь можно добавить любые другие базовые настройки
        // Например: options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driverThreadLocal.set(driver);
    }

    // Перегрузка для случаев, когда нужны специфичные опции (как в TestWithChromeProfile)
    public static void initDriver(ChromeOptions options) {
        WebDriver driver = new ChromeDriver(options);
        driverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove(); // Очищаем ThreadLocal
        }
    }
}