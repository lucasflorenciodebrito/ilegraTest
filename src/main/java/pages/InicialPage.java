package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InicialPage {

    private WebDriver navegador;

    public InicialPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public InicialPage clicarNaLupa (){
        WebElement lupa =navegador.findElement(By.id("search-open"));
        lupa.click();

        return this;
    }

    public  InicialPage digitarAPesquisa(String termoPesquisado){
        WebElement campoPesquisar = navegador.findElement(By.cssSelector("div[class='desktop-search'] input[placeholder='Pesquisar …']"));
        campoPesquisar.sendKeys(termoPesquisado);
        return this;
    }


    public PesquisaPage clicarEmPesquisar () {
        WebElement botaoPesquisar = navegador.findElement(By.cssSelector("div[class='desktop-search'] input[value='Pesquisar']"));
        botaoPesquisar.click();

        return new PesquisaPage(navegador);
    }
}
