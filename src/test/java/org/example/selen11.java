import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class selen11 {

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
//        WebElement title = driver.findElement(By.className("title"));
//        String actualText = title.getText();

        // 5. Сравниваем ожидаемое с фактическим
//        assertEquals("Products", actualText);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        WebElement packege = driver.findElement(By.className("shopping_cart_badge"));
        String actualText = packege.getText();
        assertEquals("1", actualText);


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер ПОСЛЕ каждого теста
        }
    }
}
