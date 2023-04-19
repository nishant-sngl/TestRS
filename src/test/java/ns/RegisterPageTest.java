package ns;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class RegisterPageTest extends BaseTest {
    @Test
    public void validateRegisterPageLabel() throws IOException {
        Assert.assertEquals(landingPage.getRegisterPageLabel(), "Register");
    }
}
