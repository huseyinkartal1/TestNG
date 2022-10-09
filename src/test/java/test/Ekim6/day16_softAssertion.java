package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class day16_softAssertion {

    WebDriver driver;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://zero.webappsecurity.com/");




    }


    @Test
    public void test1(){

        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();

        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

       WebElement element=driver.findElement(By.id("pc_currency"));

       Select option= new Select(element);
        option.selectByValue("EUR");

        SoftAssert softAssert = new SoftAssert();

        var actual = option.getFirstSelectedOption().getText();
        String expected="Eurozone (euro)";

        softAssert.assertTrue(actual.contains(expected));


        option.selectByVisibleText("Switzerland (franc)");

        var actualSECLECTED = option.getFirstSelectedOption().getText();
        String expected2="Switzerland (franc)";
        softAssert.assertTrue(actualSECLECTED.contains(expected2));

 /*       var elements = option.getOptions();

        for (WebElement each:elements){
          softAssert.assertTrue(each.getText().contains(expected2));
        }*/

        softAssert.assertAll();

    }




}
