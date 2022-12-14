package Users;

import core.BaseSeleniumTest;
import core.Specification;
import helpers.UserTestValues;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UsersTest extends BaseSeleniumTest {

    public static final String URL3 = "http://users.bugred.ru/";
    @DisplayName("Test with registration")

    @Test
    public void checkAuth(){
        doRegister();
        SearchPage searchPage = new MainPage().auth(UserTestValues.TEST_EMAIL,UserTestValues.TEST_PASSWORD).search(UserTestValues.TEST_EMAIL);
        Assertions.assertEquals(searchPage.getEmail(),UserTestValues.TEST_EMAIL);
        Assertions.assertEquals(searchPage.getName(),UserTestValues.TEST_NAME);

    }
    @Step("DoRegister")

    public void doRegister(){
        Specification.installSpecification(Specification.requestSpec(URL3), Specification.responseSpec200());
        DoRegister user = new DoRegister(UserTestValues.TEST_EMAIL,UserTestValues.TEST_NAME,UserTestValues.TEST_PASSWORD);
        given()
                .when()
                .post("tasks/rest/doregister")
                .then().log().all();

    }
}
