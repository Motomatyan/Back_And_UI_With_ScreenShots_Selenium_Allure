package Users;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authorization extends BaseSeleniumPage {
    @FindBy(xpath = "//table[@class='table center']//input[@name='login']")
    private WebElement email;

    @FindBy(xpath = "//table[@class='table center']//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//table[@class='table center']//input[@class='btn btn-danger']")
    private WebElement button;

    public Authorization (){
        PageFactory.initElements(driver,this);
    }

    public Search logIn(String emailValue, String passwordValue){
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        button.click();
        return new Search();
    }



}
