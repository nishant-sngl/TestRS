package ns.practice;
import org.testng.annotations.Test;

import java.security.Timestamp;
import java.util.Date;

public class Testng1 {

    @Test(priority = -10, groups = {"browser"}, enabled = true)
    public void openBrowser(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    @Test
    public void landingPage(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test(groups = {"session"}, dependsOnMethods = "openBrowser")
    public void login(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
