package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static core.DriverFactory.getDriver;

public class AddMovimentToAccount extends BasePage {
    public AddMovimentToAccount fillMovimentForm(String tipo,
                                                 String datamovimentacao,
                                                 String datapagamento,
                                                 String descricao,
                                                 String interessado,
                                                 String valor,
                                                 String conta,
                                                 boolean pago){
        WebElement elemento = getDriver().findElement(By.id("tipo"));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(tipo);

        fillTextFieldById("data_transacao", datamovimentacao);
        fillTextFieldById("data_pagamento", datapagamento);
        fillTextFieldById("descricao", descricao);
        fillTextFieldById("interessado", interessado);
        fillTextFieldById("valor", valor);

        elemento = getDriver().findElement(By.id("conta"));
        combo = new Select(elemento);
        combo.selectByVisibleText(conta);

        if(pago){
            getDriver().findElement(By.id("status_pago")).click();
        }else {
            getDriver().findElement(By.id("status_pendente")).click();
        }

        return this;
    }
    public AddMovimentToAccount submitNewMovimentToAccountForm(){
        getDriver().findElement(By.xpath("//button[.=\"Salvar\"]")).click();
        return this;
    }
    public List<String> getErrorListRequiredFields(){
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class=\"alert alert-danger\"]//li"));
        List<String> listaTextoErros = new ArrayList<String>();
        for(WebElement itemerro:elements){
            listaTextoErros.add(itemerro.getText());
        }
        return listaTextoErros;
    }
}
