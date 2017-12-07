package core;

import org.openqa.selenium.By;
import pages.LoggedUserPage;
import pages.NovoUsuarioPage;

import static core.DriverFactory.getDriver;

public class BasePage {
    public void fillTextFieldById(String id, String value){
        getDriver().findElement(By.id(id)).clear();
        getDriver().findElement(By.id(id)).sendKeys(value);
    }
    public void elementClickById(String id){
        getDriver().findElement(By.id(id)).click();
    }
    public String getSuccessMessage(){
        return getDriver().findElement(By.className("alert-success")).getText();
    }
    public String getFailMessage(){
        return getDriver().findElement(By.className("alert-danger")).getText();
    }

}
