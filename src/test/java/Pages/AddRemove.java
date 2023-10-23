package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddRemove {
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement addButton;
    WebElement deleteButton;

    public AddRemove(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.xpath("html/body/div[2]/div/div/button"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.xpath("html/body/div[2]/div/div/div/button"));
    }
    public void clickOnAdd(){
        getAddButton().click();
    }
    public void clickOnDelete(){
        getDeleteButton().click();
    }
}


