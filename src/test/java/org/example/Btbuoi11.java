package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Btbuoi11 {
    WebDriver driver;
    @Before
    public void BeforSetting(){
        WebDriverManager.chromedriver().setup();
        this.driver= new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://fptshop.com.vn/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @After
    public void AfterSetting() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }
@Test
    public void CheckSuggestionBox(){
        WebElement Input =this.driver.findElement(By.cssSelector("div.fs-search input.fs-stxt"));
        Input.sendKeys("Iphone 13 Pro Max");
    }
}
