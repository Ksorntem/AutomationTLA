package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserDbPage;
import pages.UserMgtPage;
import utils.SeleniumUtils;

public class UserDbTest extends BaseTest {
    HomePage homePage;
    UserMgtPage userMgtPage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new HomePage(getDriver());
        userMgtPage =  new UserMgtPage(getDriver());

    }
    @Test(testName = "AccessDBTitle",description = "Verify title of the page is User DB")
    public void test02(){
        homePage.click(homePage.userMgtBtn);
        userMgtPage.click(userMgtPage.accessdbBtn);

        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle,"User DB");
    }

}
