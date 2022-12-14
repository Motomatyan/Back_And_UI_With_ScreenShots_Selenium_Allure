package helpDesk;

import org.junit.jupiter.api.Test;
import core.BaseSeleniumTest;
import org.momo.ConfigProvider;

public class HelpDeskTest extends BaseSeleniumTest {

        @Test
        public void checkTicket(){
            String title = "тот1";
            String body = "Сообщение";
            String email = "sotif43932@lubde.com";
            MainPage mainPage = new MainPage();
            mainPage.createTicket(title,body,email);
        }



}
