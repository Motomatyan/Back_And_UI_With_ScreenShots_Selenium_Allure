package Users;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Authorization extends BaseSeleniumPage {
    @FindBy(xpath = "//table[@class='table center']//input[@name='login']")
    private WebElement email;

    @FindBy(xpath = "//table[@class='table center']//input[@name='password']")
    private WebElement password;
    @FindBy(xpath = "//table[@class='table center']//input[@class='btn btn-danger']")
    private WebElement button;

    public Authorization ()throws IOException {
        PageFactory.initElements(driver,this);
        Screenshot screenshotAuth = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        //ImageIO.write(screenshotAuth.getImage(),"png",new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\AuthImage.png"));
        BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\AuthImage.png"));
        BufferedImage actualImage = screenshotAuth.getImage();
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        BufferedImage diffImage = diff.getDiffImage();
        ImageIO.write(diff.getMarkedImage(),"png", new File("C:\\Users\\olgas\\IdeaProjects\\SeleniumTry\\ScreenShots\\Difference\\AuthScreen.png"));
        if (diff.hasDiff() == true) {
            System.out.println("Images are different");

        } else {
           System.out.println("Images are same");
        }
    }

    public Search logIn(String emailValue, String passwordValue){
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        button.click();
        return new Search();
    }



}
