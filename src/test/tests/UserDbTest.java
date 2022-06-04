package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDbPage;
import pages.UserMgtPage;
import utils.SeleniumUtils;
import java.util.List;

public class UserDbTest extends BaseTest {
    HomePage homePage;
    UserMgtPage userMgtPage;

    UserDbPage userDbPage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new HomePage(getDriver());
        userMgtPage =  new UserMgtPage(getDriver());
        userDbPage = new UserDbPage(getDriver());

    }
    @Test(testName = "AccessDBTitle",description = "Verify title of the page is User DB")
    public void test02(){
        homePage.click(homePage.userMgtBtn);
        userMgtPage.click(userMgtPage.accessdbBtn);

        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle,"User DB");
    }
    @DataProvider(name = "Role")
    public Object[][] data(){
        Object[][] data = new Object[3][5];
        data[0][0] = "Allie";
        data[0][1] = "Gerber";
        data[0][2] = "2024567890";
        data[0][3] = "allie.g@hotmail.com";
        data[0][4] = "Student";

        data[1][0] = "Cody";
        data[1][1] = "Doe";
        data[1][2] = "5711234567";
        data[1][3] = "cody.d@hotmail.com";
        data[1][4] = "Instructor";

        data[2][0] = "Susan";
        data[2][1] = "Johnson";
        data[2][2] = "2022345678";
        data[2][3] = "susan.j@hotmail.com";
        data[2][4] = "Mentor";

        return data;
    }
    @Test(testName = "Submit Database Test", dataProvider = "Role")
    public void test03(String first, String last, String phone, String email, String role){
        homePage.click(homePage.userMgtBtn);

        userMgtPage.firstName.sendKeys(first);
        userMgtPage.lastName.sendKeys(last);
        userMgtPage.phone.sendKeys(phone);
        userMgtPage.email.sendKeys(email);

        userMgtPage.roles.click();
        Select select = new Select(userMgtPage.roles);
        select.selectByVisibleText(role);

        userMgtPage.submitBtn.click();
        userMgtPage.submitTableBtn.click();

        userMgtPage.click(userMgtPage.accessdbBtn);

        userDbPage.moveIntoView(userDbPage.lastTable);

        Assert.assertTrue(userDbPage.lastTable.isDisplayed());

    }
}
