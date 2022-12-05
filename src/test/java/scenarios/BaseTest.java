package scenarios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.view.Ico;
import commons.ICommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    ExtentSparkReporter extentReporter;
    ExtentReports extentReports;
    ExtentTest extentTestLogger;


    @BeforeTest
    public void beforeTestMethod(){
        setup(ICommons.driveName);
        driver.manage().window().maximize();
        driver.get(ICommons.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentReporter = new ExtentSparkReporter( System.getProperty("user.dir") +
                File.separator + "reports" + File.separator + ICommons.testReport);
        extentReports = new ExtentReports();
        extentReporter.config().setTheme(Theme.DARK);
        extentReporter.config().setDocumentTitle(ICommons.reportTitle);
        extentReporter.config().setReportName (ICommons.reportName);
        extentReports.attachReporter(extentReporter);
    }

    @BeforeMethod
    public void beforeMethodMethod(Method method){
        extentTestLogger = extentReports.createTest(method.getName());
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult iTestResult){
        String testMethodName = iTestResult.getTestName();
        if( iTestResult.isSuccess()){
            String testSummary = "Test case : " + testMethodName + "Passed.";
            Markup m = MarkupHelper.createLabel(testSummary, ExtentColor.GREEN);
            extentTestLogger.log(Status.PASS, m);
        } else {
            String testSummary = "Test case : " + testMethodName + "Failed.";
            Markup m = MarkupHelper.createLabel(testSummary, ExtentColor.RED);
            extentTestLogger.log(Status.FAIL, m);
        }
    }

    @AfterTest
    public void afterTestMethod(){
        //driver.quit();
        extentReports.flush();
    }

    public void setup(String driverName) {
        if (driverName.equals("chrome")) {
            System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") +
                    File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();

        } else if (driverName.equals("firefox")) {
            System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir") +
                    File.separator + "drivers" + File.separator + "geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }
}
