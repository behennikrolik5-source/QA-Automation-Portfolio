package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        WebElement title = driver.findElement(By.className("app_logo"));
        String actualLogo = title.getText();
        // 5. Сравниваем ожидаемое с фактическим
        assertEquals("Swag Labs", actualLogo);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }



}