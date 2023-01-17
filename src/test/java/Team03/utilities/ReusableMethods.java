package Team03.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {

    static Actions actions=new Actions(Driver.getDriver());

    public static void checkPage(String expected){
        Assert.assertEquals(expected,Driver.getDriver().getCurrentUrl());
    }

    public static void moveTo(WebElement beklenenEleman){
        actions.moveToElement(beklenenEleman).perform();
    }

    public static void dataSend(WebElement element,String yazılacakKeys){
        element.sendKeys(yazılacakKeys+ Keys.ENTER);
    }

    public static void includeText(WebElement iceriyorMu,String aranan){
        Assert.assertTrue(iceriyorMu.getText().contains(aranan));
    }

    public static void hamburger(WebElement sec ,String text){
        sec.click();
        Select select=new Select(sec);
        select.selectByVisibleText(text);
    }

    public static void secimKontrol(WebElement secilen,String secim){
        Assert.assertTrue(secilen.getText().contains(secim));
    }

    public static void linkKontrol(String ara){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(ara));
    }

    public static void scrollDown(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();//bulana kadar asagı iner
        jse.executeScript("arguments[0].scrollIntoView();" ,element);
    }

    public static void gorunuyorMU(WebElement element){
        Assert.assertTrue(element.isDisplayed());
    }

    public static String getScreenshot(WebDriver driver, String name) throws IOException {
        // Screenshot dosya ismi icin suanki tarihi String olarak aliyoruz.
        String date = formatCurrentDate(" yyyy.MM.dd_HH.mm.ss"); // asagida olusturdugumuz methodu kullandik.
        // Screenshot alip file objesine atiyoruz.
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Kaydedilecek dosyanin yolunu belirtiyoruz.
        String target = System.getProperty("user.dir")+ "\\test-output\\screenshot\\"+name+date+".png";
        File targetFile = new File(target);
        FileUtils.copyFile(source,targetFile);
        return target;
    }
    public static String formatCurrentDate(String pattern){
        return new SimpleDateFormat(pattern).format(new Date());
    }
}
