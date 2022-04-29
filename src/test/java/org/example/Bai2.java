package org.example;

import com.beust.ah.A;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import static io.netty.util.ResourceLeakDetector.isEnabled;

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
        //Get real date
        String pattern = "dd MMMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
        String date = simpleDateFormat.format(new Date());//get date is display
        String CheckDate = this.Driver.findElement(By.cssSelector("div.react-datepicker__input-container div.MuiInputBase-root  input.MuiInputBase-input")).getAttribute("value").toLowerCase(Locale.ROOT); // get date hien thi



      //Check Status buttonNext
        boolean StatusButtonNextRealDate =Driver.findElement(By.cssSelector("div.MuiInputAdornment-positionEnd button[class*=\"cc33\"]")).isEnabled();//get Status buttonNextrealdate
        WebDriverWait Waiter = new WebDriverWait(this.Driver, Duration.ofSeconds(15));

        this.Driver.findElement(By.cssSelector("div.MuiInputAdornment-positionStart button[class*=\"cc33\"]")).click(); //Click button back
        boolean StatusButtonNextOldDate =Driver.findElement(By.cssSelector("div.MuiInputAdornment-positionEnd button[class*=\"cc33\"]")).isEnabled();//Check Status buttonNextolddate

        this.Driver.findElement(By.cssSelector("div.react-datepicker__input-container  div.MuiOutlinedInput-adornedEnd")).click();
//        WebDriverWait wait = new WebDriverWait(Driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.react-datepicker-poppe")));
        WebElement DatePicker =Driver.findElement(By.cssSelector("div.react-datepicker-popper"));
        boolean CheckDatePicker =DatePicker.isDisplayed();


        Assert.assertEquals(date, CheckDate);// verify date
        Assert.assertTrue(!StatusButtonNextRealDate);//Check Status buttonNextrealdate
        Assert.assertTrue(StatusButtonNextOldDate);//Check Status buttonNextolddate
        Assert.assertEquals(true, CheckDatePicker); //Check Date Picker



    }
    @Test
    public void DatePicker(){
        this.Driver.findElement(By.cssSelector("div.react-datepicker__input-container div.MuiOutlinedInput-adornedEnd")).click();
        WebElement ClickButton = Driver.findElement(By.cssSelector("div.react-datepicker__month-container div.react-datepicker__day--004]"));
        ClickButton.click();
        String Actual = Driver.findElement(By.xpath("div.react-datepicker__input-container div.MuiOutlinedInput-adornedEnd")).getText();
        Assert.assertEquals("04 April 2022", Actual);
    }

    @Test
    public void CheckSourceCurrency(){
//        WebElement Currency =Driver.findElement(By.cssSelector(" div.MuiOutlinedInput-adornedEnd div.cc14 span.flag-eu"));
        String PageSourceCode =Driver.getPageSource();
        System.out.println(PageSourceCode);
    }

}




