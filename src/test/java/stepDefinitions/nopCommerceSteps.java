package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.customerPage;


public class nopCommerceSteps {

    WebDriver driver;
    LoginPage lpage;
    customerPage custPage;



    @Given("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\srika\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();

        lpage=new LoginPage(driver);
    }

    @When("User Opens URL {string}")
    public void user_Opens_URL(String url) {

        driver.get(url);


    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password)throws  InterruptedException
    {

        //lpage=new LoginPage(driver);
        lpage.setUserName(email);
        lpage.setpassWord(password);
        Thread.sleep(5000);
    }

    @When("Click on Login")
    public void click_on_Login() throws  InterruptedException
    {

        lpage.setLogIn();
        Thread.sleep(2000);

    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {

        if(driver.getPageSource().contains("Login was unsuccessful"))
        {
            driver.close();
            Assert.assertTrue("Please login with valid email",false);

        }
        else
        {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException
    {

        lpage.setLogOut();
        Thread.sleep(5000);

    }

    @Then("close browser")
    public void close_browser() {

        driver.close();
    }


    //ADD CUSTOMER
    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() throws InterruptedException
    {

     custPage=new customerPage(driver);

     Assert.assertEquals("Dashboard / nopCommerce administration",custPage.setDashBoardTitle());
      Thread.sleep(2000);
    }

    @When("User click on customers menu")
    public void user_click_on_customers_menu() throws InterruptedException
    {
        custPage.setLinkCustomers();
        Thread.sleep(1000);
    }

    @When("click on customers menu Item")
    public void click_on_customers_menu_Item() {
      custPage.setUnderLinkCustomers();
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException
    {
        Thread.sleep(1000);
        custPage.setAddNew();
    }

    @Then("user can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {

        Assert.assertEquals("Add a new customer / nopCommerce administration",custPage.setDashBoardTitle());

    }

    @When("user enter customer info")
    public void user_enter_customer_info() throws InterruptedException
    {
        custPage.setEmail("king232@gmail.com");
        custPage.setPassword("king524");
        custPage.setfirstName("kalyan1");
        custPage.setCompanyName("kalyan1chit.com");
        custPage.setLastName("ch");
        custPage.setGender("Male");
        custPage.setcustomer_roles("Vendors");
       //Thread.sleep(1000);
        custPage.setVendors("Vendor 1");
    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException
    {

        custPage.setSave();
        Thread.sleep(2000);

    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String title) {

        Assert.assertEquals(title,"The new customer has been added successfully.");

    }








}
