package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {

    public CartPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "td>a[onclick^='deleteItem']")
    public List<WebElement> deleteArticleButton;

    @FindBy(css = "#totalp")
    public WebElement totalPrise;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]//tr")
    public List<WebElement> rowsTableCartHeadless;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]//th")
    public List<WebElement> tableCartHeader;

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]")
    public WebElement tableCartProduct;

    @FindBy(css = "button.btn-success")
    public WebElement goPlaceOrderButton;


    @Step("Добавление трех товаров в корзину по заданным параметрам")
    public MainPage addThreeArticleToCartBase(String nameArticle1, String nameArticle2, String nameArticle3) {
        addOneArticleToCartBase(nameArticle1);
        addOneArticleToCartBase(nameArticle2);
        return addOneArticleToCartBase(nameArticle3);
    }

    @Step("Добавление одного товара вкорзину по заданным параметрам")
    public MainPage addOneArticleToCartBase(String nameArticle) {
        new MainPage(context).sortingArticles(nameArticle);
        return addArticleToCartAny(ConfigurationReader.get(nameArticle));
    }


    @Step("Добавление одного товара вкорзину")
    public MainPage addArticleToCartAny(String nameArticle) {
        new ArticlePage(context).searchArticle(nameArticle);
        addArticleToCart();
        new InternalPage(context).getHomeButton();
        return new MainPage(context);
    }

    @Step("Подтверждение добавления товара в корзину")
    public void addArticleToCart() {
        new ArticlePage(context).getAddToCart();
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert = context.driver.switchTo().alert();
        if (context.alert.getText().equals(ConfigurationReader.get("alertArticle"))) {
            context.alert.accept();
        }
    }

    @Step("Удаление выбранного товара")
    public CartPage remoteArticleFromCart(String nameArticle) {
        int count = 0;
        for (WebElement order : rowsTableCartHeadless) {
            if (order.getText().contains(nameArticle)) {
                break;
            }
            count++;
        }
        deleteArticleButton.get(count).click();
        context.wait.until(ExpectedConditions.stalenessOf(rowsTableCartHeadless.getFirst()));
        return new CartPage(context);
    }


    @Step("Переход на страницу оформления заказа")
    public PlaceOrderPage goToPlaceOrder() {
        goPlaceOrderButton.click();
        return new PlaceOrderPage(context);
    }

    public int getIndexCollTable(List<WebElement> list, String valueHeader){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals(valueHeader)){
                return i;
            }
        }
        return -1;
    }

    public Map<String, String> getMapTableProduct( String key, String value) {
        Map<String, String> mapProduct = new HashMap<>();
        int indexKey = getIndexCollTable(tableCartHeader, key);
        int indexValue=getIndexCollTable(tableCartHeader,value);

        for (WebElement row : rowsTableCartHeadless) {
            List<WebElement> collRows = row.findElements(By.xpath(".//td"));
            mapProduct.put(collRows.get(indexKey).getText(), collRows.get(indexValue).getText());
        }
        return mapProduct;
    }


    public int getIndexCollTable1(WebElement element, String valueHeader){
        List<WebElement> header= element.findElements(By.xpath("*//th"));
        for (int i = 0; i < header.size(); i++) {
            if(header.get(i).getText().equals(valueHeader)){
                return i;
            }
        }
        return -1;
    }

    public Map<String, String> getMapTableProduct1( WebElement element, String key, String value) {

        int indexKey = getIndexCollTable1(element, key);
        int indexValue=getIndexCollTable1(element,value);

        List<WebElement> rowsTable= element.findElements(By.xpath(".//tr"));

        Map<String, String> mapProduct = new HashMap<>();

        for (int i = 1; i <rowsTable.size() ; i++) {
            List<WebElement> cols = rowsTable.get(i).findElements(By.xpath(".//td"));
            mapProduct.put(cols.get(indexKey).getText(), cols.get(indexValue).getText());
            }

        return mapProduct;
    }


}
