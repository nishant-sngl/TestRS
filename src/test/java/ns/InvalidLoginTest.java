package ns;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest{

    @Test(groups = {"negative","sanity"})
    public void invalidEmail() throws InterruptedException {
        String s = landingPage
                .validateInvalidLogin("sss@sss.com", "sd");
        System.out.println(s);
        Assert.assertTrue(s.contains("Incorrect"));
    }
}
