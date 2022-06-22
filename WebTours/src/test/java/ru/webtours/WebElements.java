package ru.webtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebElements {
    //Авторизация
    @FindBy(xpath = "//input[@type='text']")
    public WebElement login;
    @FindBy(xpath="//input[@type='password']")
    public WebElement password;
    @FindBy(xpath="//input[@type='image']")
    public WebElement cont;

    //Главная страница(билеты, деавторизация)
    @FindBy(xpath="//img[@alt='Search Flights Button']")
    public WebElement flb;
    @FindBy(xpath="//img[@alt='SignOff Button']")
    public WebElement sofb;

    //Первая страница покупки билетов
    @FindAll({@FindBy(xpath = "//input[@type='radio' and @name='seatPref']")})
    public List<WebElement> rbfp1;

    @FindAll({@FindBy(xpath = "//input[@type='radio' and @name='seatType']")})
    public List<WebElement> rbfp2;

    @FindAll({@FindBy(xpath = "//select[@name='depart']/option[@value]")})
    public List<WebElement> rbfp3;

    @FindAll({@FindBy(xpath = "//select[@name='arrive']/option[@value]")})
    public List<WebElement> rbfp4;

    //Вторая страница покупки билетов
    @FindAll({@FindBy(xpath = "//input[@type='radio']")})
    public List <WebElement> rbsp;

    //Третья страница покупки билетов
    @FindBy(xpath="//input[@name='creditCard']")
    public WebElement cc;
    @FindBy(xpath="//input[@name='expDate']")
    public WebElement ed;



}
