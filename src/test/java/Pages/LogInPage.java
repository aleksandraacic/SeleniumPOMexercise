package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseTest {

    public LogInPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="username")
    public WebElement username;

    @FindBy(id ="password")
    public WebElement password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement flashMessage;

    public void inputUsername(String validUsername){
        username.clear();
        username.sendKeys(validUsername);
    }

    public void inputPassword(String validPassword){
        password.clear();
        password.sendKeys(validPassword);
    }

    public void clickOnloginButton(){
        loginButton.click();
    }
}