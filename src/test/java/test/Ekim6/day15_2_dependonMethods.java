package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class day15_2_dependonMethods {


    WebDriver driver;
    WebElement element;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");

         element =  driver.findElement(By.id("twotabsearchtextbox"));

    }


    @Test
    public void testlogo(){

      WebElement logo=  driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }


    @Test (dependsOnMethods = "testlogo")
    public void testNutella(){

        element.sendKeys("Nutella", Keys.ENTER);

       String actualArama= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div")).getText();
        String expected="Nutella";

        Assert.assertTrue(actualArama.contains(expected));

    }

    @Test (dependsOnMethods = "testNutella")
    public void testNutellaFiyat(){

        driver.findElement(By.xpath("//img[@class=\"s-image\"]")).click();


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
