package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testGetUser() {
        given() // 1. Подготовка (ничего не настраиваем, просто идём по URL)
                .baseUri("https://jsonplaceholder.typicode.com")
                .when() // 2. Действие (отправляем GET)
                .get("/users/1")
                .then() // 3. Проверки
                .statusCode(200) // Проверяем, что код 200
                .body("name", equalTo("Leanne Graham")); // Проверяем, что в JSON поле name равно нужному значению
    }
}
