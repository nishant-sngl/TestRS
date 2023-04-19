package ns.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OrdersPage extends BasePage{
    WebDriver driver;

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[@class='ng-star-inserted']//td[text()='zara coat 3']")
    List<WebElement> prodName;

    public void validateProduct(){
        Assert.assertTrue(prodName.size()>=1);
    }


}
