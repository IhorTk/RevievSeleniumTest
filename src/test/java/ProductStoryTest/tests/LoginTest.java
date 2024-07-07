package ProductStoryTest.tests;

import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{
    @Test
    public void normalLoginTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context).
                loginStandartUser()
                .getWelcomeText().equals("Welcome "+ConfigurationReader.get("standard_login")));
    }

//    @Test
//    public


}
