package ns.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @Test
    public static void gridd() throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setBrowserName("MicrosoftEdge");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), des);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }

}
