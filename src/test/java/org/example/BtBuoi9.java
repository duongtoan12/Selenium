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
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        String Null = this.Driver.findElement(By.id("auth-block__form-group__email-error")).getText();
        Assert.assertEquals(Null,"Vui lòng nhập dữ liệu");
//
    }



    @Test
    public void CheckInvalidEmail(){
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc123");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        String InvalidEmail = this.Driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[1]/text()")).getText();
        Assert.assertEquals(InvalidEmail,"- Tài khoản không tồn tại, vui lòng kiểm tra lại");
    }


    @Test
    public void CheckInvalidPass(){
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan0310@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc12");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        String TbInvalidPass = this.Driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[1]/text()")).getText();
        Assert.assertEquals(TbInvalidPass,"- Mật khẩu không đúng, vui lòng kiểm tra lại");
    }

    @Test
    public void ValidData()

    {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan0310@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc123");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        String LoginSuccess = this.Driver.findElement(By.xpath("//*[@id=\"user-info__dropdown\"]/div[1]/span[1]")).getText();
        Assert.assertEquals(LoginSuccess,"Toàn Dương");
    }





}
