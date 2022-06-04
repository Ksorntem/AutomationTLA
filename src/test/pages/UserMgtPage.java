package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserMgtPage extends BasePage {
    protected WebDriver driver;

    public UserMgtPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "access-db-btn")
    public WebElement accessdbBtn;

    @FindBy(id = "Firstname")
    public WebElement firstName;

    @FindBy(id = "Lastname")
    public WebElement lastName;

    @FindBy(id = "Phonenumber")
    public WebElement phone;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Select-role")
    public WebElement roles;

    @FindBy(id = "submit-btn")
    public WebElement submitBtn;

    @FindBy(id = "submit-table-btn")
    public WebElement submitTableBtn;


}
