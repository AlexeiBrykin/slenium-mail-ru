package ru.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginHelper {
    static void loginMainPageIframe(WebDriver driver, WebDriverWait wait) {
        driver.findElement(By.xpath("//a[text()='Войти']")).click();            //клик вход
        WebElement loginIframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe.ag-popup__frame__layout__iframe")));                  //поиск iframe логина
        driver.switchTo().frame(loginIframe);                                                //переключение на iframe логина
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));           //поиск поля ввода почты
        driver.findElement(By.id("email")).sendKeys(System.getenv("testMail"));        //ввод почты
        driver.findElement(By.cssSelector("button[data-test-id='continue-button']")).click();//клик вход
        driver.switchTo().defaultContent();                                                  //возвращение из iframe логина
    }

    static void skipOtp() throws InterruptedException {
        Thread.sleep(30_000);
    }

    static void notARobot(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[src*='id.vk.ru/not_robot_captcha']")
        ));

        WebElement checkboxLabel = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("label[for='checkbox:not-robot-captcha-checkbox:input']")
        ));

        new Actions(driver).moveToElement(checkboxLabel).pause(Duration.ofMillis(300)).click().perform();

        wait.until(d -> d.findElement(
                By.cssSelector("input[data-test-id='not-robot-captcha-checkbox-input']")
        ).isSelected());
        driver.switchTo().defaultContent();
    }

    static void enterPass(WebDriver driver, WebDriverWait wait) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='password']")
        ));
        passwordInput.sendKeys(System.getenv("passwordMail"));
        driver.findElement(By.xpath("//button[contains(., 'Continue')]")).click();
    }
}
