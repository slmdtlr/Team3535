package Team03.tests.us27;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroceryTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up webdriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGroceryPageLoadsWith30Products() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-testGroceryPageLoadsWith30Products")).click();
        // Get the number of products displayed on the page
        int numProducts = driver.findElements(By.className("product")).size();
        // Assert that the number of products is 30
        Assert.assertEquals(numProducts, 30);
    }

    @Test
    public void testLoadMoreButton() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-button")).click();
        // Get the number of products displayed on the page before clicking "Load More" button
        int numProductsBefore = driver.findElements(By.className("product")).size();
        // Click on "Load More" button
        driver.findElement(By.id("load-more-button")).click();
        // Get the number of products displayed on the page after clicking "Load More" button
        int numProductsAfter = driver.findElements(By.className("product")).size();
        // Assert that the number of products increased after clicking "Load More" button
        Assert.assertTrue(numProductsAfter > numProductsBefore);
    }

    @Test
    public void testProductCategories() {
        // Navigate to web page
        driver.get("https://shop-pickbazar-rest.vercel.app/");
        // Click on "Grocery" button
        driver.findElement(By.id("grocery-button")).click();
        // Get the list of product categories
        WebElement productCategoriesElement = driver.findElement(By.id("product-categories"));
        String productCategoriesText = productCategoriesElement.getText();
        // Assert that the product categories are as expected
        String expectedProductCategories = "Fruits & Vegetables,Meat & Fish,Snacks,Pet Care,Home & Cleaning,Dairy,Cooking,Breakfast,Beverage,Health & Beauty";
        Assert.assertEquals(productCategoriesText, expectedProductCategories);
    }
   /* @Test
    public void childrencategories(){
        List<WebElement> mainCategories = driver.findElements(By.cssSelector(".main-category"));
        for (WebElement mainCategory : mainCategories) {
            List<WebElement> childrenCategories = mainCategory.findElements(By.cssSelector(".children-category"));
            if (childrenCategories.size() == 0) {
                System.out.println(mainCategory.getText() + " does not have any children categories.");
                }

    */


    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}



