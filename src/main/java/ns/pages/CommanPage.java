package ns.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommanPage extends BasePage{
    WebDriver driver;
    public CommanPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement ordersLink;

    public OrdersPage clickOrdersLink(){
        ordersLink.click();
        return new OrdersPage(driver);
    }
}
