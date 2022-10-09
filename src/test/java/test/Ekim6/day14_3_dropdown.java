package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class day14_3_dropdown {


    WebDriver driver;
    @BeforeClass
    public void setup () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");

  WebElement element=  driver.findElement(By.id("searchDropdownBox"));


        Select options = new Select(element);
        options.selectByIndex(1);

    }




}
