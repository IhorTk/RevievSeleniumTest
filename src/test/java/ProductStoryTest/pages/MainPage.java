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

    @FindBy(css = ".page-link#next2")
    public WebElement nextPageButton;

    @FindBy(css = ".page-link#prev2")
    public WebElement prevPageButton;


    @FindBy(css = "a.hrefch")
    public List<WebElement> articlesCards;



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

    public MainPage sortingArticles(String nameArticles) {

        switch (nameArticles.toLowerCase()) {
            case "phone" -> sortItemPhone.click();
            case "monitor" -> sortItemMonitor.click();
            case "notebook" -> sortItemNotebook.click();
            default -> throw new IllegalStateException("Unexpected value: " + nameArticles.toLowerCase());
        }
        context.wait.until(ExpectedConditions.stalenessOf(articlesCards.getLast()));
        return new MainPage(context);
    }

    public int amountArticleAll() {
        int amountAll = amountArticle();
        while (nextPageButton.isDisplayed()) {
            getNextPageButton();
            context.wait.until(ExpectedConditions.stalenessOf(articlesCards.getLast()));
            amountAll = amountAll + amountArticle();
        }
        return amountAll;
    }

    public void getNextPageButton() {
        nextPageButton.click();
    }

    public void getPrevPageButton() {
        prevPageButton.click();
    }

    public CartPage getGoToCartFast(){
        goToCart.click();
        return new CartPage(context);
    }

}
