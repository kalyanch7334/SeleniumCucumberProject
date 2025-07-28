package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class customerPage {

    WebDriver cdriver;
    public customerPage(WebDriver cdriver) {
        this.cdriver = cdriver;
        PageFactory.initElements(cdriver, this);
    }

    //locators
    @FindBy(xpath=("//a[@href='#']//p[contains(text(),'Customers')]"))
    @CacheLookup
    WebElement tx_linkCustomers;

    @FindBy(xpath=("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]"))
    @CacheLookup
    WebElement txt_underlinkCustomers;

    @FindBy(xpath=("//a[normalize-space()='Add new']"))
    @CacheLookup
    WebElement txt_addNew;

    @FindBy(xpath=("//input[@id='Email']"))
    @CacheLookup
    WebElement txt_email;

    @FindBy(xpath=("//input[@id='Password']"))
    @CacheLookup
    WebElement txt_password;

    @FindBy(xpath=("//input[@id='FirstName']"))
    @CacheLookup
    WebElement txt_firstName;

    @FindBy(xpath=("//input[@id='LastName']"))
    @CacheLookup
    WebElement txt_lastName;

    @FindBy(xpath=("//input[@name='Gender']"))
    @CacheLookup
    WebElement txt_gender;

    @FindBy(xpath=("//input[@id='Company']"))
    @CacheLookup
    WebElement txt_companyName;


    @FindBy(xpath=("//li[@title='nopCommerce admin demo store']"))
    @CacheLookup
    WebElement txt_NewsLetter;

  /*  @FindBy(xpath=("//select[@id='SelectedCustomerRoleIds']//option"))
    @CacheLookup
    WebElement txt_customer_roles;
*/
   By txt_custroles= By.xpath("//select[@id='SelectedCustomerRoleIds']");

   /* @FindBy(xpath=("//select[@id='VendorId']"))
    @CacheLookup
    WebElement txt_vendors;
*/
   By txt_vendors=By.xpath("//select[@id='VendorId']");

    @FindBy(xpath=("//button[@name='save']"))
    @CacheLookup
    WebElement txt_save;





    //perform Action methods
    public String setDashBoardTitle()
    {
        return cdriver.getTitle();

    }
    public void setLinkCustomers()
    {
        tx_linkCustomers.click();
    }
    public void setUnderLinkCustomers()
    {

        txt_underlinkCustomers.click();
    }
    public void setAddNew()
    {
        txt_addNew.click();
    }
    public void setEmail(String email)
    {
        txt_email.sendKeys(email);
    }
    public void setPassword(String password)
    {
        txt_password.sendKeys(password);
    }
    public void setfirstName(String firstName)
    {
        txt_firstName.sendKeys(firstName);
    }
    public void setLastName(String lastName)
    {
        txt_lastName.sendKeys(lastName);
    }
    public void setCompanyName(String company)
    {
        txt_companyName.sendKeys(company);
    }
    public void setGender(String str)
    {
        if(str.equals("Male"))
        {
            txt_gender.click();
        }
        else if (str.equals("Female"))
        {
            txt_gender.click();

        }
    }
    public void setcustomer_roles(String role)
    {

      WebElement custroles= cdriver.findElement(txt_custroles);
        Select select = new Select(custroles);
        select.selectByVisibleText(role);
       /* if(str.equals("Administrators"))
        {
            txt_customer_roles.clear();
        }
        else if(str.equals("Forum Moderators"))
        {
            txt_customer_roles.click();
        }
        else if(str.equals("Registered"))
        {
            txt_customer_roles.click();
        }
        else if(str.equals("Guests"))
        {
            txt_customer_roles.click();
        }*/

    }
    public void setVendors(String vendor)
    {
        WebElement custvendor=cdriver.findElement(txt_vendors);
        Select selectvendor=new Select(custvendor);
        selectvendor.selectByVisibleText(vendor);

    }
    public void setSave()
    {
        txt_save.click();
    }
}
