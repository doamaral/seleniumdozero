package tests;

import core.BaseTest;
import core.Utilities;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

import java.util.Arrays;
import java.util.List;

public class MovimentacaoTests extends BaseTest{

    @Test
    public void addMovimentacaoToAccountTest(){
        String msgSuccess = new LoginPage().loginUser("asdf@gmail.com","123456")
                .selectAddMovimentMenu()
                .fillMovimentForm("Receita",
                        Utilities.getSimplifiedFormatDate(Utilities.getTodayDatePlusDays(-1)),
                        Utilities.getSimplifiedFormatDate(Utilities.getTodayDatePlusDays(0)),
                        "Movimentação",
                        "Lucas",
                         "100",
                        "Conta para movimentacoes",
                        true)
                .submitNewMovimentToAccountForm()
                .getSuccessMessage();
        Assert.assertEquals("Movimentação adicionada com sucesso!", msgSuccess);
    }
    @Test
    public void requiredFieldsTest(){
        List<String> erros = new LoginPage()
                .loginUser("asdf@gmail.com","123456")
                .selectAddMovimentMenu()
                .submitNewMovimentToAccountForm()
                .getErrorListRequiredFields();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
                )));
    }
    @Test
    public void ruleFutureDateForbidden(){
        String msgSuccess = new LoginPage().loginUser("asdf@gmail.com","123456")
                .selectAddMovimentMenu().fillMovimentForm("Receita",
                        Utilities.getSimplifiedFormatDate(Utilities.getTodayDatePlusDays(3)),
                        Utilities.getSimplifiedFormatDate(Utilities.getTodayDatePlusDays(3)),
                        "Teste de Movimentação",
                        "Lucas",
                        "100",
                        "Conta para movimentacoes",
                        true)
                .submitNewMovimentToAccountForm()
                .getFailMessage();
        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", msgSuccess);
    }
}
