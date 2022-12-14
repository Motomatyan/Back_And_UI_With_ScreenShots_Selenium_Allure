package Users;

import core.BaseSeleniumPage;
import org.momo.ConfigProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//table[@class='table center']//input[@name='login']")
    private WebElement email;

    @FindBy(xpath = "//table[@class='table center']//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//table[@class='table center']//input[@class='btn btn-danger']")
    private WebElement button;

    @FindBy(xpath = "//table[@class='table']//input[@name='q']")
    private WebElement search;


    @FindBy(xpath = "//tbody[@class='ajax_load_row']//td//a[@class='btn btn-success']")
    private WebElement searchButton;

    public MainPage() {
        driver.get(ConfigProvider.URL2);
        PageFactory.initElements(driver,this);
    }


    public MainPage auth (String emailValue,String passwordValue){
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        button.click();
        return this;
    }

    public SearchPage search(String str){
        search.sendKeys(str, Keys.ENTER);
        searchButton.click();
        return new SearchPage();

    }
}
