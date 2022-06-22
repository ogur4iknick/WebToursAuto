package ru.webtours;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class Main  {
    public static Scripts scripts;
    public static WebDriver driver;

    String CSV_PATH = "C:/Users/nmindov/IdeaProjects/WebTours/src/main/resources/users.csv";
    private CSVReader csvReader;
    String[] csvCell;

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

    public void main() throws IOException, CsvValidationException, InterruptedException {

        //Авторизация
        driver.get("http://webtours.load-test.ru:1080/webtours/");
        csvReader = new CSVReader(new FileReader(CSV_PATH));

        while ((csvCell = csvReader.readNext()) != null) {
            for(int i=0;i<1;i++){
                frameNavbar();
                String CustomerName = csvCell[i];
                String CustomerPassword = csvCell[i+1];
                System.out.println(CustomerName);
                System.out.println(CustomerPassword);
                driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CustomerName);
                driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CustomerPassword);
                driver.findElement(By.xpath("//input[@type='image']")).click();

            }

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

            Thread.sleep(5000);
        }
        //scripts.userlogin("niklogin", "nikpassword");


    }

    /*@After
    public void close() {
        driver.close();
    }*/
}
