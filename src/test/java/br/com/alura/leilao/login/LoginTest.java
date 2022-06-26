package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {


    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();
        Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos(){
        paginaDeLogin.preencheFormularioDeLogin("fulano","pass2");
        paginaDeLogin.efetuaLogin();
        Assertions.assertTrue(paginaDeLogin.isPaginaDeErroDeLogin());
        Assertions.assertTrue(paginaDeLogin.possuiMensagemUsuarioInvalido());
//        Assertions.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaParaPaginaDeLances();

        Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assertions.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }
}
