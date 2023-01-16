package com.example.AQATest.selenium;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EKSeleniumTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://expkeeper.intexsoft.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement fieldUserName = driver.findElement(By.name("username"));
        WebElement fieldPassword = driver.findElement(By.name("password"));
        fieldUserName.sendKeys("denis.metelitsa");
        fieldPassword.sendKeys("Vfksirf2127_!");
        WebElement logInButton = driver.findElement(By.cssSelector("button.login-form-button"));
        logInButton.click();
    }

    @Test
    public void addNewLanguage() {
        WebElement headerProfileButton = driver.findElement(By.className("header-profile-info__name"));
        headerProfileButton.click();

        WebElement profileButton = driver.findElement(By.className("user-menu-item"));
        profileButton.click();

        WebElement addLanguageButton = driver.findElement(By.className("tile__placeholder"));
        addLanguageButton.click();

        new NgWebDriver((JavascriptExecutor) driver).waitForAngularRequestsToFinish();

        WebElement languageButton = driver.findElement(By.cssSelector("#mat-select-value-11 > span"));
        languageButton.click();

        WebElement selectedLanguageButton = driver.findElement(By.cssSelector("#mat-option-102 > span"));
        selectedLanguageButton.click();

        WebElement readWriteLevelButton  = driver.findElement(By.cssSelector("#mat-select-value-13"));
        readWriteLevelButton.click();

        WebElement selectedReadWriteLevelButton = driver.findElement(By.cssSelector("#mat-option-89 > span"));
        selectedReadWriteLevelButton.click();

        WebElement spokenLevel = driver.findElement(By.cssSelector("#mat-select-value-15 > span"));
        spokenLevel.click();

        WebElement selectedSpokenLevel = driver.findElement(By.cssSelector("#mat-option-95 > span"));
        selectedSpokenLevel.click();

        WebElement addButton = driver.findElement(By.cssSelector("button.save-btn"));
        addButton.click();
    }

}
