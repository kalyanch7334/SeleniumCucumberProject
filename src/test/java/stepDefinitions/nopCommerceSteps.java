package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;



public class nopCommerceSteps {

    WebDriver driver;
    LoginPage lpage;



    @Given("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser() {

        System.setProperty("webdriver.chromedriver","C:\\Users\\srika\\Downloads\\chromedriver_win32/chromedriver.exe");
        driver=new ChromeDriver();

        lpage=new LoginPage(driver);

    }

    @When("User Opens URL {string}")
    public void user_Opens_URL(String url) {

        driver.get(url);


    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {

        //lpage=new LoginPage(driver);
        lpage.setUserName(email);
        lpage.setpassWord(password);



    }

    @When("Click on Login")
    public void click_on_Login() {

    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String string) {

    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() {

    }




}
