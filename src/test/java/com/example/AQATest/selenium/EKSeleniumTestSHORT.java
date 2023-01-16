package com.example.AQATest.selenium;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EKSeleniumTestSHORT {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://expkeeper.intexsoft.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.name("username")).sendKeys("denis.metelitsa");
        driver.findElement(By.name("password")).sendKeys("Vfksirf2127_!");
        driver.findElement(By.cssSelector("button.login-form-button")).click();
    }

    @Test
    public void addNewLanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("header-profile"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a:nth-child(1) > .user-menu-item"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("tile__placeholder"))).click();
        new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-select-value-11 > span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-option-172 > span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-select-value-13"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-option-159 > span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-select-value-15 > span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mat-option-165 > span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.save-btn"))).click();
    }

}
