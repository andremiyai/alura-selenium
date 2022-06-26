package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {


    private LeiloesPage paginaDeLeiloes;

    private CadastroLeilaoPage paginaDeCadastro;

    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fechar();
    }

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano","pass");
        paginaDeLeiloes = paginaDeLogin.efetuaLogin();

        paginaDeCadastro = paginaDeLeiloes.navegarParaFormularioCadastro();
    }

    @Test
    public void deveriaCadastrarLeilao() throws InterruptedException {

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";
        paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome,valor,hoje);

        Assertions.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() throws InterruptedException {
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("","","");
        Assertions.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
    }
}
