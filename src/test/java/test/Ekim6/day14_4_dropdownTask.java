package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class day14_4_dropdownTask {


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
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement element=  driver.findElement(By.id("dropdown"));


        Select options = new Select(element);
        options.selectByIndex(1);


        options.selectByValue("2");


        for (WebElement each: options.getOptions()) {

            System.out.println(each.getText());
        }


        int dropdownSize=options.getOptions().size();
        System.out.println("Dropdown size: "+dropdownSize);


       Assert.assertEquals(dropdownSize,4,"FALSE");

        driver.close();
}
}
