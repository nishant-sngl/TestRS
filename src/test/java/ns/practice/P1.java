package ns.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class P1 {
    static WebDriver driver;
    static WebDriverWait wait;
    static String s;
    public static void main(String[] args) throws InterruptedException {

        init("https://demoqa.com/accordian");
        accordian();
    }

    static void menu(){
//        "https://demoqa.com/menu#"
        WebElement m1 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(m1).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"))));
        WebElement sub = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        actions.moveToElement(sub).build().perform();
        wait.until(ExpectedConditions.visibilityOf(sub.findElement(By.xpath("//a"))));
        System.out.println(sub.findElement(By.xpath("//a")).getText());

    }
    static void hover(){
        WebElement ele = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).build().perform();
        String d = driver.findElement(By.xpath("//div[@role='tooltip']")).getText();
        System.out.println(d);

        actions.moveToElement(driver.findElement(By.id("toolTipTextField"))).build().perform();
        d = driver.findElement(By.xpath("//div[@role='tooltip']")).getText();
        System.out.println(d);

        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Contrary']"))).build().perform();
        d = driver.findElement(By.xpath("//div[@role='tooltip']")).getText();
        System.out.println(d);



    }
    static void autoComplete() throws InterruptedException {
        driver.findElement(By.id("autoCompleteMultipleInput")).sendKeys("bl");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class, 'auto-complete__menu')]//*[text()='Blue']")).click();

        driver.findElement(By.id("autoCompleteMultipleInput")).sendKeys("gr");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class, 'auto-complete__menu')]//*[text()='Green']")).click();
    }
    static void accordian(){
        scrollTillElement(driver.findElement(By.id("section3Heading")));
        driver.findElement(By.id("section3Heading")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='section3Content']")).getText());
    }
    static void modalDialog(){
//        "https://demoqa.com/modal-dialogs"
        driver.findElement(By.id("showSmallModal")).click();
        System.out.println(driver.findElement(By.cssSelector(".modal-body")).getText());
        driver.findElement(By.id("closeSmallModal")).click();

        driver.findElement(By.id("showLargeModal")).click();
        System.out.println(driver.findElement(By.cssSelector(".modal-body")).getText());
        driver.findElement(By.id("closeLargeModal")).click();



    }
    static void iframes(){
//        driver.switchTo().frame("frame1");
//        System.out.println(driver.findElement(By.xpath("//h1")).getText());
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("frame2");
//        System.out.println(driver.findElement(By.xpath("//h1")).getText());

        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.xpath("//body")).getText());
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.xpath("//body")).getText());


    }
    static void link(){
            driver.findElement(By.id("simpleLink")).click();
            Set<String> set = driver.getWindowHandles();
            Iterator<String> it = set.iterator();
            String main = it.next();
            String sec = it.next();
//            System.out.println("main wind: ");
//            System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());
            driver.switchTo().window(sec);
            System.out.println("second wind: ");
            System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());
            driver.close();
            driver.switchTo().window(main);
//            System.out.println("main wind: ");
//            System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());

        driver.findElement(By.id("dynamicLink")).click();
        set = driver.getWindowHandles();
        it = set.iterator();
        main = it.next();
        sec = it.next();
//        System.out.println("main wind: ");
//        System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());
        driver.switchTo().window(sec);
        System.out.println("second wind: ");
        System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());
        driver.close();
        driver.switchTo().window(main);
