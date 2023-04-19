package ns;

import org.testng.annotations.Test;

public class TitleLinkedin extends BaseTest {
    @Test
    public void lin() {
        String s;
        driver.get("http://www.linkedin.com");
        s = driver.getTitle();
        System.out.println(s);
    }

}
