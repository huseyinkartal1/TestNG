package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class day15_1_dropdownAmazon {

    WebDriver driver;
    Select dropdown;
    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");

        WebElement element =  driver.findElement(By.id("searchDropdownBox"));
         dropdown =new Select(element);
    }
    @Test
    public void test1(){

        var options = dropdown.getOptions().size();
        Assert.assertEquals(options,45,"Eleman sayisi 45 değildir.");


    }

@Test
    public void test2(){

    dropdown.selectByVisibleText("Books");

    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
    String actual=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div")).getText();

    System.out.println(actual);

Assert.assertTrue(actual.contains("Java"));



}



@AfterClass
    public void tearDown(){
        driver.quit();
}


}
