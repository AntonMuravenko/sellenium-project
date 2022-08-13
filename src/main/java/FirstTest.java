import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    @Test
   public void check(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );

        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        By sum = By.xpath("//input[@data-qa-node='amount']");

        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By submitBtn = By.xpath("//button[@data-qa-node='submit']");


        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(phoneNumber).sendKeys("934103388");
        driver.findElement(sum).clear();
        driver.findElement(sum).sendKeys("299");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1129");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(submitBtn).submit();

}
}