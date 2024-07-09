package ProductStoryTest.tests;

import ProductStoryTest.pages.CartPage;
import ProductStoryTest.pages.MainPage;
import ProductStoryTest.pages.PlaceOrderPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PlaceOrderTest extends BaseTest{
    @Test
    public void okPlaceOrderTest(){

        assertTrue(new CartPage(context)
                .addOneArticleToCardBase("notebook")
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
        assertTrue(new MainPage(context).carouselInner
                .isDisplayed());
    }

    @Test
    public void noCompleteDataPlaceOrderTest(){
        assertEquals("Please fill out Name and Creditcard.", new CartPage(context)
                .addOneArticleToCardBase("phone").getGoToCart().goToPlaceOrder()
                .inputNoCompleteDataPlaceOrderAs("","Moon","RacuntenCity","","12","2030"));
    }

    @Test
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
        assertTrue(new MainPage(context).carouselInner
                .isDisplayed());


    }
}
