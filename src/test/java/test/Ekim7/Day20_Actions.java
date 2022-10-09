package test.Ekim7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day20_Actions extends TestBase {

    @Test

    public void test() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions");

        Actions actions = new Actions(driver);

        WebElement hoverOver1=  driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));
        actions.moveToElement(hoverOver1).perform();
        WebElement link1=  driver.findElement(By.xpath("//a[text()=\"Link 1\"]"));
        actions.click(link1).perform();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement hoverOver2=  driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[2]"));
        actions.moveToElement(hoverOver2).perform();
        WebElement link2=  driver.findElement(By.xpath("(//a[text()=\"Link 1\"])[2]"));
        actions.click(link2).perform();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement hoverOver3=  driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[3]"));
        actions.moveToElement(hoverOver3).perform();
        WebElement link3=  driver.findElement(By.xpath("(//a[text()=\"Link 1\"])[3]"));
        actions.click(link3).perform();
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement clickHold=  driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();
        Thread.sleep(2000);
        actions.release().perform();


        WebElement doubleClick= driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClick).perform();
        Thread.sleep(2000);

    }



}
