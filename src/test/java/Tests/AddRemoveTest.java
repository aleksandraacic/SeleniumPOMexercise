package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyAddRemoveFunctionality() {
        homePage.clickOnAddremove();
        addRemove.clickOnAdd();
        addRemove.clickOnDelete();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the- internet.herokuapp.com/add_remove_elements/");
        boolean delete = false;

        try{
            delete = addRemove.getDeleteButton().isDisplayed();

        }catch(Exception e){}

        Assert.assertFalse(delete);
    }
}

