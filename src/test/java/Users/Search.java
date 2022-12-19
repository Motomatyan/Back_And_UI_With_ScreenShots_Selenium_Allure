package Users;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search extends BaseSeleniumPage {
    @FindBy(xpath = "//tbody//tr//td[text()='Email']/following::td[1]")
    private WebElement email;

    @FindBy(xpath = "//tbody//tr//td[text()='ФИО']/following::td[1]")
    private WebElement name;
    @FindBy(xpath = "//table[@class='table']//input[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']//td//a[@class='btn btn-success']")
    private WebElement searchButton;

    public Search() {
        PageFactory.initElements(driver,this);
    }



    public SearchPage search(String str){
        search.sendKeys(str, Keys.ENTER);
        searchButton.click();
        return new SearchPage();

    }



}
