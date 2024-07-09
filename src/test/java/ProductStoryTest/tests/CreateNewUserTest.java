package ProductStoryTest.tests;

import ProductStoryTest.pages.CreationUserPage;
import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;

public class CreateNewUserTest extends BaseTest {
    @Test
    public void createUserTest() {
        assertEquals(ConfigurationReader.get("alertNewUserOk"), new CreationUserPage(context)
                .createUserBase());

        assertEquals("Welcome " + ConfigurationReader.get("create_login"), new LoginPage(context)
                .loginAs(ConfigurationReader.get("create_login"), ConfigurationReader.get(
                        "create_password"))
                .getWelcomeText());

    }

    @Test
    public void createNewUserFalseDataTest() {
        assertEquals(ConfigurationReader.get("alertNewUserNo"), new CreationUserPage(context)
                .createUserAs(ConfigurationReader.get("standard_login"), ConfigurationReader.get("standart_password")));

    }

    @Test
    public void createNewUserAnyDataTest() {
        assertEquals(ConfigurationReader.get("alertNewUserOk"), new CreationUserPage(context)
                .createUserAs("ZZZZZZZ", "Zavtra"));

        assertEquals("Welcome " + ConfigurationReader.get("create_login"), new LoginPage(context)
                .loginAs("ZZZZZZZ", "Zavtra")
                .getWelcomeText());
    }
}
