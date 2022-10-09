package test.Ekim8;


import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Day21_Cookies  extends TestBase {


    @Test
    public void test(){
        driver.get("https://www.amazon.com");


        for ( Cookie c :driver.manage().getCookies() ){

            System.out.println(c);
        }


    }
}
