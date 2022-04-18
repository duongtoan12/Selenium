package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CellPhonesLocator {
    WebDriver driver;
    @Before
    public void initTest()
    {
        //Khai báo webdriver ở chỗ nào.
        //Làm tự động? - thư viện webdrivermanager
        WebDriverManager.chromedriver().setup(); //tự động tải webdriver phù hợp với webbrowser
        //
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @After
    public void AfterTest() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test
    public void Try_to_search() throws InterruptedException {
        this.driver.get("https://cellphones.com.vn");
        //Nhập iphone 12 promax vào keyword -> enter để tìm kiếm
        //WebElement tbSearch = this.driver.findElement(By.id("search"));
        //WebElement tbSearch = this.driver.findElement(By.name("q"));

        ((JavascriptExecutor)this.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        //this.driver.findElement(By.className("btn-back-to-top")).click();
        this.driver.findElement(By.linkText("Tuyển dụng")).click(); //Chỉ làm việc với Hyperlink
    }

    @Test
    public void Test_CSSLocator()
    {
        /*
        Locator phức tạp (ko dùng dc với các locator theo attribute của html (id, name, clasName, linkText):
        //Từ dấu hiệu trở lên
        //2 loại locator hỗ trợ: cssLocator, xPath
         */
        //CSS Locator
        //tag + id: cú pháp: tagname#id_value vidu: input#login-email
        //tag + class value cú pháp: tagname.sigleclassvalue ví dụ:span.register-btn
        //tag + attribute: cú pháp : tagname[attribute="value"] ví dụ: input[type="email"]
        //combine > 2 giá trị cú pháp: viết lần lượt từng quy tắc
        /*tương đối theo giá trị thuộc tính: ^="value" - thuộc tính có giá trị bắt đầu bằng value
                                            $="value" - thuộc tính có giá trị kết thúc bằng value
                                            *="value" - thuộc tính có giá trị chứa value

                input[class^="FormSearch__Input"]
                input[class$="gBxvSE"]
        Ví dụ: input[data-spm-anchor-id*="login_signup"]
        */

        //kết 2 biếu locator với nhau: viết 2 biểu thức locator sau đó dùng quan hệ của thằng con với cha để
        //xác định đến element mình muốn.
        //absolute: trong TH ko xác định dc đến Element mình muốn, nhưng lại xác định đc đén element cha
        //thì dùng quy tắc <parent locator> > <child locator> ví dụ: div.mod-input-loginName>input
        //relative div.mod-input-loginName input (con gián tiếp) ví dụ: div.mod-input-loginName input

        this.driver.get("https://sea.banggood.com/login.html");
        WebElement tbUsername = this.driver.findElement(By.cssSelector("input#login-email"));
        tbUsername.sendKeys("khanh.tx@live.com");

        this.driver.findElement(By.cssSelector("span.register-btn")).click();

        this.driver.get("http://testmaster.vn/admin");
        WebElement tbTMSUsername = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        tbTMSUsername.sendKeys("khanh.tx@live.com");
        WebElement tbTMSPwd = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        tbTMSPwd.sendKeys("abc123");

        this.driver.get("https://www.tiki.vn/");
        //WebElement tbSearch = this.driver.findElement(By.cssSelector("input.FormSearch__Input-sc-1fwg3wo-2[data-view-id=\"main_search_form_input\"]"));
        //WebElement tbSearch = this.driver.findElement(By.cssSelector("input[class^=\"FormSearch__Input\"]"));
        WebElement tbSearch = this.driver.findElement(By.cssSelector("input[class$=\"gBxvSE\"]"));
        tbSearch.sendKeys("Iphone12");

        /*
        this.driver.get("https://member.lazada.vn/user/login?spm=a2o4n.home.header.d5.1905e182MrS0t3&redirect=https%3A%2F%2Fwww.lazada.vn%2F");
        WebElement lzUsername = this.driver.findElement(By.cssSelector("input[data-spm-anchor-id*=\"login_signup\"]"));
        lzUsername.sendKeys("Khanh.tx@live.com");

         */
    }

    @Test
    public void XPath_Locator()
    {
        /*
        XPATH (Path - đường dẫn). Là một quy tắc xác định đến các element dựa vào path trong tài liệu XML
        Xpath sử dụng / - cho đường dẫn tuyệt tối (absolute path)
        ví dụ: /html/body/div
        sử dụng: khi mình muốn quy tắc quan hệ chặt chẽ giữa các lement, phải theo đúng thứ tự trong biểu thức
        Xpath sử dụng // - cho đường dẫn tương đối (relative path)
        ví dụ: //div
        sử dụng khi không cần biết quan hệ giữa element này với element chứa nó.

        Có thể sử dụng attribute kết hợp tag để xác định trong các path
        //div[@id="itme"] - xác định đến element div có thuộc tính id = "itme"
        //div[@class="login-title"]/h3 - xác định đến tag h3 là con con của div mà có thuộc tính class = login-title

        Người sử dụng thuộc tính trong các path, còn có thể sử dụng các method trong biểu thức xpath
        text() - lấy inner text hiển thị trên element
        ví dụ: tham chiếu đên thẻ button có text hiển thị là Login
        //button[text()="LOGIN" ]
        //button[text()="LOGIN" or text()="Đăng nhập"]  - xác định đến button có text là Login hoặc "đăng nhập"

        contants(attriute, value) - lấy các lement có giá trị của thuộc tính attribute chứa value
        ví dụ: //button[contains(@class, "next-btn-primary")]
        */

        WebElement btn = this.driver.findElement(By.xpath(""));
    }


}
