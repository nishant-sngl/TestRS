package ns;

import org.testng.annotations.Test;

public class TitleGoogle extends BaseTest{
    @Test
    public void goo() {
        String s;
        driver.get("http://www.google.com");
        s = driver.getTitle();
        System.out.println(s);
    }
}
