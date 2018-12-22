package componentobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(css = "input[name='emailorname']")
    private WebElement mailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "[class='btn btn-primary doLogin']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterMail(String mail){
        mailInput.click();
        mailInput.clear();
        mailInput.sendKeys(mail);
    }

    public void enterPassword(String password){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String mail, String password){
        enterMail(mail);
        enterPassword(password);
        clickLoginButton();
    }
}
