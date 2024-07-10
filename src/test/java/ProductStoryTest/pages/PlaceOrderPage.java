package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import ProductStoryTest.utils.ConfigurationReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaceOrderPage extends BasePage{

    public PlaceOrderPage(TestContext context) {
        super(context);
    }

    @FindBy(css = "#name")
    public WebElement inputName;

    @FindBy(css = "#country")
    public WebElement inputCountry;

    @FindBy(css = "#city")
    public WebElement inputCity;

    @FindBy(css = "#card")
    public WebElement inputCard;

    @FindBy(css = "#month")
    public WebElement inputMonth;

    @FindBy(css = "#year")
    public WebElement inputYear;

    @FindBy(css = "button.btn-primary[onclick='purchaseOrder()']")
    public WebElement okPurchaseButton;

    @FindBy(xpath = "//*[@id=\"orderModal\"]//button[text()='Close']")
    public WebElement closePlaceOrder;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible")
    public WebElement itogPurschase;

    @FindBy(css = "button.confirm.btn-primary")
    public WebElement confirmPurchaseButton;


    @Step("Подтверджение заказа")
    public MainPage confirmPurchase(){
        confirmPurchaseButton.click();
        return new MainPage(context);
    }

    @Step("Оформление заказа со стандартными данными")
    public WebElement inputDataPlaceOrderBase(){
        return inputDataPlaceOrderAs(ConfigurationReader.get("name"),ConfigurationReader.get("country"),
                ConfigurationReader.get("city"),ConfigurationReader.get("card"),
                ConfigurationReader.get("month"),ConfigurationReader.get("year"));
    }

    @Step("Заполнение полей при оформлении заказа и ожидание ошибки")
    public String inputNoCompleteDataPlaceOrderAs(String name, String country, String city, String card, String month, String year){
        inputDataPlaceOrder(name,country,city,card,month,year);
        context.wait.until(ExpectedConditions.alertIsPresent());
        context.alert=context.driver.switchTo().alert();
        return context.alert.getText();
    }

    @Step("Оформление заказа ожидание подтверждения")
    public WebElement inputDataPlaceOrderAs(String name, String country, String city, String card, String month, String year){
        inputDataPlaceOrder(name,country,city,card,month,year);
        context.wait.until(ExpectedConditions.visibilityOf(itogPurschase));
        return itogPurschase;
    }

    @Step("Заполнение полей при оформлении заказа")
    private void inputDataPlaceOrder(String name, String country, String city, String card, String month, String year){
        inputName.sendKeys(name);
        inputCountry.sendKeys(country);
        inputCity.sendKeys(city);
        inputCard.sendKeys(card);
        inputMonth.sendKeys(month);
        inputYear.sendKeys(year);
        okPurchaseButton.click();
    }





}
