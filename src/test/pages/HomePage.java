package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='link']")
    public List<WebElement> allLinkssBtn;

    @FindBy(id = "php-travels")
    public WebElement phpTravelsBtn;

    @FindBy(id = "mercury-tours")
    public WebElement mercuryBtn;


    @FindBy(xpath = "//*[text()='User-Mgt']")
    public WebElement userMgtBtn;
}
