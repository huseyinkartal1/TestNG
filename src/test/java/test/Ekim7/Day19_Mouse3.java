package test.Ekim7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day19_Mouse3 extends TestBase {
    @Test
    public void test() {
        driver.get("https:/demoqa.com/droppable");

        WebElement element = driver.findElement(By.id("draggable"));
        WebElement element2 = driver.findElement(By.id("droppable"));



        Actions actions = new Actions(driver);


        actions.dragAndDrop(element,element2).perform();

        var actualResult = element2.getText();
        var expectedResult = "Dropped!";

        Assert.assertEquals(expectedResult, actualResult);

    }


}
