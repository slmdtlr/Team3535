package Team03.tests.us29;

import Team03.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCartTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testAddRemoveProduct() {
        // Navigate to the Grocery page
        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");
        driver.findElement(By.className("grocery-button")).click();

        // Select a product and click on "Add to Shopping Cart" button
        driver.findElement(By.id("product-1")).click();
        driver.findElement(By.id("add-to-cart-button")).click();

        // Verify that the product is added to the cart
        String cartText = driver.findElement(By.id("cart-text")).getText();
        Assert.assertTrue(cartText.contains("1 product(s)"));

        // Increase the product quantity by clicking on "+" button
        driver.findElement(By.id("increase-quantity-button")).click();

        // Verify that the product quantity has increased
        String quantity = driver.findElement(By.id("quantity-display")).getText();
        Assert.assertEquals(quantity, "2");

        // Decrease the product quantity by clicking on "-" button
        driver.findElement(By.id("decrease-quantity-button")).click();

        // Verify that the product quantity has decreased
        quantity = driver.findElement(By.id("quantity-display")).getText();
        Assert.assertEquals(quantity, "1");
    }
}

