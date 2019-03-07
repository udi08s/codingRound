import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

	static WebDriver driver;

    @FindBy(linkText = "Hotels")
    static private WebElement hotelLink;

    @FindBy(id = "Tags")
    static private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    static private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    static private WebElement travellerSelection;

    @Test
    public static void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        
        PageFactory.initElements(driver, HotelBookingTest.class);

        driver.get("https://www.cleartrip.com/");
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private static void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\resources\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
