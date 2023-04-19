package ns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest1 {

    @Test
    public static void gridd1() throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setBrowserName("firefox");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), des);
        driver.get("http://www.facebook.com");
        System.out.println(driver.getTitle());
    }

}
