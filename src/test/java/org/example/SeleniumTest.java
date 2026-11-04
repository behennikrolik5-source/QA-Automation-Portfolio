package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    @Test
    public void testGoogleSearch() {
        // 1. Запускаем Chrome (Selenium 4 сам скачает нужный драйвер)
        WebDriver driver = new ChromeDriver();

        try {
            // 2. Открываем страницу
            driver.get("https://www.bing.com/");

            // 3. Находим строку поиска по имени элемента (name="q")
            WebElement searchBox = driver.findElement(By.name("q"));

            // 4. Вводим текст
            searchBox.sendKeys("T-Bank QA");

            // 5. Нажимаем Enter (submit)
            searchBox.submit();

            // Ждем пару секунд, чтобы ты увидел результат
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 6. Обязательно закрываем браузер
            driver.quit();
        }
    }
}