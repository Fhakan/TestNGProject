package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametreliWebDriver {


    void logintest() {


        WebElement inputemail = driver.findElement(By.id("input-email"));
        inputemail.sendKeys("derstest1@gmail.com");
        WebElement inputpass = driver.findElement(By.id("input-password"));
        inputpass.sendKeys("derstest1");
        WebElement btn = driver.findElement(By.cssSelector("input[value='Login']"));
        btn.click();

    }


    public WebDriver driver;

    public static WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void Baslangicİslemleri(String browser) {


        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if(browser.equalsIgnoreCase("chrome")) {

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }else {
            if(browser.equalsIgnoreCase("firefox")) {

                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();

            }



        }
        //  driver.manage().window().maximize(); //max
        driver.manage().deleteAllCookies();  //


        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));  // bütün webelement için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        logintest();

    }

    @AfterClass
    public void Bitisİslemleri() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
