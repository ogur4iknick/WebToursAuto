package ru.webtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElements {

    @FindBy(xpath = "//input[@type='text']")
    public WebElement login;
    @FindBy(xpath="//input[@type='password']")
    public WebElement password;
    @FindBy(xpath="//input[@type='image']")
    public WebElement but;

    @FindBy(xpath="//img[@alt='Search Flights Button']")
    public WebElement but0;

    @FindBy(xpath="//input[@type='image']")
    public WebElement but1;

    @FindBy(xpath="//input[@type='image']")
    public WebElement but2;

    @FindBy(xpath="//input[@type='image']")
    public WebElement but3;
    @FindBy(xpath="//input[@name='creditCard']")
    public WebElement cc;
    @FindBy(xpath="//input[@name='expDate']")
    public WebElement ed;

    @FindBy(xpath="//img[@alt='SignOff Button']")
    public WebElement but4;

}
