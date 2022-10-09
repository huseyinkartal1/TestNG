package test.Ekim7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day19_Mouse2 extends TestBase {



    @Test
    public void test() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");

        var element = driver.findElement(By.id("click-box"));

        System.out.println("element.getText() = " + element.getText());

        Actions actions = new Actions(driver);

        actions.clickAndHold(element).perform();
        System.out.println("element.getText() = " + element.getText());
        Thread.sleep(5000);
        actions.release().perform();
        System.out.println("element.getText() = " + element.getText());


    }
}
