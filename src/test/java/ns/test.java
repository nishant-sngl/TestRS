package ns;

import io.github.bonigarcia.wdm.WebDriverManager;
import ns.pages.LandingPage;
import ns.pages.ProductListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        LandingPage landingPage = new LandingPage(driver);
        ProductListPage productListPage;

        String prod = "ZARA COAT 3";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();;
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //login page
//        driver.findElement(By.id("userEmail")).sendKeys("123@xyz.con");
//        driver.findElement(By.id("userPassword")).sendKeys("123456q.Q");
//        driver.findElement(By.id("login")).click();
        String orderId= landingPage
                .login("","")
                .addItemToCart()
                .doCheckout()
                .placeOrder()
                .getOrderId();

        //add to cart
//        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card-body']"));
//        System.out.println(elements.size());
//        WebElement ele = elements.stream().filter(e->
//                e.findElement(By.cssSelector("b"))
//                        .getText()
//                        .equals(prod))
//                .findFirst()
//                .orElse(null);
//        ele.findElement(By.xpath("//*[text()=' Add To Cart']")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
//        driver.findElementByXPath("//button[@routerlink='/dashboard/cart']").click();

        //cart page
//        List<WebElement> el = driver.findElements(By.xpath("//ul[@class='cartWrap ng-star-inserted']//h3"));
//        Assert.assertTrue(el.stream().anyMatch(e->e.getText().equals(prod)));
//        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

        //checkout page
//        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
//        driver.findElement(By.xpath("//section[contains(@class,'ta-results list-group')]/button[2]//span")).click();
//        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

        //thankyou page
//        String orderId = driver.findElement(By.xpath("//label[@class='ng-star-inserted']")).getText();
        System.out.println(orderId);
    }

    @Test
    public void t1(){

    }
}
