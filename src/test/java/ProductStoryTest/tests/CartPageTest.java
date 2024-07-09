package ProductStoryTest.tests;


import ProductStoryTest.pages.CartPage;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTest extends BaseTest {

    @Test
    @DisplayName("Добавление одной единицы товара в корзину")
    @Description("Добавить в корзину Samsung galaxy s7, стоимость 800$. Проверить что товар добавлен в корзину и стоимость верна")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")

    public void addOneArticleToCartTest() {
        assertEquals(1, new CartPage(context)
                .addOneArticleToCardBase("phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(800, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));


    }

    @Test
    @DisplayName("Добавление трех единиц товара в корзину")
    @Description("Добавить в корзину Samsung galaxy s7 - стоимость 800$, MacBook Pro - стоимость 1100$,"+
            " Apple monitor 24 - стоимость 400$. Проверить что товары добавлены в корзину и их общая стоимость 2300$")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void addThreeArticleToCartTest() {
        assertEquals(3, new CartPage(context)
                .addThreeArticleToCartBase("monitor", "notebook", "phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(2300, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));
    }

    @Test
    @DisplayName("Удаление одной единицы товара из корзины")
    @Description("Добавить в корзину Samsung galaxy s7 - стоимость 800$, MacBook Pro - стоимость 1100$,"+
            " Apple monitor 24 - стоимость 400$. Проверить что товары добавлены в корзину и их общая стоимость 2300$."+
            "Удалить из корзины Samsung galaxy s7 - стоимость 800$. Проверить, что в корзине 2 товара. Общая стоимость 1500$")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void remoteArticleFromCartTest() {
        assertEquals(3, new CartPage(context)
                .addThreeArticleToCartBase("monitor", "notebook", "phone")
                .getGoToCart()
                .rowsListOrdersTable.size());
        assertEquals(2300, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));

        assertEquals(2, new CartPage(context)
                .remoteArticleFromCart("Samsung galaxy s7").rowsListOrdersTable.size());
        assertEquals(1500, Long.parseLong(new CartPage(context)
                .totalPrise.getText()));

    }
}