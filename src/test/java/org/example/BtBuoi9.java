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
import org.openqa.selenium.support.Color;

import java.time.Duration;

public class BtBuoi9 {
    WebDriver Driver;
    @Before
    public void Test_befor(){
        WebDriverManager.chromedriver().setup();
        this.Driver =new ChromeDriver();
        this.Driver.manage().window().maximize();
        this.Driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F");
        this.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void AfterTest() throws InterruptedException
    {
        Thread.sleep(2000);
        this.Driver.quit();
    }

    @Test
    public void CheckBlank()// Check null

    {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));// find textbox email
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]")); /// find textbox pass
        TbEmail.clear();
        TbPass.clear();
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();// click button
        String Blank = this.Driver.findElement(By.id("auth-block__form-group__email-error")).getText();// get thông báo

        //Get mã màu thông báo
        String rgbFormatThongBao =this.Driver.findElement(By.id("auth-block__form-group__email-error")).getCssValue("color");
        String hexcolorThongBao = Color.fromString(rgbFormatThongBao).asHex();

        //Get mã màu border
        String rgbFormatborderInput = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email.my-form-control")).getCssValue("border-color");
        String hexcolorborderInput = Color.fromString(rgbFormatborderInput).asHex();
        // Check mã màu thông báo lỗi
        Assert.assertEquals("#cc353b",hexcolorThongBao);

        // Check mã màu border
        Assert.assertEquals("#cc353b",hexcolorborderInput);

        // Check data
        Assert.assertEquals("Vui lòng nhập dữ liệu", Blank);



//
    }



    @Test
    public void CheckInvalidEmail() throws InterruptedException {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbEmail.sendKeys("duongdinhtoan@gmail.com");
        TbPass.sendKeys("Abc123");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(5000);
        String InvalidEmail = this.Driver.findElement(By.xpath("//*[@id=\"auth-block__login-form\"]/div[1]/br[2]")).getText();
        InvalidEmail.split("- " );
    }

    @Test
    public void CheckInvalidPass() throws InterruptedException {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan0310@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc12");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(5000);
        WebElement TbInvalidPass = this.Driver.findElement(By.cssSelector("div.my-alert"));


    }

    @Test
    public void ValidData() throws InterruptedException {
        WebElement TbEmail = this.Driver.findElement(By.cssSelector("input#auth-block__form-group__email"));
        TbEmail.sendKeys("duongdinhtoan0310@gmail.com");
        WebElement TbPass = this.Driver.findElement(By.cssSelector("input[type=\"password\"]"));
        TbPass.sendKeys("Abc123");
        this.Driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(5000);
        String LoginSuccess = this.Driver.findElement(By.cssSelector("span.user-name-col")).getText();
        Assert.assertEquals("Toàn Dương", LoginSuccess);
    }


}
