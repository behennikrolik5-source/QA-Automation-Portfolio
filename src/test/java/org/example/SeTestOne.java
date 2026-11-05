package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeTestOne {

    WebDriver driver; // Объявляем драйвер на уровне класса

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(); // Открываем браузер ПЕРЕД каждым тестом
        driver.manage().window().maximize(); // Разворачиваем на весь экран
    }

    @Test
    public void testLogin() {
        // 1. Открываем сайт
        driver.get("https://www.saucedemo.com/");
//         2. Вводим данные
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//         3. Нажимаем кнопку
        driver.findElement(By.id("login-button")).click();
        // 4. Проверяем, что мы залогинились (ищем заголовок)
        WebElement title = driver.findElement(By.className("app_logo"));
        String actualLogo = title.getText();
        // 5. Сравниваем ожидаемое с фактическим
        assertEquals("Swag Labs", actualLogo);
    }

    @Test
    public void testBuy() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement titlename = driver.findElement(By.className("app_logo"));
        String actualLogo = titlename.getText();
        // 5. Сравниваем ожидаемое с фактическим
        assertEquals("Swag Labs", actualLogo);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link")).click();

        WebElement logoName = driver.findElement(By.className("login_logo"));
        String logout = logoName.getText();
        assertEquals("Swag Labs",logout);
    }
//не сработал тк не смог понять как зацепиться с еррор меседж текст как будто не привязан к эелементу =\
    @Test
    public void lockeduserloginTry(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement errormessage = driver.findElement(By.cssSelector("[data-test='error']"));
        String errorbutton = errormessage.getText();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorbutton);
    }

    @Test
    public void buytry (){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement logoutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("cart_item")));
        List<WebElement> inventoryItems = new ArrayList<>();
        WebElement cardbase = driver.findElement(By.className("cart_item"));
        WebElement cardbaseparams = cardbase.findElement(By.className("cart_quantity"));
        String quantityone = cardbaseparams.getText();
        assertEquals("1",quantityone);
        WebElement level2 = cardbase.findElement(By.id("item_4_title_link"));
        WebElement level3 = level2.findElement(By.className("inventory_item_name"));
        String itemname = level3.getText();
        assertEquals("Sauce Labs Backpack", itemname);
        WebElement level4 = driver.findElement(By.id("item_0_title_link"));
        WebElement level5 = level4.findElement(By.className("inventory_item_name"));
        String itemname2 = level3.getText();
        assertEquals("Sauce Labs Bike Light", itemname2);


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер ПОСЛЕ каждого теста
        }
    }
}
