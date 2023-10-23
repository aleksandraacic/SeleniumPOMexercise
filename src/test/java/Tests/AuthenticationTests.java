package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver .navigate().to("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyUserCanLoginValidCredentials() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = excelReader.getStringData("List1", 1, 0);
        String validPassword = excelReader.getStringData("List1", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        Assert.assertTrue(secureArea.logoutButton.isDisplayed());
        Assert.assertTrue(secureArea.flashMessage.isDisplayed());

        String expectedflashText = excelReader.getStringData("List1", 1, 3);
        System.out.println(expectedflashText);
        System.out.println(secureArea.flashMessage.getText());
        System.out.println(secureArea.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2));
        Assert.assertEquals(secureArea.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2), expectedflashText);
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
    }

    @Test
    public void verifyUserCannotLoginInvalidPassword() {

       homePage2.clickOnFormAuthenticationButton();
        String validUsername = excelReader.getStringData("List1", 1, 0);
        String validPassword = excelReader.getStringData("List1", 1, 4);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        boolean logout = false;
        try{
            logout = secureArea.logoutButton.isDisplayed();

        }catch(Exception e){}
        Assert.assertFalse(logout);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyUserCannotLoginInvalidUsername() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = excelReader.getStringData("List1", 1, 5);
        String validPassword = excelReader.getStringData("List1", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        boolean logout = false;
        try{
            logout = secureArea.logoutButton.isDisplayed();

        }catch(Exception e){}
        Assert.assertFalse(logout);
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyUserCannotLoginWithoutUsername() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = "";
        String validPassword = excelReader.getStringData("List1", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        boolean logout = false;
        try{
            logout = secureArea.logoutButton.isDisplayed();


        }catch(Exception e){}
        Assert.assertFalse(logout);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyUserCannotLoginWithoutPassword() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = excelReader.getStringData("List1", 1, 5);
        String validPassword = "";;
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        boolean logout = false;
        try{
            logout = secureArea.logoutButton.isDisplayed();

        }catch(Exception e){}
        Assert.assertFalse(logout);
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyUserCannotLoginWithoutCredentials() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = "";
        String validPassword = "";
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        boolean logout = false;
        try{
            logout = secureArea.logoutButton.isDisplayed();

        }catch(Exception e){}
        Assert.assertFalse(logout);
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
    }
    @Test
    public void verifyUserCanLogout() {
        homePage2.clickOnFormAuthenticationButton();
        String validUsername = excelReader.getStringData("List1", 1, 0);
        String validPassword = excelReader.getStringData("List1", 1, 1);
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnloginButton();
        Assert.assertTrue(secureArea.logoutButton.isDisplayed());
        Assert.assertTrue(secureArea.flashMessage.isDisplayed());
        String expectedflashText = excelReader.getStringData("List1", 1, 3);
        System.out.println(expectedflashText);
        System.out.println(secureArea.flashMessage.getText());
        System.out.println(secureArea.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2));
        Assert.assertEquals(secureArea.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2), expectedflashText);

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        secureArea.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        String expectedflashText1 = excelReader.getStringData("List1", 2, 3);
        System.out.println(expectedflashText1);
        System.out.println(loginPage.flashMessage.getText());
        System.out.println(loginPage.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2));
        Assert.assertEquals(loginPage.flashMessage.getText().substring( 0,
                secureArea.flashMessage.getText().length()-2), expectedflashText1);
    }
}
