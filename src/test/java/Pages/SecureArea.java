package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureArea extends BaseTest {
    public SecureArea(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".icon-2x.icon-signout")
    public WebElement logoutButton;

    @FindBy(id ="flash")
    public WebElement flashMessage;


    public void clickOnLogoutButton(){
        logoutButton.click();
    }
}
