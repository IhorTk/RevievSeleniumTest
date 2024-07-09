package ProductStoryTest.tests;


import ProductStoryTest.pages.CartPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTest extends BaseTest {
    @Test
    public void addPhoneToCartTest(){
        assertEquals(1, new CartPage(context)
                .addOneArticleToCardBase("phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(800, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));


    }

    @Test
    public void addThreeArticleToCartTest() {
        assertEquals(3, new CartPage(context)
                .addThreeArticleToCartBase("monitor", "notebook", "phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(2300, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));
    }
}