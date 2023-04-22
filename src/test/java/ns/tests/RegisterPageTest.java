package ns.tests;

import ns.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterPageTest extends BaseTest {
    @Test
    public void validateRegisterPageLabel() throws IOException {
        Assert.assertEquals(landingPage.getRegisterPageLabel(), "Register");
    }
}
