package ProductStoryTest.tests;

import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Логирование на сайте зарегистрированного пользователя")
    @Description("Осуществить вход с предоставленными данными. Проверить что вход выполнен корректно" +
            "и его данные отображаются корректно")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void normalLoginTest() {
        assertEquals("Welcome " + ConfigurationReader.get("standard_login"), new LoginPage(context).
                loginStandartUser()
                .getWelcomeText());
    }

    @Test
    @DisplayName("Попытка осуществить вход на сайт незарегистрированного пользователя")
    @Description("Попытка осуществить вход на сайт незарегистрированного пользователя. Проверить что вход не выполнен")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void inCorrectUserNameTest() {
        assertEquals(ConfigurationReader.get("alertNotUserExist"), new LoginPage(context)
                .inCorrectDataUser("jkhkjh", "hgkghk"));
    }

    @Test
    @DisplayName("Попытка осуществить вход на сайт зарегистрированного пользователя с неправильным паролем")
    @Description("Попытка осуществить вход на сайт зарегистрированного пользователя с неправильным паролем." +
            "Проверить что вход не выполнен")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void inCorrectUserPasswordTest() {
        assertEquals(ConfigurationReader.get("alertWrongPassword"),
                new LoginPage(context)
                        .inCorrectDataUser(ConfigurationReader.get("standard_login"), "hgkgjkt"));
    }
}
