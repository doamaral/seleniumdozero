package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class ListAccountsPage extends BasePage {
    public EditAccountPage selectAccountToEdit(String oldname, String newname) {
        // xpath //td[.="Conta 1512322711315"]/..//span[@class="glyphicon glyphicon-edit"]/../
        getDriver().findElement(By.xpath("//td[.=\"" + oldname + "\"]/..//span[@class=\"glyphicon glyphicon-edit\"]/..")).click();
        return new EditAccountPage(newname);
    }

    public ListAccountsPage deleteAccount(String accountName){
        // xpath //td[.="Conta 1512322711315"]/..//span[@class="glyphicon glyphicon-edit"]/../
        getDriver().findElement(By.xpath("//td[.=\"" + accountName + "\"]/..//span[@class=\"glyphicon glyphicon-remove-circle\"]/..")).click();
        return this;

    }
}
