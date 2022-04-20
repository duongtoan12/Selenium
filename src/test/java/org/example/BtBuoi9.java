package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BtBuoi9 {
    WebDriver Driver;
    String URL_login = "http://localhost/wp/wp-login.php";

    @Before
    public void Test_befor(){
        WebDriverManager.chromedriver().setup();
        this.Driver =new ChromeDriver();
        this.Driver.manage().window().maximize();
        this.Driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");
    }

    @After
    public void AfterTest() throws InterruptedException
    {
        Thread.sleep(5000);
        this.Driver.quit();
    }

    @Test
    public void CheckNull()// Check null

    {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        WebElement LinkText = this.Driver.findElement(By.linkText("Vui lòng nhập dữ liệu"));
        Assert.assertEquals(true, LinkText);




//        String ExpectedURL = Driver.getCurrentUrl();
//        Assert.assertTrue(ExpectedURL.startsWith("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F"));

    }

    @Test
    public void ValidData()

    {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan0310@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc123");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        this.Driver.findElement(By.cssSelector("span.user-name-col")).click();
        this.Driver.findElement(By.cssSelector("a.user-name-label")).click();
        String ExpectedURL = Driver.getCurrentUrl();

        Assert.assertTrue(ExpectedURL.startsWith("https://fado.vn/quan-ly-tai-khoan"));

    }





}
