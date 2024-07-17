package ProductStoryTest.tests;

import ProductStoryTest.pages.InternalPage;
import ProductStoryTest.pages.LoginPage;
import ProductStoryTest.pages.MessageSupportPage;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @Test
    public void listNavigation(){
        new LoginPage(context).loginStandartUser();
        List<WebElement> list=new InternalPage(context).navigationButtonPanel;
        System.out.println("list.size() = " + list.size());
        for(WebElement el:list){
            System.out.println("el.getText() = " + el.getText());
        }

    }
}
