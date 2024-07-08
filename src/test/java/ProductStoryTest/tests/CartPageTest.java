package ProductStoryTest.tests;

import ProductStoryTest.pages.ArticlePage;
import ProductStoryTest.pages.CartPage;
import ProductStoryTest.pages.InternalPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTest extends BaseTest {
    @Test
    public void addPhoneToCartTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(1, new CartPage(context)
                .addOneArticleToCardBase("phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(800, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));

    }

    @Test
    public void addThreeArticleToCartTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(3, new CartPage(context)
                .addThreeArticleToCartBase("monitor","notebook","phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(2300,Long.parseLong(new CartPage(context)
                .totalPrise.getText()));
    }


}