package ru.webtours;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main  {
    public static Scripts scripts;
    public static WebDriver driver;

    public void frameOne(){
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
    }

    public void frameNavbar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("navbar");
    }

    public void frameInfo(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame("body");
        driver.switchTo().frame("info");
    }

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "/Users/nmindov/IdeaProjects/WebTours/chromedriver.exe");
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        scripts = new Scripts(driver);
    }

    @Test
    public void main() {

        //Авторизация
        driver.get("http://webtours.load-test.ru:1080/webtours/");
        frameOne();
        scripts.userlogin("niklogin", "nikpassword");

        //Открытие меню билетов
        frameNavbar();
        scripts.flightsZero();

        //Ввод первоначальных данных
        frameInfo();
        scripts.flightsFirst();

        //Выбор предложенных вариантов
        frameInfo();
        scripts.flightsSecond();

        //Ввод окончательных данных
        frameInfo();
        scripts.flightsThird("4111 1111 1111 1111", "12/24");

        //Деавторизация
        frameNavbar();
        scripts.userlogout();
    }

}
