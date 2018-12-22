package componentobjects;

import common.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    private final WebDriver driver;

    @FindBy(css = "[placeholder='Ad Soyad']")
    private WebElement nameSurnameInput;

    @FindBy(css = "[placeholder='E-Posta']")
    private WebElement mailInput;

    @FindBy(css = "[name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//form[@id='signupForm']//div[@class='radio']/label[2]")
    private WebElement accountRadioButton;

    @FindBy(xpath ="//a[@class='btn btn-primary doFirstSignup']")
    private WebElement firstButton;

    @FindBy(css = "[placeholder='Kullanıcı adı']")
    private WebElement userNameInput;

    @FindBy(css = "[placeholder='Kullanıcı telefon']")
    private WebElement phoneInput;

    @FindBy(css = "[name='companyName']")
    private WebElement companyInput;

    @FindBy(css = "[placeholder='Firma telefon']")
    private WebElement companyPhoneInput;

    @FindBy(css = "[placeholder='Firma kuruluş tarihi']")
    private WebElement companyDateInput;

    @FindBy(css = "[placeholder='Firma mail']")
    private WebElement companyMailInput;

    @FindBy(css = "[placeholder='Firma web']")
    private WebElement companyWebInput;

    @FindBy(xpath = "//textarea[@name='companyAbout']")
    private WebElement companyAboutInput;

    @FindBy(xpath ="//a[@class='btn btn-primary completeSignupCompany']")
    private WebElement completeButton;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNameSurnameInput(String nameSurname){
        nameSurnameInput.click();
        nameSurnameInput.clear();
        nameSurnameInput.sendKeys(nameSurname);
    }

    public void enterMailInput(String mail){
        mailInput.click();
        mailInput.clear();
        mailInput.sendKeys(mail);
    }

    public void enterPasswordInput(String password){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterUserNameInput(String userName){
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void enterPhoneInput(String phone){
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterCompanyInput(String company){
        companyInput.click();
        companyInput.clear();
        companyInput.sendKeys(company);
    }

    public void enterCompanyPhoneInput(String companyPhone){
        companyPhoneInput.click();
        companyPhoneInput.clear();
        companyPhoneInput.sendKeys(companyPhone);
    }

    public void enterCompanyDateInput(String companyDate){
        companyDateInput.click();
        companyDateInput.clear();
        companyDateInput.sendKeys(companyDate);
    }

    public void enterCompanyMailInput(String companyMail){
        companyMailInput.click();
        companyMailInput.clear();
        companyMailInput.sendKeys(companyMail);
    }

    public void enterCompanyWebInput(String companyWeb){
        companyWebInput.click();
        companyWebInput.clear();
        companyWebInput.sendKeys(companyWeb);
    }

    public void enterCompanyAboutInput(String companyAbout){
        companyAboutInput.click();
        companyAboutInput.clear();
        companyAboutInput.sendKeys(companyAbout);
    }

    public void clickFirstButton(){ firstButton.click();  }

    public void clickCompleteButton(){ completeButton.click();  }

    public void clickAccountRadioButton(){ accountRadioButton.click();  }

    public void register(String nameSurname,String mail,String password,String userName,
                         String phone,String company,String companyPhone, String companyDate,
                         String companyMail,String companyWeb,String companyAbout){
        enterMailInput(mail);
        enterNameSurnameInput(nameSurname);
        enterPasswordInput(password);
        clickAccountRadioButton();
        clickFirstButton();

        CustomWait.waitUntilElementVisible(driver,userNameInput);
        enterUserNameInput(userName);

        enterPhoneInput(phone);
        enterCompanyInput(company);
        enterCompanyPhoneInput(companyPhone);
        enterCompanyDateInput(companyDate);
        enterCompanyMailInput(companyMail);
        enterCompanyWebInput(companyWeb);
        enterCompanyAboutInput(companyAbout);

        clickCompleteButton();
    }
}
