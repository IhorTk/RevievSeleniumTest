package ProductStoryTest.tests;

import ProductStoryTest.pages.CreationUserPage;
import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewUserTest extends BaseTest{
    @Test
    public void createUserTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new CreationUserPage(context)
                .createUserBase()
                .equals(ConfigurationReader.get("alertNewUserOk")));
        assertTrue(new LoginPage(context).loginAs(ConfigurationReader.get("create_login"),ConfigurationReader.get(
                "create_password")).getWelcomeText().equals("Welcome "+ConfigurationReader.get("create_login")));

    }

    @Test
    public void createNewUserFalseDataTest(){
        context.driver.get(ConfigurationReader.get("base_url"));

        assertTrue(new CreationUserPage(context)
                .createUserAs(ConfigurationReader.get("standard_login"),ConfigurationReader.get("standart_password"))
                .equals(ConfigurationReader.get("alertNewUserNo")));
    }
    @Test
    public void createNewUserAnyDataTest(){
        context.driver.get(ConfigurationReader.get("base_url"));

        assertTrue(new CreationUserPage(context)
                .createUserAs("ZZZZZZZ","Zavtra")
                .equals(ConfigurationReader.get("alertNewUserOk")));
        assertTrue(new LoginPage(context)
                .loginAs("ZZZZZZZ","Zavtra")
                .getWelcomeText().equals("Welcome "+ConfigurationReader.get("create_login")));
    }
}
