package Base;

import DomaciSreda0410.Pages.*;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage2 homePage2;

    public Homepage homePage;
    public LogInPage loginPage;
    public ExcelReader excelReader;
    public SecureArea secureArea;
    public AddRemove addRemove;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        homePage = new Homepage(driver,wait);


        loginPage = new LogInPage();
        excelReader = new ExcelReader("C:\\Users\\Admin\\OneDrive\\Book 4.xlsx");
        secureArea = new SecureArea();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
