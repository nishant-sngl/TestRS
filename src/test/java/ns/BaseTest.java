package ns;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import ns.pages.LandingPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    String browser;
    LandingPage landingPage;

    @BeforeMethod(alwaysRun = true)
    public LandingPage init(ITestContext context) throws IOException {
        driver = initializeTest(context);
        landingPage = new LandingPage(driver);
                landingPage.launchApplication();
                return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.close();
    }
    public WebDriver initializeTest(ITestContext context) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/ns/resources/config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        if (System.getProperty("browser") == null)
            browser = prop.getProperty("browser");
        else browser = System.getProperty("browser");
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                context.setAttribute("WebDriver", driver);
                break;
            case "grid":
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
                DesiredCapabilities des = new DesiredCapabilities();
                des.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"), des);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> userData;
        File fileObj = new File(System.getProperty("user.dir")+ "/src/main/java/ns/resources/data.json");
        userData = mapper.readValue(
                fileObj, new TypeReference<List<HashMap<String, String>>>() {
                });
        System.out.println(userData.toString());
        return userData;
    }

    public String takeScreenshot(String tc, WebDriver driver) throws IOException {
        String f = System.getProperty("user.dir") + "/reports/";
        String fileName = tc + ".png";
        TakesScreenshot sc = (TakesScreenshot) driver;
        File file = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(f+fileName));
        return fileName;
    }

}
