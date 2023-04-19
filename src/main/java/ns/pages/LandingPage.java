package ns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement emailField;
    @FindBy(id = "userPassword")
    WebElement passwordField;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(xpath = "//a[@routerlink='/auth/register']")
    WebElement registerButton;

    @FindBy(xpath = "//h1[@class='login-title']")
    WebElement registerLabel;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement toast;

    By loader = By.id("toast-container");


    public LandingPage launchApplication(){
        driver.get("https://rahulshettyacademy.com/client");
        return new LandingPage(driver);
    }
    public ProductListPage login(String id, String p){
        emailField.sendKeys(id);
        passwordField.sendKeys(p);
        loginButton.click();
        return new ProductListPage(driver);
    }

    public String getRegisterPageLabel(){
        registerButton.click();
        return registerLabel.getText();
    }

    public LandingPage enterEmailId(String id){
        emailField.sendKeys(id);
        return this;
    }

    public LandingPage enterPassword(String p){
        passwordField.sendKeys(p);
        return this;
    }
    public LandingPage clickLogin(){
        loginButton.click();
        return this;
    }
    public String getLoginErrorMessage() throws InterruptedException {
        Thread.sleep(10000);
        return toast.getText();
    }

    public String validateInvalidLogin(String id, String p){
        enterEmailId(id);
        enterPassword(p);
        clickLogin();
        waitForWebElement(toast);
        return toast.getText();
    }

}
