package modulos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InicialPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PesquisaTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.navegador.get("https://blogdoagi.com.br/");

    }

    @Test
    @DisplayName("Pesquisar  por artigos com sucesso")
    public void pesquisarComSucesso() {
        final String termo = "carreira";
        new InicialPage(navegador)
                .clicarNaLupa()
                .digitarAPesquisa(termo)
                .clicarEmPesquisar();

        assertEquals("https://blogdoagi.com.br/?s=carreira", navegador.getCurrentUrl());


    }

    @Test
    @DisplayName("Pesquisa que não retorna artigo deve ter a mensagem Nenhum Resultado")
    public void pesquisarSemRetornoDeArtigos() {
        String mensagemResultadoPesquisa = new InicialPage(navegador)
                .clicarNaLupa()
                .digitarAPesquisa("Topico sem nada relacionado")
                .clicarEmPesquisar()
                .retornaMensagemEncontrada();

        assertEquals("Nenhum resultado", mensagemResultadoPesquisa);

    }

    @AfterEach
    public void afterEach() {
        navegador.quit();
    }

}
