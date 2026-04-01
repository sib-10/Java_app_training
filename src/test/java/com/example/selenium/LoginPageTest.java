package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest extends BaseTest {

    @Test
    @DisplayName("Login page should load")
    void loginPageLoads() {
        driver.get(BASE_URL + "/login.jsp");
        takeScreenshot("login-page");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("username") || pageSource.contains("Username") || pageSource.contains("uid"),
            "Login page should have username field"
        );
    }

    @Test
    @DisplayName("Login with invalid credentials should fail")
    void loginWithInvalidCredentials() {
        driver.get(BASE_URL + "/login.jsp");

        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginBtn = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("invaliduser");
        password.sendKeys("invalidpass");
        loginBtn.click();

        takeScreenshot("invalid-login");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("error") || pageSource.contains("Error") || pageSource.contains("Login Failed"),
            "Should show error for invalid credentials"
        );
    }

    @Test
    @DisplayName("Login with valid credentials should succeed")
    void loginWithValidCredentials() {
        driver.get(BASE_URL + "/login.jsp");

        // testfire.net demo credentials
        WebElement username = driver.findElement(By.id("uid"));
        WebElement password = driver.findElement(By.id("passw"));
        WebElement loginBtn = driver.findElement(By.name("btnSubmit"));

        username.sendKeys("jsmith");
        password.sendKeys("Demo1234");
        loginBtn.click();

        takeScreenshot("valid-login");

        String pageSource = driver.getPageSource();
        assertTrue(
            pageSource.contains("Account Summary") || pageSource.contains("Sign Off") || pageSource.contains("Logout"),
            "Should show account page after login"
        );
    }
}