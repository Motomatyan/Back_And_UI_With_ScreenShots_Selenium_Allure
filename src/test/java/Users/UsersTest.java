package Users;

import core.BaseSeleniumTest;
import helpers.UserTestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsersTest extends BaseSeleniumTest {
    @Test
    public void checkAuth(){
        SearchPage searchPage = new MainPage().auth(UserTestValues.TEST_EMAIL,UserTestValues.TEST_PASSWORD).search(UserTestValues.TEST_EMAIL);
        Assertions.assertEquals(searchPage.getEmail(),UserTestValues.TEST_EMAIL);
        Assertions.assertEquals(searchPage.getName(),UserTestValues.TEST_NAME);

    }
}
