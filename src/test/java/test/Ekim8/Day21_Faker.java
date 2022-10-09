package test.Ekim8;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Day21_Faker extends TestBase {

    @Test
    public void faker() throws InterruptedException {

        driver.get("http://www.facebook.com");

        driver.findElement(By.linkText("Create New Account")).click();

        Actions actions = new Actions(driver);
        Faker faker = new Faker();


        WebElement isim = driver.findElement(By.name("firstname"));


        var s = faker.internet().emailAddress();

        isim.sendKeys(faker.name()
                        .firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                s);

        WebElement isim2 = driver.findElement(By.xpath("(//input[@type=\"text\"])[5]"));

        isim2.sendKeys(s,
                Keys.TAB,
                faker.internet().password(),
                Keys.TAB,
                Keys.TAB);

WebElement day = driver.findElement(By.xpath("//select[@title=\"Day\"]"));
        WebElement month = driver.findElement(By.xpath("//select[@title=\"Month\"]"));

        WebElement year = driver.findElement(By.xpath("//select[@title=\"Year\"]"));

        Select day1 = new Select(day);
        Select month1 = new Select(month);
        Select year1 = new Select(year);

day1.selectByValue("10");
month1.selectByValue("10");
year1.selectByValue("2000");

    WebElement male = driver.findElement(By.xpath("(//input[@name=\"sex\"])[2]"));

actions.click(male).perform();
  WebElement signUp = driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]"));
      //  actions.click(signUp).perform();

        Assert.assertTrue(male.isSelected(),"male seçili değil");

    }
}
