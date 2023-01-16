package com.example.AQATest.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    @Test
    public void googleTest() {
        System.setProperty("webdriver.chrome.driver", "/home/INTEXSOFT/denis.metelitsa/Program/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //id - но у большинства элементов теперь нет id
        //linkText, partialLinkText, name, tagName
        //xpath
//        WebElement fieldSearch = driver.findElement(By.xpath("//input[@aria-label='Search']"));
//        WebElement buttonSearch = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));
        //className
//        WebElement fieldSearch = driver.findElement(By.className("gLFyf"));
//        WebElement buttonSearch = driver.findElement(By.className("gNO89b"));
        //cssSelector
        WebElement fieldSearch = driver.findElement(By.cssSelector("input.gLFyf"));
        WebElement buttonSearch = driver.findElement(By.cssSelector("input.gNO89b"));

        fieldSearch.sendKeys("Уолтер Уайт");
        buttonSearch.submit();
    }

}
