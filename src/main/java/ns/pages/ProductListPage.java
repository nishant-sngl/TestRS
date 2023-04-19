package ns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage extends BasePage{
    WebDriver driver;
    String prod = "ZARA COAT 3";

    public ProductListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='card-body']")
    List<WebElement> prodList;
    @FindBy(css = "b")
    WebElement passwordField;
//    @FindBy(xpath = "//*[text()=' Add To Cart']")
    String addToCartButton = "//*[text()=' Add To Cart']";

    By loader = By.id("toast-container");

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartButton;

    public CartPage addItemToCart(){
        WebElement ele = prodList.stream().filter(e->
                        e.findElement(By.cssSelector("b"))
                                .getText()
                                .equals(prod))
                .findFirst()
                .orElse(null);
        ele.findElement(By.xpath(addToCartButton)).click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        waitForElement(loader);
        waitForElementToBeInvisible(loader);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
        cartButton.click();
        return new CartPage(driver);
    }


}
