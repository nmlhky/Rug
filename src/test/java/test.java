import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class test {

    static WebDriver driver;
    static String baseUrl;

    @BeforeClass
    public static void setUp() {
        baseUrl = "https://weather.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void test1() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.findElement(By.xpath("//*[@id='LocationSearch_input']")).click();
        driver.findElement(By.xpath("//*[@id='LocationSearch_input']")).sendKeys("Hello");




    }


    @AfterClass
    public static void ShutDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
