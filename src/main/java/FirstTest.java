import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By surname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");

        By submitBtn = By.xpath("//button[@data-qa-node='submit']");
        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(phoneNumber).sendKeys("934103388");
        driver.findElement(sum).sendKeys(Keys.CONTROL+"A");
        driver.findElement(sum).sendKeys("299");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1129");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(name).sendKeys("Anton");
        driver.findElement(surname).sendKeys("Muravenko");
        driver.findElement(submitBtn).submit();



        By actualComment = By.xpath("//*[@data-qa-node='category']");
        By actualNumber = By.xpath("//*[@data-qa-node='details']");
        By actualCard = By.xpath("//*[@data-qa-node='card']");
        By actualOperator = By.xpath("//*[@data-qa-node='nameB']");
        By actualSum = By.xpath("//td//div[@data-qa-node='amount']");


        Assertions.assertEquals("Поповнення мобільного", driver.findElement(actualComment).getText());
        Assertions.assertEquals("Поповнення телефону. На номер +380934103388", driver.findElement(actualNumber).getText());
        Assertions.assertEquals("4004 **** **** 9003", driver.findElement(actualCard).getText());
        Assertions.assertEquals("Lifecell Ukraine", driver.findElement(actualOperator).getText());
        Assertions.assertEquals("299 UAH", driver.findElement(actualSum).getText());


}
}