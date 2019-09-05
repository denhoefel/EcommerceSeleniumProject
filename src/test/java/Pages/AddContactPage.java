package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends MePage {


    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }



    public AddContactPage setContactType(String contactType){

        WebElement dataType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(dataType).selectByVisibleText(contactType);
        return this;

    }

    public AddContactPage writeContact(String contactInformation){
        WebElement contact = navegador.findElement(By.id("addmoredata")).findElement(By.name("contact"));
        contact.sendKeys(contactInformation);

        return this;

    }

    public MePage clickOnSave(){
        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(navegador);

     }

     public MePage AddContact(String contactType, String contactInformation){
        setContactType(contactType);
        writeContact(contactInformation);
        clickOnSave();
        return new MePage(navegador);
    }
}
