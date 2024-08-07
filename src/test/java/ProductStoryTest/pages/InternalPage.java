package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternalPage extends BasePage {

    public InternalPage(TestContext context) {

        super(context);
    }

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li")
    public List<WebElement> navigationButtonPanel;

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;


    @Step("Пререход на главную страницу через навигационную панель")
    public MainPage getHomeButton() {

        homeButton.click();
        return new MainPage(context);
    }

}
