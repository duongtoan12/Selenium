package org.example;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.checkerframework.checker.units.qual.C;
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
        WebElement OpenDatePicker =Driver.findElement(By.cssSelector("div[class*=\"cc36\"]"));
        OpenDatePicker.click();;
        WebElement ChooseDay = Driver.findElement(By.cssSelector("div.react-datepicker__month-container div[aria-label*=\"May 4th\"]"));
        ChooseDay.click();
        String Actual = Driver.findElement(By.cssSelector("div[class*=\"cc36\"] input.MuiOutlinedInput-inputAdornedEnd")).getAttribute("value");
//        System.out.println(Actual);
        Assert.assertEquals("04 May 2022", Actual);

    }

    @Test
    public void CheckPickerCurrency(){
        WebElement Currency =Driver.findElement(By.cssSelector("div[class*=\"cc13\"] button.MuiAutocomplete-popupIndicator"));Currency.click();
       WebElement ClickCurrency =Driver.findElement(By.cssSelector("li#baseCurrency_currency_autocomplete-option-1 div.cc8"));
       ClickCurrency.click();
       String CheckHienThi =Driver.findElement(By.cssSelector("div[class*=\"cc13\"] div.cc5")).getText();
       Assert.assertEquals("GBP", CheckHienThi);

    }

    @Test
    public void DesstinationCurrency(){
        WebElement Currency =Driver.findElement(By.cssSelector("div[class=\"MuiAutocomplete-root MuiAutocomplete-hasClearIcon MuiAutocomplete-hasPopupIcon\"]  button.MuiAutocomplete-popupIndicator"));

        Currency.click();
        WebElement ClickCurrency =Driver.findElement(By.cssSelector("li#quoteCurrency_currency_autocomplete-option-3"));
        ClickCurrency.click();
        String CheckHienThi =Driver.findElement(By.cssSelector("div[class=\"MuiAutocomplete-root MuiAutocomplete-hasClearIcon MuiAutocomplete-hasPopupIcon\"] div.cc14")).getText();
        Assert.assertEquals("AED", CheckHienThi);
    }




}



