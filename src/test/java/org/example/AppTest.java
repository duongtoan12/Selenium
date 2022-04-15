package org.example;

import static org.junit.Assert.assertTrue;

import com.google.common.primitives.Booleans;
import org.junit.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {
    WebDriver Driver;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.gecko.driver", "D:\\tài liệu automation testing\\Driver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\tài liệu automation testing\\Driver\\chromedriver_win32\\chromedriver.exe");
        this.Driver = new ChromeDriver();
        this.Driver = new FirefoxDriver();
        Driver.manage().window().maximize();
        Driver.get("https://www.google.com");

    }

    @After
    public void AfterTest (){
        this.Driver.quit();
        this.Driver.close();
    }

    @Test
    public void Titlename() {

        String Title = Driver.getTitle();
        int TitleLength = Driver.getTitle().length();
        System.out.println(Title);
        System.out.println(TitleLength);

    }

    @Test
    public void verifyURL(){
        String ExpectedURL = Driver.getCurrentUrl();
        Assert.assertTrue(ExpectedURL.startsWith("https://google.com"));
    }

    @Test
    public void GetSourceCode(){
        String PageSource = Driver.getPageSource();
        int PageSourcelength =PageSource.length();
        System.out.println("page source code là " + PageSource);
        System.out.println("length page source code là " + PageSourcelength);
    }


    @Test
    public void windowncommand(){
        this.Driver.manage().window().maximize();
        this.Driver.manage().window().minimize();
        this.Driver.manage().window().fullscreen();
        this.Driver.manage().window().getSize();

    }



}
