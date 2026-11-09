package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameFileId = By.id("user-name");
    private  By passwordFileId = By.id("password");
    private  By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username){
        driver.findElement(usernameFileId).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordFileId).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void login (String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
