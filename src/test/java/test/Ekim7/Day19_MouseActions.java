package test.Ekim7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day19_MouseActions extends TestBase {

    @Test
    public void actions(){
        driver.get("https://www.amazon.com");

        var element = driver.findElement(By.xpath("//span[@class=\"nav-line-2 \"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

         driver.findElement(By.xpath("//span[@class=\"nav-text\"]")).click();

         var actualText = driver.findElement(By.xpath("//div[@role=\"heading\"]")).getText();
        var expectedText= "Your Lists";

        Assert.assertEquals(expectedText, actualText);
    }

}
