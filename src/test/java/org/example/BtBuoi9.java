package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BtBuoi9 {
    WebDriver Driver;
    @Before
    public void Test_befor(){
        WebDriverManager.chromedriver().setup();
        this.Driver =new ChromeDriver();
        this.Driver.manage().window().maximize();
    }

    @After
    public void AfterTest() throws InterruptedException {
        Thread.sleep(5000);
        this.Driver.quit();
    }

    @Test
    public void BT1(){
        this.Driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");

        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        
    }




}
