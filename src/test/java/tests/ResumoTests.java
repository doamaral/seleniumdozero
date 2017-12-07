package tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class ResumoTests extends BaseTest{
    @Test
    public void removeMovement(){
        //Teste para Remoção
        String msgSuccess = new LoginPage().loginUser("asdf@gmail.com","123456")
                .selectMonthlySummaryMenu()
                .deleteAnyMoviment()
                .getSuccessMessage();
        Assert.assertEquals("Movimentação removida com sucesso!", msgSuccess);
    }
}
