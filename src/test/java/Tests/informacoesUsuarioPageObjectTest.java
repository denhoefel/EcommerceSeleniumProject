package Tests;


import Pages.LoginPage;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class informacoesUsuarioPageObjectTest {
    private WebDriver navigator;

    @Before
    public void setup() {
        navigator = Web.createChrome();
    }


    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name = "login") String login,
            @Param(name = "password") String password,
            @Param(name = "tipo") String tipo,
            @Param(name = "contato") String contato,
            @Param(name = "mensagem") String mensagem) {
        new LoginPage(navigator)
                .signIn()
                .sendCredentials(login, password)
                .clickMe()
                .clickMoreDataAboutYou()
                .addMoreData()
                .AddContact(tipo, contato);

        String expectedmessage = mensagem;
        String popUpMessage = navigator.findElement(By.xpath("//div[@id=\"toast-container\"]//div[@class=\"toast rounded\"]")).getText();

        Assert.assertEquals(expectedmessage, popUpMessage);
    }

    @After
    public void tearDown() {
        navigator.close();
    }

}
