import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjests.MainPage;
import pageobjests.SignInPage;
import pageobjests.SignInPageImdb;

import static org.assertj.core.api.Assertions.*;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public static SignInPage signInPage;
    public static SignInPageImdb signInPageImdb;
    public static MainPage mainPage;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", PropReader.getProperty("chromdriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropReader.getProperty("signinPage"));

        signInPage = new SignInPage(driver);
        signInPageImdb = new SignInPageImdb(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void LoginTest() {
        signInPage.clickSignInImdbBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        signInPageImdb.inputEmail(PropReader.getProperty("mail"));
        signInPageImdb.inputPass(PropReader.getProperty("pass"));
        signInPageImdb.clickSignInSubmit();
        assertThat(mainPage.getUserName()).isEqualTo(PropReader.getProperty("name"));
    }

    @AfterAll
    public static void tearDown() {
        mainPage.signOut();
        driver.quit();
    }
}
