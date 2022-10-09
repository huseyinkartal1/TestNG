package test.Ekim6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class day14_2_setup {

    WebDriver driver;


    @BeforeClass
    public void setup () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test (priority = 1)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        driver.getTitle();
    }

    @Test (priority = 2)
    public void github() {
        driver.get("https://www.github.com");
        driver.getTitle();

    }


    @Test (priority = 3)
    public void facebookTest() {
        driver.get("https://www.facebook.com");
        driver.getTitle();

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        driver.quit();
    }

}
