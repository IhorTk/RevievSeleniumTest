package ProductStoryTest.tests;

import ProductStoryTest.pages.CreationUserPage;
import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewUserTest extends BaseTest{
    @Test
    public void createUserTest(){
        context.driver.get(ConfigurationReader.get("base_url"));


//getWelcomeText().equals("Welcome "+ConfigurationReader.get("create_login"))
//        String ccc = new CreationUserPage().createUserBase().getWelcomeText();
//        System.out.println("ccc = " + ccc);
    }

    @Test
    public void createNewUserFalseDataTest(){
        context.driver.get(ConfigurationReader.get("base_url"));

        assertFalse(new CreationUserPage(context)
                .createUserAs(ConfigurationReader.get("standard_login"),
                ConfigurationReader.get("standart_password"))
                .welcomeText
                .isDisplayed());
    }
}
