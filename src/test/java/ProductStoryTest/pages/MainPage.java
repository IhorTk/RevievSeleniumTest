package ProductStoryTest.pages;

import ProductStoryTest.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends InternalPage{

    public MainPage(TestContext context) {
        super(context);
    }
    @FindBy (css = ".carousel-inner")
    public WebElement carouselInner;

    @FindBy (css = ".carousel-control-next-icon")
    public WebElement caoruselNextIcon;

    @FindBy(css = "carousel-control-prev-icon")
    public WebElement caoruselPrevIcon;

    @FindBy(css = ".list-group-item#cat")
    public WebElement categoriesButton;

    @FindBy(css = "#itemc[onclick=\"byCat('phone')\"]")
    public WebElement sortItemPhone;

    @FindBy(css = "#itemc[onclick=\"byCat('notebook')\"]")
    public WebElement sortItemNotebook;

    @FindBy(css = "#itemc[onclick=\"byCat('monitor')\"]")
    public WebElement sortItemMonitor;











}
