package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;
import utils.SeleniumUtils;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new HomePage(getDriver());
    }

    @DataProvider(name = "links")
    public Object[] testData(){
        Object[][] data = new Object[7][2];
        data[0][0] = "PHP Travels";
        data[0][1] = "Demo Script Test drive - PHPTRAVELS";

        data[1][0] = "Mercury tours";
        data[1][1] = "demoaut.com&nbsp;-&nbsp;demoaut Resources and Information.";

        data[2][0] = "Internet";
        data[2][1] = "The Internet";

        data[3][0] = "E-commerce";
        data[3][1] = "My Store";

        data[4][0] = "Passion Tea Company";
        data[4][1] = "";

        data[5][0] = "Saucedemo";
        data[5][1] = "Swag Labs";

        data[6][0] = "Shopping Cart";
        data[6][1] = "Typescript React Shopping cart";

        return data;
    }
    @Test(testName = "Verify php Link",dataProvider = "links")
    public void phpLinkTest(String linkName, String expectedTitle) {

        homePage.click(homePage.phpTravelsBtn);

        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);

        Assert.assertEquals(actualTitle, expectedTitle);

    }

}


