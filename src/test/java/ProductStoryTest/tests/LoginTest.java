package ProductStoryTest.tests;

import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void normalLoginTest() {
        assertEquals("Welcome " + ConfigurationReader.get("standard_login"), new LoginPage(context).
                loginStandartUser()
                .getWelcomeText());
    }

    @Test
    public void inCorrectUserNameTest() {
        assertEquals(ConfigurationReader.get("alertNotUserExist"), new LoginPage(context)
                .inCorrectDataUser("jkhkjh", "hgkghk"));
    }

    @Test
    public void inCorrectUserPasswordTest() {
        assertEquals(ConfigurationReader.get("alertWrongPassword"),
                new LoginPage(context)
                        .inCorrectDataUser(ConfigurationReader.get("standard_login"), "hgkghk"));
    }
}
