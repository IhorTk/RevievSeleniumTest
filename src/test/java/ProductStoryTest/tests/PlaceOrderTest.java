package ProductStoryTest.tests;

import ProductStoryTest.pages.CartPage;
import ProductStoryTest.pages.MainPage;
import ProductStoryTest.pages.PlaceOrderPage;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PlaceOrderTest extends BaseTest{
    @Test
    @DisplayName("Оформление и подтверждение заказа")
    @Description("Добавить в корзину MacBook Pro - стоимость 1100$. Перейти на страницу оформления заказа."+
            " Внести тестовые данные. Проверить сумму заказа, Имя, Номер карты. Подтвердить заказ."+
            " Проверить, что после завершения осуществляется переход на главную страницу")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void okPlaceOrderTest(){

        assertTrue(new CartPage(context)
                .addOneArticleToCartBase("notebook")
                .getGoToCart()
                .goToPlaceOrder()
                .inputDataPlaceOrderBase().getText()
                .contains(ConfigurationReader.get("thanks_message")));
        assertTrue(new PlaceOrderPage(context)
                .itogPurschase.getText()
                .contains("Name: " + ConfigurationReader.get("name")));
        assertTrue(new PlaceOrderPage(context)
                .itogPurschase.getText()
                .contains("Card Number: " + ConfigurationReader.get("card")));
        assertTrue(new PlaceOrderPage(context)
                .itogPurschase.getText()
                .contains("Amount: " + "1100"));
        assertTrue(new PlaceOrderPage(context)
                .confirmPurchase()
                .categoriesButton
                .isDisplayed());

    }

    @Test
    @DisplayName("Попытка оформления заказа без указания имени и номера карты")
    @Description("Добавить в корзину MacBook Pro - стоимость 1100$. Перейти на страницу оформления заказа."+
            " Внести тестовые данные без имени и номера карты и подтвердить. Ожидается, что оформление не будет завершено")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void noCompleteDataPlaceOrderTest(){
        assertEquals("Please fill out Name and Creditcard.", new CartPage(context)
                .addOneArticleToCartBase("phone").getGoToCart().goToPlaceOrder()
                .inputNoCompleteDataPlaceOrderAs("","Moon","RacuntenCity","","12","2030"));
    }

    @Test
    @DisplayName("Попытка оформления заказа без выбора товара и заполнения данных")
    @Description("С главной страницы перейти в корзину и на страницу оформления заказа."+
            " Заполнить поля Name: и Credit card:. Ожидается, что оформление не будет завершено, в противном " +
            "случае оформление будет завершено без данных и будет осуществлен переход на главную страницу")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void negativPlaceOrderTest(){
        assertTrue(new MainPage(context)
                .getGoToCartFast()
                .goToPlaceOrder()
                .inputDataPlaceOrderAs(" ","",""," ","","").getText()
                .contains(ConfigurationReader.get("thanks_message")));
        assertTrue(new PlaceOrderPage(context)
                .itogPurschase.getText()
                .contains("Amount: " + "0 USD"));
        assertTrue(new PlaceOrderPage(context)
                .confirmPurchase()
                .categoriesButton
                .isDisplayed());

    }
}
