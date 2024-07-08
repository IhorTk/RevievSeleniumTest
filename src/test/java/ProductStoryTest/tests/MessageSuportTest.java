package ProductStoryTest.tests;

import ProductStoryTest.pages.MessageSupportPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageSuportTest extends BaseTest{
    @Test
    public void messageSuportTestBase(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new MessageSupportPage(context)
                .messageSupportSendBase()
                .equals(ConfigurationReader.get("alertMessageOk")));
    }
    @Test
    public void messageSuportTestAny(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new MessageSupportPage(context)
                .messageSupportSendAs("ggg@mail.com", "JohnDoe", "Hallo!!!")
                .equals(ConfigurationReader.get("alertMessageOk")));
    }
}
