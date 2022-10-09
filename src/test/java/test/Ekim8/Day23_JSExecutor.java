package test.Ekim8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day23_JSExecutor extends TestBase {
    @Test
    public void JSExecutor(){

        driver.get("https://www.movita.com.tr");

        WebElement sell=driver.findElement(By.xpath("//strong[text()=\"tıklayınız\"]"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()",sell);

    }
}
