package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage loginID(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }

    public LoginFormPage password(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public LoginFormPage signIn(){
        navegador.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();
        return this;
    }

    public SecretPage sendCredentials(String loginID, String password){
        loginID(loginID);
        password(password);
        signIn();
        return new SecretPage(navegador);
    }



}
