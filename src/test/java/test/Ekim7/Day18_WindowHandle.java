package test.Ekim7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day18_WindowHandle {

    WebDriver driver;
    @BeforeClass
    public void  setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }


    @Test
    public void windowHandle(){

        driver.get("https:/www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https:/www.bestbuy.com");
        String bestHandle = driver.getWindowHandle();
        System.out.println("bestHandle = " + bestHandle);

        System.out.println("TUM driver.getWindowHandles() = " + driver.getWindowHandles());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:/www.facebook.com");
        String facebookHandle = driver.getWindowHandle();
        System.out.println("facebookHandle = " + facebookHandle);

        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        driver.switchTo().window(bestHandle);
        var actualBestTitle = driver.getTitle();
        var expectedBestTitle = "Best Buy International: Select your Country - Best Buy";
        Assert.assertEquals(actualBestTitle,expectedBestTitle);

        driver.switchTo().window(facebookHandle);
        var actualFaceTitle = driver.getTitle();
        var expectedFaceTitle = "Facebook – log in or sign up";
        Assert.assertEquals(actualFaceTitle,expectedFaceTitle);


    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }









}
