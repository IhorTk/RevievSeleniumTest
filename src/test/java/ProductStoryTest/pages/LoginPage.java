package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


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


    @Step("Логирование зарегистрированного пользователя")
    public MainPage loginStandartUser() {
        return loginAs(ConfigurationReader.get("standard_login"), ConfigurationReader.get("standart_password"));
    }

    @Step("Логирование пользователя")
    public MainPage loginAs(String login, String password) {
        login(login, password);
        context.wait.until(ExpectedConditions.visibilityOf(new MainPage(context).welcomeText));
        return new MainPage(context);
    }

    @Step("Логирование незарегистрированного пользователя")
    public String inCorrectDataUser(String login, String password) {
        login(login, password);
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert = context.driver.switchTo().alert();
        String messageAlert = context.alert.getText();
        context.alert.accept();
        return messageAlert;
    }

    @Step("Заполнение данных для логирования")
    private void login(String login, String password) {
        logInButton.click();
        inputUserName.sendKeys(login);
        inputUserPassword.sendKeys(password);
        inputLogin.click();
    }


}
