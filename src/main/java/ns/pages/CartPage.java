package ns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage{
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='cartWrap ng-star-inserted']//h3")
    List<WebElement> cartList;
    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutButton;
    public CheckoutPage doCheckout(){
        Assert.assertTrue(cartList.stream().anyMatch(e->e.getText().equals(prod)));
        checkoutButton.click();
        return  new CheckoutPage(driver);
    }
}
