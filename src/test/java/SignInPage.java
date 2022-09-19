import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public WebDriver driver;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"signin-options\"]/div/div[1]/a[1]")
    private WebElement signInImdbBtn;

    public void clickSignInImdbBtn() {
        signInImdbBtn.click();
    }
}
