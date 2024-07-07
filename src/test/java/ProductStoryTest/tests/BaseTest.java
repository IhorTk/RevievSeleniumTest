package ProductStoryTest.tests;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import ProductStoryTest.utils.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    TestContext context;
    @BeforeEach
    public void beforEach(){
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver , Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
    }
    @AfterEach
    public void afterEach(){
        if (context.driver !=null){
            context.driver.quit();
        }
    }
}
