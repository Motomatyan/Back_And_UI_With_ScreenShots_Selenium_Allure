package Users;
import javax.imageio.ImageIO;

import core.BaseSeleniumPage;
import io.qameta.allure.Allure;
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




    public MainPage() {
        driver.get(URL2);
        PageFactory.initElements(driver,this);

    }



    public boolean IsElementPresent (WebElement element){
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException ignored){
            return false;
        }


    }


    public Authorization signIn() throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\MainImage.jpg"));
        BufferedImage actualImage = screenshot.getImage();
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        if (diff.hasDiff() == true) {
            System.out.println("Images are same");

        } else {
            System.out.println("Images are different");
        }
        IsElementPresent(usersFirstString);
        IsElementPresent(signInButton);
        signInButton.click();
        return new Authorization();
    }


}
