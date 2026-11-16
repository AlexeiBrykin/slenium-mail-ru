package ru.selenium;

import org.openqa.selenium.WebDriver;

public final class WaitHelper {

    private WaitHelper() { }

    public static void closeBanners(WebDriver driver) {
        long start = System.currentTimeMillis();
        while ((System.currentTimeMillis() - start) < 10_000) {
            MainPage.closeAllBanners(driver);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}