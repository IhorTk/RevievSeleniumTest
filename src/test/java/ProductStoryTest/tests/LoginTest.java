package ProductStoryTest.tests;

import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void normalLoginTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context).
                loginStandartUser()
                .getWelcomeText().equals("Welcome "+ConfigurationReader.get("standard_login")));
    }

    @Test
    public void inCorrectUserNameTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context)
                .inCorrectDataUser("jkhkjh","hgkghk")
                .equals(ConfigurationReader.get("alertNotUserExist")));
    }

    @Test
    public void inCorrectUserPasswordTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context)
                .inCorrectDataUser(ConfigurationReader.get("standard_login"),"hgkghk")
                .equals(ConfigurationReader.get("alertWrongPassword")));
    }




}
