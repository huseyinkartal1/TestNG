package test.Ekim7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Day17_basic_auth {

    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass

    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/basic_auth");



    }

    @Test
    public void TestBasic(){

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement element=driver.findElement(By.tagName("h3"));

        var actual = element.getText();
        String expected="Basic Auth";


        softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expected);


    }

@AfterClass

    public void  tearDown() {
        softAssert.assertAll();
        driver.close();


}
}
