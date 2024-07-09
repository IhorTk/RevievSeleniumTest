package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends BasePage {

    public InternalPage(TestContext context) {

        super(context);
    }

    @FindBy(css = "#navbarExample")
    public WebElement navigationButtonPanel;

    @FindBy(css = ".navbar-brand#nava")
    public WebElement logBrandHeader;

    @FindBy(xpath = "//*[@id=\"fotcont\"]//h4[contains(text(),' PRODUCT STORE')]")
    public WebElement logBrandFooter;

    @FindBy(css = "a.nav-link[href='index.html']")
    public WebElement homeButton;


    public MainPage getHomeButton() {
        homeButton.click();
        return new MainPage(context);
    }

}
