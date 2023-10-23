package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement addRemove;
    public Homepage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }
    public WebElement getAddRemove() {
        return driver.findElement(By.linkText("Add/Remove Elements"));
    }
    //--------------------------------------
    public void clickOnAddremove(){
        getAddRemove().click();}
}
