package ns.others;

import ns.base.BaseTest;
import org.testng.annotations.Test;

public class TitleFacebook extends BaseTest {
    @Test
    public void fac() {
        String s;
        driver.get("http://www.facebook.com");
        s = driver.getTitle();
        System.out.println(s);
    }
}
