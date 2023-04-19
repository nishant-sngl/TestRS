package ns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countryDD;

    @FindBy(xpath = "//section[contains(@class,'ta-results list-group')]/button[2]//span")
    WebElement optionToBeSelected;
    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement placeOrderButton;

    public OrderIdPage placeOrder(){
        countryDD.sendKeys("india");
        optionToBeSelected.click();
        placeOrderButton.click();
        return  new OrderIdPage(driver);
    }
}
