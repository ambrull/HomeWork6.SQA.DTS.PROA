import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test //Tag running script
    public void openbrowser(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();//
        driver.get(baseUrl);
        String tittle = driver.getTitle();
        System.out.println(tittle);

        driver.close();

    }

    @Test
    public void succes_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();//
        driver.get(baseUrl);
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();

        String LogoApp = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(LogoApp, "Swag Labs");

        driver.close();

    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();//
        driver.get(baseUrl);
        //input valid email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input invalid password
        driver.findElement(By.id("password")).sendKeys("wrong_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();

        String ErrorAlert = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals(ErrorAlert, "Epic sadface: Username and password do not match any user in this service");

        driver.close();

    }
}

