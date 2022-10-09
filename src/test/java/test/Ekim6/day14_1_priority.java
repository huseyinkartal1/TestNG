package test.Ekim6;

import org.testng.annotations.Test;

public class day14_1_priority {

    @Test (priority =1)

    public void youtube()
    {

        System.out.println("youtube");
    }

    @Test(priority = 2)
    public void amazon(){

        System.out.println("amazon");
    }


    @Test(priority = 3)
    public void bestbuy(){

        System.out.println("bestbuy");
    }
}
