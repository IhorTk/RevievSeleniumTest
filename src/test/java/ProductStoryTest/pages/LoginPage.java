package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(css = "#logout2")
    public WebElement logOutButton;

    public MainPage loginStandartUser(){
        return loginAs(ConfigurationReader.get("standard_login"),ConfigurationReader.get("standart_password"));
    }

    public MainPage loginAs(String login, String passwod){
        login(login,passwod);
        context.wait.until(ExpectedConditions.visibilityOf(new InternalPage(context).welcomeText));
        return new MainPage(context);
    }

    public MainPage logOut(){
        logOutButton.click();
        return new MainPage(context);
    }

    public String inCorrectDataUser(String login, String password){
        login(login,password);
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert=context.driver.switchTo().alert();
        String messageAlert = context.alert.getText();
        context.alert.accept();
        return messageAlert;
    }

    private void login(String login, String password){
        logInButton.click();
        inputUserName.sendKeys(login);
        inputUserPassword.sendKeys(password);
        inputLogin.click();
    }









}
