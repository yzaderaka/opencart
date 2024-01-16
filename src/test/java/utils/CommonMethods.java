package utils;

import com.github.javafaker.Faker;
import stepDefenitions.PageInitializier;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static stepDefenitions.PageInitializier.initializePageObjects;


public class CommonMethods extends PageInitializier {

    public static WebDriver driver;
    public static Faker faker = new Faker();

    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties();

        String browserType = ConfigReader.getPropertyValue("browserType");
        switch (browserType) {
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--no-sandbox");
                ops.addArguments("--remote-allow-origins=*");
                if (ConfigReader.getPropertyValue("Headless").equals("true")) {
                    ops.addArguments("--headless=new");
                }
                driver = new ChromeDriver(ops);
                break;

            case "Firefox":
                driver = new FirefoxDriver();
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name");

        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects(); // This will initialize all the pages we have in our Page
        //PageInitializer class along with the launching of application
        // To configure the File and pattern it has
        String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.xml";
        DOMConfigurator.configure(log4jConfigFile);
        Log.startTestCase("This is the beginning of my Test case");
        Log.info("My test case is executing right now");
        Log.warning("My test case might have some trivial issues");
    }


    public static void closeBrowser() {
        Log.info("This test case is about to get completed");
        Log.endTestCase("This test case is finished");
        driver.quit();
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void doClick(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropdown(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value) {
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element, String text) {
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOptions(WebElement element, String text) {
        List<WebElement> options = clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
            String ddlOptionText = option.getText();
            if (ddlOptionText.equals(text)) {
                option.click();
            }
        }
    }

    //========================SCREENSHOT ===============================

    public static byte[] takeScreenshot(String imageName) {
        // This casts the webDriver instance 'driver' to TakeScreenshot Interface
        TakesScreenshot ts = (TakesScreenshot) driver;

        //This captures the screenshot and stores it as byte array
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        //This captures the screenshot and stores it as a file in the sourceFile variable
        File sourcePath = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourcePath, new File(Constants.SCREENSHOT_FILEPATH + imageName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }


    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static void acceptAlert() {

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}
