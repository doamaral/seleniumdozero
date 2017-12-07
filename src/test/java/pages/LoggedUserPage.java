package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class LoggedUserPage extends BasePage{
    public String getLoggedMessage(){
        //Bem vindo, Lucas!
        return getDriver().findElement(By.xpath("//*[.=\"Bem vindo, Lucas!\"]")).getText();
    }
    public AddAccountPage selectAddAccountMenu(){
        getDriver().findElement(By.xpath("//*[.=\"Contas \"]")).click();
        getDriver().findElement(By.linkText("Adicionar")).click();
        return new AddAccountPage();
    }
    public ListAccountsPage selectListAccountsMenu(){
        getDriver().findElement(By.xpath("//*[.=\"Contas \"]")).click();
        getDriver().findElement(By.linkText("Listar")).click();
        return new ListAccountsPage();
    }

    public AddMovimentToAccount selectAddMovimentMenu(){
        getDriver().findElement(By.linkText("Criar Movimentação")).click();
        return new AddMovimentToAccount();
    }
    public MonthlySummaryPage selectMonthlySummaryMenu(){
        getDriver().findElement(By.linkText("Resumo Mensal")).click();
        return new MonthlySummaryPage();
    }
    public LoggedUserPage selectResetHiddenLink(){
        getDriver().findElement(By.linkText("reset")).click();
        return this;
    }

}
