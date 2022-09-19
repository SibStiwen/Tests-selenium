import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageImdb {
    public WebDriver driver;

    public SignInPageImdb(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //    @FindBy(xpath = "//*[contains (@id, 'signInSubmit')]")
    @FindBy(xpath = "//*[@id=\"signInSubmit\"]")
    private WebElement signInSubmit;

    //    @FindBy(xpath = "//*[contains (@id, ap_email]")
    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    private WebElement emailField;

    //    @FindBy(xpath = "//*[contains (@id, 'ap_password']")
    @FindBy(xpath = "//*[@id=\"ap_password\"]")
    private WebElement passwordField;

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPass(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInSubmit() {
        signInSubmit.click();
    }
}
