package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pages.LoginPage;

import java.util.Date;

public class UserTests extends BaseTest{
    @Test
    @Ignore("Desprezível para os testes")
    public void addUserTest(){
        //1. Inserir Conta
        String msgSuccess = new LoginPage().goToNovoUsuario()
                .fillNewUserForm("Lucas", "asdf."+new Date().getTime()+"@gmail.com", "123456")
                .submitUserForm()
                .getSuccessMessage();
        Assert.assertEquals("Usuário inserido com sucesso", msgSuccess);
    }

    @Test
    public void addAlreadyAddedUserTest(){
        String msgSuccess = new LoginPage().goToNovoUsuario()
                .fillNewUserForm("Lucas", "asdf@gmail.com", "123456")
                .submitUserForm()
                .getFailMessage();
        Assert.assertEquals("Endereço de email já utilizado", msgSuccess);
    }

    @Test
    public void LoginUserTest(){
        //1. Inserir Conta
        String msgSuccess = new LoginPage()
                .loginUser("asdf@gmail.com", "123456")
                .getLoggedMessage();
        Assert.assertEquals("Bem vindo, Lucas!", msgSuccess);
    }

    @Test
    public void LoginWrongUserTest(){
        //1. Inserir Conta
        boolean erro = true;
        String msgFail = new LoginPage()
                .loginUser("asdf-erro@gmail.com", "123456",erro)
                .getLoginFailMessage();
        Assert.assertEquals("Problemas com o login do usuário", msgFail);
    }
}
