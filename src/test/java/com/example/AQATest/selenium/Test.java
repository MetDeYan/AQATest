package com.example.AQATest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/INTEXSOFT/denis.metelitsa/Program/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //xpath
//        WebElement fieldSearch = driver.findElement(By.xpath("//input[@aria-label='Search']"));
//        WebElement buttonSearch = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));

        //className
        WebElement fieldSearch = driver.findElement(By.className("gLFyf"));
        WebElement buttonSearch = driver.findElement(By.className("gNO89b"));

        //
//        WebElement fieldSearch = driver.findElement(By.xpath("//input[@aria-label='Search']"));
//        WebElement buttonSearch = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));

        fieldSearch.sendKeys("Маяковский");
        buttonSearch.submit();

    }

}
