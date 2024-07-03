package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#login2")
    public WebElement logInButton;

    @FindBy(css = "#loginusername")
    public WebElement inputUserName;

    @FindBy(css = "#loginpassword")
    public WebElement inputUserPassword;

    @FindBy(css = "button.btn-primary[onclick='logIn()']")
    public WebElement inputLogin;

    @FindBy(xpath = "//*[@id=\"logInModal\"]//button[contains(text(),'Close')]")
    public WebElement logInCancell;

    @FindBy(css = "#nameofuser")
    public WebElement welcomeMessage;

    @FindBy(css = "#logout2")
    public WebElement logOutButton;


    //Alert1 User does not exist.если неправильнй пользователь
    //Alert2 Wrong password.



}
