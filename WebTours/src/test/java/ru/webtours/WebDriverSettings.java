package ru.webtours;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/nmindov/IdeaProjects/WebTours/chromedriver.exe");
        driver = new ChromeDriver();
    }

   /* @After
    public void close() {
        driver.quit();
    }*/

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




}
