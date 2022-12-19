package Users;

import core.BaseSeleniumPage;
import org.momo.ConfigProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

   // @FindBy(xpath = "//table[@class='table center']//input[@name='login']")
    //private WebElement email;

   // @FindBy(xpath = "//table[@class='table center']//input[@name='password']")
    //private WebElement password;
   // @FindBy(xpath = "//table[@class='table center']//input[@class='btn btn-danger']")
    //private WebElement button;

   // @FindBy(xpath = "//table[@class='table']//input[@name='q']")
    //private WebElement search;


    //@FindBy(xpath = "//tbody[@class='ajax_load_row']//td//a[@class='btn btn-success']")
    //private WebElement searchButton;

    //@FindBy(xpath = "//div[@class='col-md-6']//p")
    //private WebElement longText;
    @FindBy(xpath = "//body//div[@class='navbar-header']//p//a//b")
    private WebElement usersFirstString;

    @FindBy(xpath = "//body//ul[@class='nav nav-tabs hidden-xs']//li[@class='newlink']//a//span[text()='Пользователи']")
    private WebElement polzovatelyButton;

    @FindBy(xpath = "//body//ul[@class='nav nav-tabs hidden-xs']//li[@class='newlink']//a//span[text()='Войти']")
    private WebElement signInButton;

    @FindBy(xpath = "//body//div[@class='content']/h2")
    private WebElement polzovatelyString;




    public MainPage() {
        driver.get(ConfigProvider.URL2);
        PageFactory.initElements(driver,this);

    }

    public boolean IsElementPresent (WebElement element){
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignored){
            return false;
        }


    }


    public Authorization signIn() {
        IsElementPresent(usersFirstString);
        IsElementPresent(signInButton);
        signInButton.click();
        return new Authorization();
    }


}
