package test.Ekim7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day17_iframe {

    WebDriver driver;
    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/iframe");

    }


    @Test
    public void testIframe (){

        WebElement content = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(content.isEnabled());
        System.out.println(content.getText());

        driver.switchTo().frame(0);

        driver.findElement(By.tagName("p")).clear();
        driver.findElement(By.tagName("p")).sendKeys("Selam iframe");


        driver.switchTo().defaultContent();

        WebElement element2=  driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(element2.isDisplayed());
        System.out.println(element2.getText());
    }


    @Test
    public void testElementSelenium (){

//yeni bir test açtığımızda iframeden çıkmamıza gerek kalmıyor

    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(30000);
        driver.close();
    }


}
