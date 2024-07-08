package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessageSupportPage extends BasePage{

    public MessageSupportPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "a.nav-link[data-target=\"#exampleModal\"]")
    public WebElement contactButton;

    @FindBy(css = "#recipient-email")
    public WebElement userEmail;

    @FindBy(css = "#recipient-name")
    public WebElement userName;

    @FindBy(css = "#message-text")
    public WebElement messageText;

    @FindBy(css = "button.btn-primary[onclick=\"send()\"]")
    public WebElement messageSendOk;

    @FindBy(xpath = "//*[@id=\"exampleModal\"]//button[text()='Close']")
    public WebElement messageSendClose;


   public String messageSupportSendBase(){
       return messageSupportSendAs(ConfigurationReader.get("user_email"),ConfigurationReader.get("standard_login"),
               ConfigurationReader.get("contact_message"));

   }

    public String messageSupportSendAs(String emails, String names, String messages){
       messageSupportSend(emails, names, messages);
       context.wait.until(ExpectedConditions.alertIsPresent());
       context.alert=context.driver.switchTo().alert();
       return context.alert.getText();
    }


    private void messageSupportSend(String email, String name, String message){
        contactButton.click();
        userEmail.sendKeys(email);
        userName.sendKeys(name);
        messageText.sendKeys(message);
        messageSendOk.click();
    }




}