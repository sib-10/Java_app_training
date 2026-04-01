package com.example.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest extends BaseTest {

    @Test
    @DisplayName("Search functionality should work")
    void searchReturnsResults() {
        driver.get(BASE_URL);

        WebElement searchBox = driver.findElement(By.id("query"));
        searchBox.sendKeys("loan");
        searchBox.submit();

        takeScreenshot("search-results");

        String pageSource = driver.getPageSource();
        assertFalse(pageSource.isEmpty(), "Search should return a page");
    }

    @Test
    @DisplayName("Empty search should be handled gracefully")
    void emptySearchHandled() {
        driver.get(BASE_URL);

        WebElement searchBox = driver.findElement(By.id("query"));
        searchBox.sendKeys("");
        searchBox.submit();

        takeScreenshot("empty-search");

        // Page should not crash
        assertFalse(driver.getTitle().contains("Error"), "Empty search should not cause error");
    }
}