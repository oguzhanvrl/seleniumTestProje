package componentobjects;

import common.CustomWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

import java.security.Key;


public class AdvertPage {
    private final WebDriver driver;

    @FindBy(xpath = "//select[@id='work-positions']/option[@value='3']")
    private WebElement pozisyonSelect;

    @FindBy(xpath = "//select[@id='sectors']/option[@value='2']")
    private WebElement departmanSelecet;

    @FindBy(xpath = "//input[@id='job-email']")
    private WebElement jobMailInput;

    @FindBy(xpath = "//input[@id='job-phone']")
    private WebElement jobPhoneInput;

    @FindBy(xpath ="//select[@id='countrys']/option[@value='213']")
    private WebElement ulkeSelect;

    @FindBy(xpath ="//select[@id='provinces']/option[@value='6456']")
    private WebElement sehirSelect;

    @FindBy(xpath ="//select[@id='districts']/option[@value='601']")
    private WebElement ilceSelect;

    //**

    @FindBy(xpath ="//button[@id='btn-job-next']")
    private WebElement jobNextButton;

    //**

    @FindBy(xpath ="//input[@id='interview-title']")
    private WebElement baslikInput;

    @FindBy(xpath ="//textarea[@id='interview-content']")
    private WebElement icerikInput;

    //**

    @FindBy(xpath ="//div[@class='checkbox select-all-check-box']//label//span[@class='checkbox-material'][1]")
    private WebElement tumunuSecSpan;

    @FindBy(xpath ="//div[@class='checkbox select-all-check-box']//label//span[@class='checkbox-material'][7]")
    private WebElement tumunuSec2Span;

    //**

    @FindBy(xpath ="//textarea[@id='job-description']")
    private WebElement isTanimiInput;

    @FindBy(xpath ="//textarea[@id='job-feature']")
    private WebElement isOzellikleriInput;

    @FindBy(xpath ="//div[@id='job-language-choice']//span[.='Turkish']")
    private WebElement dilCheck;

    @FindBy(xpath ="//button[@innertext='İlan Ver']")
    private WebElement jobSaveButton;


    public AdvertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterJobMailInput(String jobMail){
        jobMailInput.click();
        jobMailInput.clear();
        jobMailInput.sendKeys(jobMail);
    }

    public void enterJobPhoneInput(String jobPhone){
        jobPhoneInput.click();
        jobPhoneInput.clear();
        jobPhoneInput.sendKeys(jobPhone);
    }

    public void enterBaslikInput(String baslik){
        baslikInput.click();
        baslikInput.clear();
        baslikInput.sendKeys(baslik);
    }

    public void enterIcerikInput(String icerik){
        icerikInput.click();
        icerikInput.clear();
        icerikInput.sendKeys(icerik);
    }

    public void enterIsTanimiInput(String isTanimi){
        isTanimiInput.click();
        isTanimiInput.clear();
        isTanimiInput.sendKeys(isTanimi);
    }

    public void enterIsOzellkileriInput(String isOzellikleri){
        isOzellikleriInput.click();
        isOzellikleriInput.clear();
        isOzellikleriInput.sendKeys(isOzellikleri);
    }

    public void clickJobNextButton(){ jobNextButton.click();  }

    public void clickJoSaveButton(){ jobSaveButton.click();  }



    public void advert (String jobMail,String jobPhone,String baslik,String icerik,String isTanimi,String isOzellikleri){
        pozisyonSelect.click();
        departmanSelecet.click();
        enterJobMailInput(jobMail);
        enterJobPhoneInput(jobPhone);
        ulkeSelect.click();
        sehirSelect.click();
        ilceSelect.click();
        CustomWait.waitUntilElementClickable(driver,jobNextButton);
        clickJobNextButton();

        enterBaslikInput(baslik);
        enterIcerikInput(icerik);
        CustomWait.waitUntilElementClickable(driver,jobNextButton);
        clickJobNextButton();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", jobNextButton);
        // scrolling button

        CustomWait.waitUntilElementVisible(driver,tumunuSecSpan);
        tumunuSecSpan.click();
        clickJobNextButton();

        enterIsTanimiInput(isTanimi);
        enterIsOzellkileriInput(isOzellikleri);
        dilCheck.click();

        clickJoSaveButton();
    }

}
