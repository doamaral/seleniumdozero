package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.DriverFactory.getDriver;

public class NovoUsuarioPage extends BasePage{
    public String getEmailFailMessage(){
        return getDriver().findElement(By.xpath("//*[.=\"Endereço de email já utilizado\"]")).getText();
    }
    public NovoUsuarioPage fillNewUserForm(String nome, String email, String senha){
        fillTextFieldById("nome", nome);
        fillTextFieldById("email", email);
        fillTextFieldById("senha", senha);
        return this;
    }
    public NovoUsuarioPage submitUserForm(){
        getDriver().findElement(By.xpath("//input[@type=\"submit\"]")).click();
        return this;
    }
}
