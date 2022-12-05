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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        extentTestLogger.log(Status.INFO,"Login Page Starting.");

    }

    @Test(priority = 1)
    public void simulatingFailure(){

        extentTestLogger.log(Status.INFO,"Simulating failure.");
        driver.findElement(By.xpath("invalidXpath")).click();
        extentTestLogger.log(Status.INFO,"Failure simulation done.");

    }


}
