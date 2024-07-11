package ProductStoryTest.tests;

import ProductStoryTest.pages.MessageSupportPage;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageSuportTest extends BaseTest {
    @Test
    @DisplayName("Отправка сообщения в службу поддержки")
    @Description("Отправить сообщение в службу поддержки из файла property. Получить подтверджение об отправке.")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void messageSuportTestBase() {
        assertEquals(ConfigurationReader.get("alertMessageOk"), new MessageSupportPage(context)
                .messageSupportSendBase());
    }

    @Test
    @DisplayName("Отправка сообщения в службу поддержки")
    @Description("Отправить сообщение в службу поддержки с параметрами заданными вручную. Получить подтверджение об отправке. ")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void messageSuportTestAny() {
        assertEquals(ConfigurationReader.get("alertMessageOk"), new MessageSupportPage(context)
                .messageSupportSendAs("ggg@mail.com", "JohnDoe", "Hallo!!!"));
    }
}
