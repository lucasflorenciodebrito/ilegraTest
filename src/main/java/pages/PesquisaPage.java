package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaPage {
    private WebDriver navegador;

    public PesquisaPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String retornaMensagemEncontrada(){
        WebElement mensagem = navegador.findElement(By.className("entry-title"));
        return mensagem.getText();
    }

}