//        System.out.println("main wind: ");
//        System.out.println(driver.findElements(By.xpath("//h5[text()='Elements']")).size());

    }
    static void button(){
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClick).build().perform();
        WebElement doubleOut = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(doubleOut.isDisplayed());

        action.contextClick(rightClick).build().perform();
        WebElement rightOut = driver.findElement(By.id("rightClickMessage"));
        System.out.println(rightOut.isDisplayed());

        action.click(click).build().perform();
        WebElement clickOut = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println(clickOut.isDisplayed());
    }
    static void table(){
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']"));
        for (int i=1;i<4;i++) {
            System.out.println(rows.get(i).findElement(By.xpath("//div[@class='rt-td'][1]")).getText());
        }

//        for (int i=1;i<4;i++) {
//            System.out.println(driver.findElement(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][1]")).getText());
//        }
    }
    public static void radio(){
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        System.out.println(yesRadio.isSelected());
        yesRadio.click();
        System.out.println(yesRadio.isSelected());
    }
    public static void checkbox(){
//        WebElement expand = driver.findElement(By.xpath("//button[@title='Expand all']"));
        WebElement expandHome = driver.findElement(By.xpath("//span[text()='Home']/../preceding-sibling::button"));
        expandHome.click();
        WebElement expandDownload = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Downloads']/../preceding-sibling::button"));
        expandDownload.click();
//        WebElement checkFile = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']"));
        WebElement checkFile = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']"));
        //span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']/*[local-name()='svg']
//        WebElement checkFileSvg = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']/*[local-name()='svg']]");
        System.out.println(driver.findElement(By.xpath("//span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']/*[local-name()='svg']")).getAttribute("class"));
        checkFile.click();
        System.out.println(driver.findElement(By.xpath("//span[@class='rct-title' and text()='Excel File.doc']/preceding-sibling::span[@class='rct-checkbox']/*[local-name()='svg']")).getAttribute("class"));


    }
        public static WebElement scrollTillElement(WebElement element){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            return element;
        }

    static void inputs(){
        driver.findElement(By.xpath("//label[@id='userName-label']/../following-sibling::div[1]/input")).sendKeys("nishant");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("email@email.com");

        scrollTillElement(driver.findElement(By.cssSelector("#currentAddress"))).sendKeys("address");
        scrollTillElement(driver.findElement(By.cssSelector("#submit"))).click();
        WebElement out = scrollTillElement(driver.findElement(By.id("output")));
        Assert.assertTrue(out.findElement(By.id("name")).getText().equals("Name:nishant"));
        Assert.assertTrue(out.findElement(By.id("email")).getText().equals("Email:email@email.com"));
        Assert.assertTrue(out.findElement(By.id("currentAddress")).getText().equals("Current Address :address"));
    }
    static void alerts() throws InterruptedException {
//        driver.findElement(By.id("alertButton")).click();
//        s = driver.switchTo().alert().getText();
//        System.out.println(s);
//        driver.switchTo().alert().accept();


//        driver.findElement(By.id("timerAlertButton")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        s = driver.switchTo().alert().getText();
//        System.out.println(s);
//        driver.switchTo().alert().accept();


//        driver.findElement(By.id("confirmButton")).click();
//        wait.until(ExpectedConditions.alertIsPresent());
//        s = driver.switchTo().alert().getText();
//        System.out.println(s);
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().defaultContent();
//        Assert.assertTrue(driver.findElement(By.id("confirmResult")).getText().contains("Ok"));

        String s1 = "nishant";
        driver.findElement(By.id("promtButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        s = driver.switchTo().alert().getText();
        System.out.println(s);
        driver.switchTo().alert().sendKeys(s1);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("promptResult")).getText().contains(s1));


    }
    static void init(String url){
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
    }
    static void init1(String url){
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        switch (url){
            case "input":
                driver.navigate().to("https://demoqa.com/text-box");
                break;
            case "alert":
                driver.navigate().to("https://demoqa.com/alerts");
                break;
            case "checkbox":
                driver.get("https://demoqa.com/checkbox");
                break;
            case "radio":
                driver.get("https://demoqa.com/radio-button");
                break;
            case "table":
                driver.get("https://demoqa.com/webtables");
                break;
            case "button":
                driver.get("https://demoqa.com/buttons");
                break;
            case "links":
                driver.get("https://demoqa.com/links");
                break;
            case "iframe":
                driver.get("https://demoqa.com/frames");
                break;
            case "nestedFrames":
                driver.get("https://demoqa.com/nestedframes");
                break;
        }
        System.out.println(driver.getTitle());
    }
}
