package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreationUserPage extends BasePage{

    public CreationUserPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#signin2")
    public WebElement signInButton;

    @FindBy(css = "#sign-username")
    public WebElement inputNewUserName;

    @FindBy(css = "#sign-password")
    public WebElement inputNewUserPassword;

    @FindBy(css = "button.btn-primary[onclick='register()']")
    public WebElement okCreateNewUser;

    @FindBy(xpath = "//*[@id=\"signInModal\"]//button[text()='Close']")
    public WebElement closeCreateNewUser;



    public MainPage createUserBase(){
        return createUserAs(ConfigurationReader.get("create_login"),ConfigurationReader.get("create_password"));
    }


    public MainPage createUserAs(String login, String password) {
        createUser(login, password);
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert = context.driver.switchTo().alert();
        if(context.alert.getText().equals(ConfigurationReader.get("alertNewUserOk"))) {
            context.alert.accept();
            new LoginPage(context).loginAs(login,password);
        }
        if(context.alert.getText().equals(ConfigurationReader.get("alertNewUserNo"))){
            context.alert.accept();
            closeCreateNewUser.click();
            return new MainPage(context);
        }

        return null;
    }


    private void createUser(String login, String password){
        signInButton.click();
        inputNewUserName.sendKeys(login);
        inputNewUserPassword.sendKeys(password);
        okCreateNewUser.click();
    }






}
