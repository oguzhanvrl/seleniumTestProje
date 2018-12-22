package componentobjects;

import common.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='password_current']")
    private WebElement passwordCurrentInput;

    @FindBy(xpath = "//input[@name='password_new']")
    private WebElement passwordNewInput;

    @FindBy(xpath = "//input[@name='password_new_confirm']")
    private WebElement passwordNewConfirmInput;

    @FindBy(xpath = "//button[@name='password_form']")
    private WebElement passwordSaveButton;

    public PasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPasswordCurrent(String passwordCurrent){
        passwordCurrentInput.click();
        passwordCurrentInput.clear();
        passwordCurrentInput.sendKeys(passwordCurrent);
    }

    public void enterPasswordNew(String passwordNew){
        passwordNewInput.click();
        passwordNewInput.clear();
        passwordNewInput.sendKeys(passwordNew);
    }

    public void enterPasswordNewConfirm(String passwordNewConfirm){
        passwordNewConfirmInput.click();
        passwordNewConfirmInput.clear();
        passwordNewConfirmInput.sendKeys(passwordNewConfirm);
    }

    public void clickPasswordSaveButton(){ passwordSaveButton.click();}

    public void Pass(String passwordCurrent, String passwordNew,String passwordNewConfirm){
        CustomWait.waitUntilElementVisible(driver,passwordCurrentInput);
        enterPasswordCurrent(passwordCurrent);
        enterPasswordNew(passwordNew);
        enterPasswordNewConfirm(passwordNewConfirm);
        clickPasswordSaveButton();
    }
}
