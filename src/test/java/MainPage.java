import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"imdbHeader\"]/div[2]/div[5]/div/label[2]/div/span")
    private WebElement headerAccount;

    @FindBy(xpath = "//*[@id=\"navUserMenu-contents\"]/ul/a[6]")
    private WebElement userMenuSignOut;

    public String getUserName() {
        return headerAccount.getText();
    }

    public void clickHeaderAccount() {
        headerAccount.click();
    }

    private void clickSignOut() {
        userMenuSignOut.click();
    }

    public void signOut() {
        clickHeaderAccount();
        clickSignOut();
    }
}
