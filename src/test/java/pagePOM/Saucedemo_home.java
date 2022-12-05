package pagePOM;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageIdentifiers.ISaucedemo_home;
import pageIdentifiers.ISaucedemo_products;
import scenarios.BaseTest;
import java.time.Duration;

public class Saucedemo_home extends BaseTest {

    @Test(priority = 0)
    public void loginSaucedemoHome(){

        extentTestLogger.log(Status.INFO,"Login Page Starting.");
        driver.findElement(By.xpath(ISaucedemo_home.loginButtonXpath)).sendKeys(ISaucedemo_home.usernameValue);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id(ISaucedemo_home.passwordTextBoxID)).sendKeys(ISaucedemo_home.passwordValue);
        driver.findElement(By.id(ISaucedemo_home.loginButtonID)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTestLogger.log(Status.INFO,"Login Page completed.");

    }

    @Test(priority = 2)
    public void sortProductLowToHigh(){

        extentTestLogger.log(Status.INFO,"Sorting products in order of \"low to high\".");
        driver.findElement(By.xpath(ISaucedemo_products.homeFilterXpath)).click();
        driver.findElement(By.xpath(ISaucedemo_products.homeFilteredOptionXpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        extentTestLogger.log(Status.INFO,"Login Page Starting.");
    }

    @Test(enabled = false)
    public void simulatingFailure(){
        extentTestLogger.log(Status.INFO,"Simulating failure.");
        driver.findElement(By.xpath("invalidXpath*#$&R$!P#*!GY$#P(&")).click();
        extentTestLogger.log(Status.INFO,"Failure simulation done.");
    }

    @Test(priority = 3)
    public void verifyProductOrderList(){
        extentTestLogger.log(Status.INFO,"Verifying the order of the products.");
        driver.findElement(By.cssSelector(ISaucedemo_products.firstProductInListCss)).isDisplayed();
        driver.findElement(By.cssSelector(ISaucedemo_products.sixthProductInListCss)).isDisplayed();
        extentTestLogger.log(Status.INFO,"Verifying the order of the products complete.");
    }

    @Test(priority = 4)
    public void addingItemsToCart(){
        extentTestLogger.log(Status.INFO,"Adding items to cart.");
        driver.findElement(By.id(ISaucedemo_products.add_to_cart_sauce_labs_onesieID)).click();
        driver.findElement(By.id(ISaucedemo_products.add_to_cart_sauce__labs_fleece_jacketID)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        extentTestLogger.log(Status.INFO,"Done adding items to cart.");
    }

    @Test(priority = 5)
    public void verifyingItemsInCart(){
        extentTestLogger.log(Status.INFO,"Verifying that the two selected items are in cart.");
        driver.findElement(By.xpath(ISaucedemo_products.shoppingCartLinkID)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(ISaucedemo_products.yourCartTitleXpath)).isDisplayed();
        driver.findElement(By.xpath(ISaucedemo_products.firstItemXpath)).isDisplayed();
        driver.findElement(By.xpath(ISaucedemo_products.secondItemXpath)).isDisplayed();
        extentTestLogger.log(Status.INFO,"Verifying that the two selected items are in cart. Complete.");
    }
}
