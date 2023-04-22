package ns.practice;
import org.testng.annotations.Test;

public class Testng2 {

    @Test(priority = -1)
    public void placeOrder(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test(groups = {"session"})
    public void logout(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test(groups = {"browser"})
    public void closeBrowser(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
