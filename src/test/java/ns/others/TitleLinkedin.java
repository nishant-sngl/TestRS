package ns.others;

import ns.base.BaseTest;
import org.testng.annotations.Test;

public class TitleLinkedin extends BaseTest {
    @Test
    public void lin() {
        String s;
//        driver.get("http://www.linkedin.com");
        driver.get("https://www.flipkart.com/");
        s = driver.getTitle();
        System.out.println(s);
    }

}
