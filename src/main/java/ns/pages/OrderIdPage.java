package ns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderIdPage extends BasePage{
    WebDriver driver;
    public OrderIdPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    WebElement orderId;
    public String getOrderId(){
        return orderId.getText();
    }
}
