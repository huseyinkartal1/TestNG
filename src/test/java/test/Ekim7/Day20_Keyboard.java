package test.Ekim7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day20_Keyboard extends TestBase {

    @Test
    public void test() throws InterruptedException {


        driver.get("https:/html.com/tags/iframe");

        Actions actions = new Actions(driver);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));

        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]"));

        actions.click(play).perform();

        Assert.assertFalse(play.isDisplayed());


    }


}
