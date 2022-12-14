package Users;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseSeleniumPage {
@FindBy(xpath = "//tbody//tr//td[text()='Email']/following::td[1]")
private WebElement email;

@FindBy(xpath = "//tbody//tr//td[text()='ФИО']/following::td[1]")
private WebElement name;

    public SearchPage() {
        PageFactory.initElements(driver,this);
    }

    public String getEmail(){
        return email.getText();
    }

    public String getName(){
        return name.getText();
    }
}
