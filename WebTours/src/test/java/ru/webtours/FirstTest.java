package ru.webtours;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest extends WebDriverSettings {

    @Test
    public void login() {
        //Авторизация
        driver.get("http://webtours.load-test.ru:1080/webtours/");
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("niklogin");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("nikpassword");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        //Открытие меню полетов
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt='Search Flights Button']")).click();

        //Ввод первоначальных данных
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        //Выбор предложенных вариантов
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        //Ввод данных
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
        driver.findElement(By.xpath("//input[@name='creditCard']")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.xpath("//input[@name='expDate']")).sendKeys("12/24");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        //Деавторизация
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
        driver.findElement(By.xpath("//img[@alt='SignOff Button']")).click();
    }

    /*@Test
    public void firstTest2() {

        driver.get("http://webtours.load-test.ru:1080/cgi-bin/welcome.pl?page=search");

    }*/



}
