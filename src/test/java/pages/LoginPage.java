package pages;

import core.BasePage;
import org.openqa.selenium.By;
import static core.DriverFactory.getDriver;

public class LoginPage extends BasePage{
    public LoginPage acccessLoginPage(){
        getDriver().get("https://srbarriga.herokuapp.com/login");
        return this;
    }
    public NovoUsuarioPage goToNovoUsuario(){
        getDriver().findElement(By.linkText("Novo usuário?")).click();
        return new NovoUsuarioPage();
    }
    public LoggedUserPage submitLoginForm(){
        getDriver().findElement(By.xpath("//button[.=\"Entrar\"]")).click();
        return new LoggedUserPage();
    }
    public LoginPage submitLoginForm(boolean erro){
        getDriver().findElement(By.xpath("//button[.=\"Entrar\"]")).click();
        return this;
    }

    public String getLoginFailMessage(){
        //Problemas com o login do usuário
        return getDriver().findElement(By.xpath("//*[.=\"Problemas com o login do usuário\"]")).getText();
    }
    public LoggedUserPage loginUser (String usuario, String senha){
        fillTextFieldById("email", usuario);
        fillTextFieldById("senha", senha);
        return submitLoginForm();
    }

    public LoginPage loginUser (String usuario, String senha, boolean erro){
        fillTextFieldById("email", usuario);
        fillTextFieldById("senha", senha);
        return submitLoginForm(erro);
    }
}
