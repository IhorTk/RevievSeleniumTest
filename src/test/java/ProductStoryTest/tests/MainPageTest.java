package ProductStoryTest.tests;

import ProductStoryTest.pages.MainPage;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainPageTest extends BaseTest {
    @Test
    @DisplayName("Проверка количества единиц товара на странице.")
    @Description("Проверить количество единиц товара на странице. Должно быть 9")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void amountArticleToPageTest() {
        assertEquals(9,new MainPage(context).amountArticle());
    }

    @Test
    @DisplayName("Фильтрация товаров по группам.")
    @Description("Фильтрация товаров по трем группам с проверкой количества товаров. Должно быть Телефоны -7, Ноутбуки-6, Мониторы-2")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void sortingArticleTest() {
        assertEquals(7, new MainPage(context).sortingArticles("Phone").amountArticle());
        assertEquals(2, new MainPage(context).sortingArticles("Monitor").amountArticle());
        assertEquals(6, new MainPage(context).sortingArticles("Notebook").amountArticle());

    }

    @Test
    @DisplayName("Проверка общего количество товаров")
    @Description("Проверить общее количество товаров с подсчетом по страницам. Должно быть 15 единиц")
    @Owner("Игорь Ткаченко")
    @Link(name = "PRODUCT STORE", url = "https://www.demoblaze.com/")
    public void amountArticleAllTest() {
        assertEquals(15, new MainPage(context).amountArticleAll());
    }

}
