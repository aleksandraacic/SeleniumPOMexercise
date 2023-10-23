package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage2 extends BaseTest {
    public HomePage2()  {
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Form Authentication")
    public WebElement formAuthenticationButton;

    public void clickOnFormAuthenticationButton() {
        formAuthenticationButton.click();
    }
}

