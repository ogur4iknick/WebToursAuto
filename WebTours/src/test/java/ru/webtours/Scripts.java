package ru.webtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class Scripts extends WebElements {

    public WebDriver driver;

    public Scripts(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    public void userlogin(String log, String pass){
        login.sendKeys(log);
        password.sendKeys(pass);
        but.click();
    }

    public void flightsZero(){
        but0.click();
    }

    public void flightsFirst(){
        but1.click();
    }

    public void flightsSecond(){
        but2.click();
    }

    public void flightsThird(String crd, String exdat){
        cc.sendKeys(crd);
        ed.sendKeys(exdat);
        but3.click();
    }

    public void userlogout(){
        but4.click();
    }
}
