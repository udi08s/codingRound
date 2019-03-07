import com.sun.javafx.PlatformUtil;

import utils.CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver;

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver=CommonUtils.setDriverPath();

        driver.get("https://www.cleartrip.com/");
        CommonUtils.waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        
        CommonUtils.waitFor(2000);
        
        driver.findElement(By.id("SignIn")).click();
        
        CommonUtils.waitFor(2000);
        
        driver.switchTo().frame("modal_window");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        CommonUtils.waitFor(2000);

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

}
