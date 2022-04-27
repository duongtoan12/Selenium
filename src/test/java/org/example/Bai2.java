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
    public void Before() {
        WebDriverManager.chromedriver().setup();
        this.Driver = new ChromeDriver();
        this.Driver.manage().window().maximize();
        this.Driver.get("https://www.oanda.com/currency-converter/en/?from=EUR&to=USD&amount=1");
    }

    @After
    public void AfterTest() throws InterruptedException {
        Thread.sleep(2000);
        this.Driver.quit();
    }

    @Test
    public void CheckvalidTime() {
        //Check Validate
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
        String date = simpleDateFormat.format(new Date()); //get date now
        String CheckDate = this.Driver.findElement(By.cssSelector("div.react-datepicker__input-container div.MuiInputBase-root  input.MuiInputBase-input")).getAttribute("value").toLowerCase(Locale.ROOT); // get date hien thi
        Assert.assertEquals(date, CheckDate);// verify date




//         Check Status button
        WebElement StatusButton =Driver.findElement(By.cssSelector("div.MuiInputAdornment-positionEnd button[class*=\"cc33\"]"));
        StatusButton.isEnabled();
        if (date == CheckDate) {
            Assert.assertEquals(false, StatusButton);



        }






    }
//    @Test
//    public void DatePicker(){
//        this.Driver.findElement(By.xpath("// input[@value=\"21 April 2022\"]")).click();
//        String Expected = Driver.findElement(By.xpath("//*[@id=\"cc-main-conversion-block\"]/div/div[3]/div[1]/div[3]/div/div/div[3]/span[2]")).getText();
//        Assert.assertEquals("April 21, 2022", Expected);
//    }

}




