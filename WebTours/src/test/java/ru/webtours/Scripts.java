package ru.webtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Scripts extends WebElements {

    public WebDriver driver;

    public Scripts(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Авторизация
    public void userlogin(String log, String pass){
        login.sendKeys(log);
        password.sendKeys(pass);
        cont.click();
    }
    //Главная страница
    public void flightsZero(){
        flb.click();
    }
    //Первая страница покупки билетов
    public void flightsFirst(){
        WebElement re1 = rbfp1.get(new Random().nextInt(rbfp1.size()));
        WebElement re2 = rbfp2.get(new Random().nextInt(rbfp2.size()));
        WebElement re3 = rbfp3.get(new Random().nextInt(rbfp3.size()));
        WebElement re4 = rbfp4.get(new Random().nextInt(rbfp4.size()));
        re1.click();
        re2.click();
        re3.click();
        re4.click();
        cont.click();
    }
    //Вторая страница покупки билетов
    public void flightsSecond(){
        WebElement re3 = rbsp.get(new Random().nextInt(rbsp.size()));
        re3.click();
        cont.click();
    }
    //Третья страница покупки билетов
    public void flightsThird(String crd, String exdat){
        cc.sendKeys(crd);
        ed.sendKeys(exdat);
        cont.click();
    }
    //Деавторизация
    public void userlogout(){
        sofb.click();
    }
}
