package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

public static WebDriver createChrome(){
    //opening the browser
    System.setProperty("webdriver.chrome.driver","C:\\Users\\Dênis\\drivers\\chromedriver.exe");
    WebDriver navegador = new ChromeDriver();
    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navegador.manage().window().maximize();

    //Navigate to the page
    navegador.get("http://www.juliodelima.com.br/taskit/");
    return navegador;
}

}



