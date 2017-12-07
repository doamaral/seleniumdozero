package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class EditAccountPage extends BasePage{

    private String name;

    public EditAccountPage(String name){
        this.name = name;
    }

    public ListAccountsPage editAccountName(){
        fillTextFieldById("nome", this.name);
        return submitEditAccountForm();
    }
    public ListAccountsPage submitEditAccountForm(){
        getDriver().findElement(By.xpath("//button[.=\"Salvar\"]")).click();
        return new ListAccountsPage();
    }
}
