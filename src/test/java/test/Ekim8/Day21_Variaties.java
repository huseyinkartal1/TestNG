package test.Ekim8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class Day21_Variaties extends TestBase {



    @Test
    public void implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://the-internet.herokuapp.com/dynamic_controls");



        var removeButton = driver.findElement(By.xpath("//button[@type='button']"));

        removeButton.click();


        var message = driver.findElement(By.id("message"));
        String messageText=message.getText();
        Assert.assertEquals(messageText,"It's gone!");

        var addButton = driver.findElement(By.xpath("//button[@type='button']"));

        addButton.click();


        var message2 = driver.findElement(By.id("message"));
        String messageText2=message2.getText();
        Assert.assertEquals(messageText2,"It's back!");




    }

    @Test
    public void expilictyWait(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");



        var removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();


      // var message = driver.findElement(By.id("message"));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        String messageText=message.getText();
        Assert.assertEquals(messageText,"It's gone!");

        var addButton = driver.findElement(By.xpath("//button[@type='button']"));

        addButton.click();


       // var message2 = driver.findElement(By.id("message"));
        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        String messageText2=message2.getText();
        Assert.assertEquals(messageText2,"It's back!");

    }
}
