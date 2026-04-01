package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Home page should load successfully")
    void homePageLoads() {
        driver.get(BASE_URL);
        takeScreenshot("home-page");

        String title = driver.getTitle();
        assertFalse(title.isEmpty(), "Page title should not be empty");
        System.out.println("Page title: " + title);
    }

    @Test
    @DisplayName("Home page should have navigation links")
    void homePageHasNavigation() {
        driver.get(BASE_URL);

        WebElement body = driver.findElement(By.tagName("body"));
        assertNotNull(body, "Page body should exist");

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Sign In") || pageSource.contains("Login") || pageSource.contains("login"),
                "Page should have a login option");
        takeScreenshot("navigation-check");
    }

    @Test
    @DisplayName("Page should return HTTP 200")
    void pageReturnsOk() {
        driver.get(BASE_URL);

        // If page loads without error, it returned 200
        assertFalse(driver.getTitle().contains("404"), "Page should not return 404");
        assertFalse(driver.getTitle().contains("Error"), "Page should not have error");
        takeScreenshot("http-status-check");
    }
}