package pagePOM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageIdentifiers.ISaucedemo_home;
import pageIdentifiers.ISaucedemo_products;
import scenarios.BaseTest;

import javax.swing.*;
import java.time.Duration;

public class Saucedemo_home extends BaseTest {

    @Test(priority = 0)
    public void loginSaucedemoHome(){
        driver.findElement(By.xpath(ISaucedemo_home.loginButtonXpath)).sendKeys(ISaucedemo_home.usernameValue);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id(ISaucedemo_home.passwordTextBoxID)).sendKeys(ISaucedemo_home.passwordValue);
        driver.findElement(By.id(ISaucedemo_home.loginButtonID)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void sortProductLowToHigh(){
        driver.findElement(By.xpath(ISaucedemo_products.homeFilterXpath)).click();
        driver.findElement(By.xpath(ISaucedemo_products.homeFilteredOptionXpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
