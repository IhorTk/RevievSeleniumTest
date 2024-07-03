package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCreationPage  extends BasePage{

    public UserCreationPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#signin2")
    public WebElement creatNewUserButton;

    @FindBy(css = "#sign-username")
    public WebElement creatUserName;

    @FindBy(css = "#sign-password")
    public WebElement creatUserPassword;

    @FindBy(css = "button.btn-primary[onclick='register()']")
    public WebElement singUpButton;

    @FindBy (xpath = "//*[@id=\"signInModal\"]//button[contains(text(),'Close')]")
    public WebElement creatNewUserCancell;

    //проверка алерта "Sign up successful."
    //        Alert alert = driver.switchTo().alert();
    //        Thread.sleep(2000);
    //        Assertions.assertEquals("I am a JS Alert", alert.getText());
    //        alert.accept();






}