package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMoreDataAboutYou(){

        navegador.findElement(By.xpath("//div[@class='row']//a[@href='#moredata']")).click();
        return this;
    }

    public AddContactPage addMoreData(){
        navegador.findElement(By.xpath("//div[@class='row center']//button[@data-target='addmoredata']")).click();
        return new AddContactPage(navegador);

    }


}
