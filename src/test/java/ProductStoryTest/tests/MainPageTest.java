package ProductStoryTest.tests;

import ProductStoryTest.pages.MainPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest extends BaseTest{
    @Test
    public void amountArticleToPageTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(new MainPage(context).amountArticle(), 9);
    }

    @Test
    public void sortingArticleTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(new MainPage(context).sortingArticles("Phone").amountArticle(),7);
        assertEquals(new MainPage(context).sortingArticles("Monitor").amountArticle(),2);
        assertEquals(new MainPage(context).sortingArticles("Notebook").amountArticle(),6);

    }

    @Test
    public void amountArticleAllTest(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(new MainPage(context).amountArticleAll(),15);
    }



}
