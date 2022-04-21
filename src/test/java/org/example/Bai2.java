package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        Thread.sleep(2000);
        this.Driver.quit();
    }

    @Test
    public void CheckvalidTime(){
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
        String date = simpleDateFormat.format(new Date());
//        String CheckDate = this.Driver.findElement(By.cssSelector("input[class^=MuiInputBase-input]")).getText();
        String CheckDate= this.Driver.findElement(By.xpath("// input[@value=\"21 April 2022\"]")).getAttribute("value").toLowerCase(Locale.ROOT);
        Assert.assertEquals(date,CheckDate);


        WebElement we = Driver.findElement(By.cssSelector("svg.MuiSvgIcon-root"));
        boolean actualValue = we.isEnabled();

        if (date==CheckDate) {
            Assert.assertTrue(!actualValue);







        }

    }


}
