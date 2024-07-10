package ProductStoryTest.tests;

import ProductStoryTest.pages.CreationUserPage;
import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;

public class CreateNewUserTest extends BaseTest {
//    @Test
//    @DisplayName("Попытка зарегистрировать существующего пользователя")
//    @Description("Зарегистрировать нового пользователя с предоставленными данными. Проверить что пользователь " +
//            "зарегистрирован и возможно осуществить вход с новым пользователем и его данные отображаются корректно")
//    @Owner("Игорь Ткаченко")
//    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
//    public void createUserTest() {
//        assertEquals(ConfigurationReader.get("alertNewUserOk"), new CreationUserPage(context)
//                .createUserBase());
//
//        assertEquals("Welcome " + ConfigurationReader.get("create_login"), new LoginPage(context)
//                .loginAs(ConfigurationReader.get("create_login"), ConfigurationReader.get(
//                        "create_password"))
//                .getWelcomeText());
//
//    }

    @Test
    @DisplayName("Попытка зарегистрировать существующего пользователя")
    @Description("Попытаться зарегистрировать существующего пользователя с предоставленными данными. Проверить что " +
            "пользователя невозможно зарегистрировать т.к. такой пользователь существует")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void createNewUserFalseDataTest() {
        assertEquals(ConfigurationReader.get("alertNewUserNo"), new CreationUserPage(context)
                .createUserAs(ConfigurationReader.get("standard_login"), ConfigurationReader.get("standart_password")));

    }
//
//    @Test
//    @DisplayName("Регистрация нового пользователя с данными заданными вручную")
//    @Description("Зарегистрировать нового пользователя с данными заданными вручную. Проверить что пользователь " +
//            "зарегистрирован и возможно осуществить вход с новым пользователем и его данные отображаются корректно")
//    @Owner("Игорь Ткаченко")
//    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
//    public void createNewUserAnyDataTest() {
//        assertEquals(ConfigurationReader.get("alertNewUserOk"), new CreationUserPage(context)
//                .createUserAs("ZZZZZZZ", "Zavtra"));
//
//        assertEquals("Welcome " + ConfigurationReader.get("create_login"), new LoginPage(context)
//                .loginAs("ZZZZZZZ", "Zavtra")
//                .getWelcomeText());
//    }
}
