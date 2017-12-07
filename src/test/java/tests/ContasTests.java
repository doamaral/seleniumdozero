package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.LoginPage;

public class ContasTests extends BaseTest{
    @Test
    public void addAccountUserTest(){
        String msgSuccess = new LoginPage()
                .loginUser("asdf@gmail.com", "123456")
                .selectAddAccountMenu()
                .fillNewAccountForm()
                .submitNewAccountForm()
                .getSuccessMessage();
        Assert.assertEquals("Conta adicionada com sucesso!", msgSuccess);
    }
    @Test
    public void addAllreadyExistentAccountUserTest(){
        String msgSuccess = new LoginPage()
                .loginUser("asdf@gmail.com", "123456")
                .selectAddAccountMenu()
                .fillNewAccountForm("Conta mesmo nome")
                .submitNewAccountForm()
                .getFailMessage();
        Assert.assertEquals("Já existe uma conta com esse nome!", msgSuccess);
    }

    @Test
    @Ignore("asdf")
    public void editAccount(){
        String msgSuccess = new LoginPage()
                .loginUser("asdf@gmail.com", "123456")
                .selectListAccountsMenu()
                .selectAccountToEdit("Conta para alterar", "Conta alterada")
                .editAccountName()
                .getSuccessMessage();
        Assert.assertEquals("Conta alterada com sucesso!", msgSuccess);
    }
    @Test
    public void removeAccountWithMovementTest(){
        String msgSuccess = new LoginPage().loginUser("asdf@gmail.com", "123456")
                .selectListAccountsMenu()
                .deleteAccount("Conta com movimentacao")
                .getFailMessage();
        Assert.assertEquals("Conta em uso na movimentações", msgSuccess);
    }
}
