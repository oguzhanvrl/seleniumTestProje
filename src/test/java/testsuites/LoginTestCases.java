package testsuites;

import common.CustomWait;
import componentobjects.AdvertPage;
import componentobjects.LoginPage;
import componentobjects.PasswordPage;
import componentobjects.RegisterPage;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCases {

    protected static WebDriver driver = null;

    private String nameSurname =("Oğuzhan VAROL");
    private String mail =("oguzhanvarol@"+new RandomString().nextString().toUpperCase()+".com.tr");
    private String phone ="5522209999";

    private String userName = ("ogzhn"+new RandomString().nextString().toUpperCase());
    private String password = ("123456789");

    private String _url="http://www.unclesoftware.com";
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private AdvertPage advertPage;
    private PasswordPage passwordPage;

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        advertPage = new AdvertPage(driver);
        passwordPage = new PasswordPage(driver);
    }

    @Test(priority = 1)
    public void testWithValidRegister(Method currentMethod){
        driver.get(_url+"/member/signup");
        registerPage.register(nameSurname,mail,password,userName,phone,
                "Anonim Sirket",phone,"2018-12-22",
                mail,_url,"cok güzel bir firmayizz");
        WebElement user = driver.findElement(By.cssSelector(".dropdown:nth-of-type(6) span"));
        CustomWait.waitUntilElementVisible(driver,user);
        Assert.assertEquals(user.getText(),nameSurname.toUpperCase());
    }

    @Test(priority = 2)
    public void testWithValidLogin(Method currentMethod){
        driver.get(_url+"/member/login");
        loginPage.login(userName, password);
        WebElement user = driver.findElement(By.cssSelector(".dropdown:nth-of-type(6) span"));
        CustomWait.waitUntilElementVisible(driver,user);
        Assert.assertEquals(user.getText(),nameSurname.toUpperCase());
    }

    @Test(priority = 3)
    public void testWithPassword(Method currentMethod){
        driver.get(_url+"/member/login");
        loginPage.login(userName,password);

        driver.get(_url+"/setting/password");
        String tempPass= password;
        password =new RandomString().nextString().toUpperCase();
        passwordPage.Pass(tempPass,password,password);
        WebElement passMessage = driver.findElement(By.xpath("//form[@id='passwordEditForm']//div[@class='container-fluid']"));
        CustomWait.waitUntilElementVisible(driver,passMessage);
        Assert.assertTrue(passMessage.getText().contains("Şifreniz başarıyla değiştirildi."));
    }


    @Test(priority = 4)
    public void testWithValidAdvert(Method currentMethod){
        driver.get(_url+"/member/login");
        loginPage.login(userName,password);

        driver.get(_url+"/profile/company/"+userName+"?t=notices");
        int tempIlan = driver.findElements(By.xpath("//tbody[@id='company-myads']//tr")).size();

        driver.get(_url+"/job/add");
        advertPage.advert(mail,phone,
                "yeni işe alım ilanı",
                "en az 4 yıl deneyimli geliştirici arıyoruz.",
                "geliştirici takımımıza developer",
                ".Net / OOP / Entitiy Framework / t-SQL / javascript");

        WebElement table = driver.findElement(By.xpath("//tbody[@id='company-myads']"));
        CustomWait.waitUntilElementVisible(driver,table);

        int guncelIlan = driver.findElements(By.xpath("//tbody[@id='company-myads']//tr")).size();
        Assert.assertEquals(tempIlan,guncelIlan++);
    }

    @AfterMethod
    public void after(ITestResult result) {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
