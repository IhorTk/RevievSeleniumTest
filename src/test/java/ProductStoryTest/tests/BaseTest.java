package ProductStoryTest.tests;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import ProductStoryTest.utils.DriverFactory;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
    TestContext context;

    @BeforeEach
    public void beforEach() {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.driver.get(ConfigurationReader.get("base_url"));
    }

    @AfterEach
    public void afterEach() {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) context.driver;
//        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//
//        Allure.addAttachment("Скриншот", new ByteArrayInputStream(screenshot));

        if (context.driver != null) {
            context.driver.quit();
        }
    }
}
