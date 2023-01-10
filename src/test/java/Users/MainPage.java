package Users;
import javax.imageio.ImageIO;

import core.BaseSeleniumPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Assertions;
import org.momo.ConfigProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.ImageMarkupPolicy;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.momo.ConfigProvider.URL2;

public class MainPage extends BaseSeleniumPage {


    @FindBy(xpath = "//body//div[@class='navbar-header']//p//a//b")
    private WebElement usersFirstString;

    @FindBy(xpath = "//body//ul[@class='nav nav-tabs hidden-xs']//li[@class='newlink']//a//span[text()='Пользователи']")
    private WebElement polzovatelyButton;

    @FindBy(xpath = "//body//ul[@class='nav nav-tabs hidden-xs']//li[@class='newlink']//a//span[text()='Войти']")
    private WebElement signInButton;

    @FindBy(xpath = "//body//div[@class='content']/h2")
    private WebElement polzovatelyString;

    @FindBy(xpath = "//body//div[@class='content']//table[@class='table']//thead")
    private  WebElement tableHead;

    @FindBy(xpath = "//body//div[@class='content']//table[@class='table']//tbody[@class='ajax_load_row']")
    private WebElement tableBody;

    @FindBy(xpath = "//body//footer")
    private  WebElement footer;




    public MainPage() throws IOException {
        driver.get(URL2);
        PageFactory.initElements(driver,this);
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"png",new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\MainImageActual.png"));
        BufferedImage expectedImage = ImageIO.read(new File("C:\\\\Users\\\\olgas\\\\IdeaProjects\\\\SeleniumTry\\\\ScreenShots\\\\MainImage.png"));

        BufferedImage actualImage = screenshot.getImage();
        ImageDiff diff = new ImageDiffer().withDiffMarkupPolicy(new ImageMarkupPolicy().withDiffColor(Color.RED)).makeDiff(expectedImage, actualImage);

        ImageDiffer imgDiff = new ImageDiffer();
        BufferedImage diffImage = diff.getDiffImage();
        ImageIO.write(diff.getMarkedImage(),"png", new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\Difference\\Screen.png"));
        if (diff.hasDiff() == true) {
           System.out.println("Images are different");
       }else {
          System.out.println("Images are same");
        }




    }



    public boolean IsElementPresent (WebElement element){
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignored){
            return false;
        }


    }


    public Authorization signIn() throws IOException {
        IsElementPresent(usersFirstString);
        IsElementPresent(signInButton);
        signInButton.click();
        return new Authorization();

    }


}
