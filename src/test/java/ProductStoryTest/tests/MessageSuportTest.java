package ProductStoryTest.tests;

import ProductStoryTest.pages.MessageSupportPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import static org.testng.AssertJUnit.assertEquals;

public class MessageSuportTest extends BaseTest {
    @Test
    public void messageSuportTestBase() {
        assertEquals(ConfigurationReader.get("alertMessageOk"), new MessageSupportPage(context)
                .messageSupportSendBase());
    }

    @Test
    public void messageSuportTestAny() {
        assertEquals(ConfigurationReader.get("alertMessageOk"), new MessageSupportPage(context)
                .messageSupportSendAs("ggg@mail.com", "JohnDoe", "Hallo!!!"));
    }
}
