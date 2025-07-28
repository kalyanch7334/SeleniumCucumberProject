package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver ldriver;

	/*public LoginPage (WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(ldriver, this);

	}*/


    //locate the web elements

    public LoginPage(WebDriver ldriver) {

        this.ldriver = ldriver;
        PageFactory.initElements(ldriver, this);
    }
    @FindBy(xpath=("//input[@id='Email']"))
    @CacheLookup
    WebElement txt_email;

    @FindBy (xpath=("//input[@id='Password']"))
    @CacheLookup
    WebElement txt_password;

    @FindBy (xpath=("//button[normalize-space()='Log in']"))
    @CacheLookup
    WebElement txt_login;

    @FindBy (xpath=("//a[normalize-space()='Logout']"))
    @CacheLookup
    WebElement txt_logout;

    //Action methos

    public void setUserName(String uname)
    {
        txt_email.clear();
        txt_email.sendKeys(uname);


    }

    public void setpassWord(String pwd)
    {
        txt_password.clear();
        txt_password.sendKeys(pwd);
    }

    public void setLogIn()
    {
        txt_login.click();
    }
    public void setLogOut()
    {
        txt_logout.click();
    }


}
