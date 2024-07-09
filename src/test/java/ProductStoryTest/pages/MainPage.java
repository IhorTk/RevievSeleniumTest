package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {


    public MainPage(TestContext context) {
        super(context);
    }

    @FindBy(css = ".carousel-inner")
    public WebElement carouselInner;

    @FindBy(css = ".carousel-control-next-icon")
    public WebElement carouselNextIcon;

    @FindBy(css = "carousel-control-prev-icon")
    public WebElement carouselPrevIcon;

    @FindBy(css = ".list-group-item#cat")
    public WebElement categoriesButton;

    @FindBy(css = "a.hrefch")
    public List<WebElement> articlesCards;

    @FindBy(css = "#itemc[onclick=\"byCat('phone')\"]")
    public WebElement sortItemPhone;

    @FindBy(css = "#itemc[onclick=\"byCat('notebook')\"]")
    public WebElement sortItemNotebook;

    @FindBy(css = "#itemc[onclick=\"byCat('monitor')\"]")
    public WebElement sortItemMonitor;

    @FindBy(css = "#nameofuser")
    public WebElement welcomeText;

    @FindBy(css = "#cartur")
    public WebElement goToCart;


    public CartPage getGoToCart() {
        goToCart.click();
        context.wait.until(ExpectedConditions.visibilityOfAllElements(new CartPage(context).rowsListOrdersTable));
        return new CartPage(context);
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public int amountArticle() {
        return articlesCards.size();
    }

    public MainPage sortingArticles(String nameArtikles) {

        switch (nameArtikles.toLowerCase()) {
            case "phone" -> {
                sortItemPhone.click();
            }
            case "monitor" -> {
                sortItemMonitor.click();
            }
            case "notebook" -> sortItemNotebook.click();
        }
        context.wait.until(ExpectedConditions.stalenessOf(articlesCards.get(articlesCards.size()-1)));
        return new MainPage(context);
    }

    public int amountArticleAll() {
        int amountAll = amountArticle();
        while (new InternalPage(context).nextPageButton.isDisplayed()) {
            new InternalPage(context).getNextPageButton();
            context.wait.until(ExpectedConditions.stalenessOf(articlesCards.get(0)));
            amountAll = amountAll + amountArticle();
        }
        return amountAll;
    }

}
