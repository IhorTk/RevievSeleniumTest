package ProductStoryTest.tests;

import ProductStoryTest.pages.CreationUserPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewUserTest extends BaseTest{
    @Test
    public void createNewUserTest(){
        context.driver.get(ConfigurationReader.get("base_url"));

        assertTrue(new CreationUserPage(context)
                .createNewUserBase()
                .getWelcomeText()
                .equals("Welcome "+ConfigurationReader.get("create_login")));
    }

    @Test
    public void createNewUserFalseDataTest(){
        context.driver.get(ConfigurationReader.get("base_url"));

        assertFalse(new CreationUserPage(context)
                .createUserAs(ConfigurationReader.get("standard_login"),
                ConfigurationReader.get("standart_password"))
                .welcomeText
                .isDisplayed());
    }
}
