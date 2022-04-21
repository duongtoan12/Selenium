package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bai2 {

    WebDriver Driver;
    @Before
    public void Before(){
        WebDriverManager.chromedriver().setup();
        this.Driver = new ChromeDriver();
        this.Driver.manage().window().maximize();
        this.Driver.get("https://www.oanda.com/currency-converter/en/?from=EUR&to=USD&amount=1");
    }

    @After
    public void AfterTest() throws InterruptedException{
        Thread.sleep(5000);
        this.Driver.quit();
    }

    @Test
    public void CheckvalidTime(){
        WebElement tbbutton =this.Driver.findElement(By.cssSelector("#cc-main-conversion-block > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2 > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-align-items-xs-center.MuiGrid-grid-xs-12.MuiGrid-grid-sm-6 > div.react-datepicker-wrapper.cc37 > div > div > div.MuiInputAdornment-root.MuiInputAdornment-positionStart > button > span.MuiIconButton-label > svg"));
    }

}
