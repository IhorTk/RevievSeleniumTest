package ProductStoryTest.tests;

import ProductStoryTest.pages.MainPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainPageTest extends BaseTest {
    @Test
    public void amountArticleToPageTest() {
        assertEquals(9,new MainPage(context).amountArticle());
    }

    @Test
    public void sortingArticleTest() {
        assertEquals(7, new MainPage(context).sortingArticles("Phone").amountArticle());
        assertEquals(2, new MainPage(context).sortingArticles("Monitor").amountArticle());
        assertEquals(6, new MainPage(context).sortingArticles("Notebook").amountArticle());

    }

    @Test
    public void amountArticleAllTest() {
        assertEquals(15, new MainPage(context).amountArticleAll());
    }

}
