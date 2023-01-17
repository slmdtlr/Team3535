package Team03.pages;

import Team03.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickBazarHomePage {

    public PickBazarHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Join']")
    public WebElement join;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement profileImg;

    @FindBy(xpath = "//ul[@id='headlessui-menu-items-13']")
    public WebElement userManual;

    @FindBy(id = "headlessui-menu-item-14")
    public WebElement points;

    @FindBy(xpath = "//button[.='Profile']")
    public WebElement profile;

    @FindBy(xpath = "//button[.='My Orders']")
    public WebElement myOrders;

    @FindBy(xpath = "//button[.='My Wishlists']")
    public WebElement myWishlist;

    @FindBy(xpath = "//button[.='Checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//button[.='Logout']")
    public WebElement logout;
}
