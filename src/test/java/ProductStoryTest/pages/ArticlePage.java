package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ArticlePage extends BasePage {

    public ArticlePage(TestContext context) {
        super(context);
    }

    @FindBy(css = ".btn-success")
    public WebElement articleToCartButton;

    @FindBy(css = "h2.name")
    public WebElement articleName;

    public void getAddToCart() {
        articleToCartButton.click();
    }

    public void searchArticle(String nameArticle) {

        for (WebElement article : new MainPage(context).articlesCards) {
            if (article.getText().contains(nameArticle)) {
                article.click();
                break;
            }
        }
    }
}
