import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GetFromRugsUSA {

    static WebDriver driver;
    static String baseUrl;

    @BeforeClass
    public static void setUp() {
        baseUrl = "https://www.rugsusa.com/rugsusa/rugs/rugs-usa-carved-tribal-shag/White/200OZOT01A-8010.html";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void test1(){

        List<WebElement> boxes = driver.findElements(By.xpath("(//div[@class=\"select-list swiper-wrapper\"])[2]/div"));
        String boxesPath = "(//div[@class=\"select-list swiper-wrapper\"])[2]/div";

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(boxesPath)));

        //  (//div[@class="select-list swiper-wrapper"])[2]/div[3]/div[1]

        System.out.println(driver.findElement(By.xpath("(//div[@class=\"select-list swiper-wrapper\"])[2]/div[1]/div[1]")).getText());

        for (int i = 1; i <= boxes.size(); i++) {
            System.out.println(i);
            System.out.println(
                    driver.findElement(By.xpath(boxesPath+"["+i+"]"+"/div[1]")).getText()
            );
        }
    }


    @AfterClass
    public static void ShutDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
