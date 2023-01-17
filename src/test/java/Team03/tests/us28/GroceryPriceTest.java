package Team03.tests.us28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroceryPriceTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up webdriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testOriginalPriceDisplayed() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-button")).click();
        // Select a product
        driver.findElement(By.className("product")).click();
        // Get the original price of the product
        WebElement originalPriceElement = driver.findElement(By.className("original-price"));
        String originalPrice = originalPriceElement.getText();
        // Assert that the original price is displayed
        Assert.assertTrue(originalPrice.length() > 0);
    }

    @Test
    public void testDiscountedPriceDisplayed() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-button")).click();
        // Select a product
        driver.findElement(By.className("product")).click();
        // Get the discounted price of the product
        WebElement discountedPriceElement = driver.findElement(By.className("discounted-price"));
        String discountedPrice = discountedPriceElement.getText();
        // Assert that the discounted price is displayed
        Assert.assertTrue(discountedPrice.length() > 0);
    }

    @Test
    public void testDiscountPercentageDisplayed() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-button")).click();
        // Select a product
        driver.findElement(By.className("product")).click();
        // Get the discount percentage of the product
        WebElement discountPercentageElement = driver.findElement(By.className("discount-percentage"));
        String discountPercentage = discountPercentageElement.getText();
        // Assert that the discount percentage is displayed
        Assert.assertTrue(discountPercentage.length() > 0);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
