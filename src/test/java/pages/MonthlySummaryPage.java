package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.DriverFactory.getDriver;

public class MonthlySummaryPage extends BasePage {
    public  MonthlySummaryPage deleteMovimentByDescription(String movimentDescription){
        getDriver().findElement(By.xpath("//td[.=\""+movimentDescription+"\"]/..//a")).click();
        return this;
    }
    public  MonthlySummaryPage deleteAnyMoviment(){
        getDriver().findElement(By.xpath("//span[@class=\"glyphicon glyphicon-remove-circle\"]")).click();
        return this;
    }

}
