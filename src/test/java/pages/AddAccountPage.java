package pages;

import core.BasePage;
import org.openqa.selenium.By;
import java.util.Date;

import static core.DriverFactory.getDriver;

public class AddAccountPage extends BasePage {
    public AddAccountPage fillNewAccountForm(){
        fillTextFieldById("nome", "Conta "+ new Date().getTime());
        return this;
    }

    public AddAccountPage fillNewAccountForm(String conta){
        fillTextFieldById("nome", conta);
        return this;
    }

    public ListAccountsPage submitNewAccountForm(){
        getDriver().findElement(By.xpath("//button[.=\"Salvar\"]")).click();
        return new ListAccountsPage();
    }
}
