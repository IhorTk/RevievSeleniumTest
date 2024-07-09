package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "td>a[onclick^='deleteItem']")
    public List<WebElement> deleteArticleButton;

    @FindBy(css = "#totalp")
    public WebElement totalPrise;

    @FindBy(css = "#tbodyid>tr")
    public List<WebElement> rowsListOrdersTable;

    @FindBy(css = "button.btn-success")
    public WebElement goPlaceOrderButton;


    public MainPage addThreeArticleToCartBase(String nameArticle1, String nameArticle2, String nameArticle3) {
        addOneArticleToCardBase(nameArticle1);
        addOneArticleToCardBase(nameArticle2);
        return addOneArticleToCardBase(nameArticle3);
    }

    public MainPage addOneArticleToCardBase(String nameArticle) {
        new MainPage(context).sortingArticles(nameArticle);
        return addArticleToCardAny(ConfigurationReader.get(nameArticle));
    }

    public MainPage addArticleToCardAny(String nameArticle) {
        new ArticlePage(context).searchArticle(nameArticle);
        addArticleToCart();
        new InternalPage(context).getHomeButton();
        return new MainPage(context);
    }

    public void addArticleToCart() {
        new ArticlePage(context).getAddToCart();
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert = context.driver.switchTo().alert();
        if (context.alert.getText().equals(ConfigurationReader.get("alertArticle"))) {
            context.alert.accept();
        }
    }

    public CartPage remoteArticleFromCart(String nameArticle) {
        int count = 0;
        for (WebElement order : rowsListOrdersTable) {
            if (order.getText().contains(nameArticle)) {
                break;
            }
            count++;
        }
        deleteArticleButton.get(count).click();
        context.wait.until(ExpectedConditions.stalenessOf(rowsListOrdersTable.getFirst()));
        return new CartPage(context);
    }


    public PlaceOrderPage goToPlaceOrder() {
        goPlaceOrderButton.click();
        return new PlaceOrderPage(context);
    }


}
