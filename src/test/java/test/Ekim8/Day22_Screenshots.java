package test.Ekim8;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Day22_Screenshots extends TestBase
{

    @Test
    public void screenshot() throws IOException {

        driver.get("http://www.amazon.com");

        WebElement arama= driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("java");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File file = new File("Screenshots/Ss1.png");

        File geciciFile =  ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciFile,file);

        arama.clear();arama.sendKeys("honey");
        File gecici1File =  ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici1File,file);

    }
}
