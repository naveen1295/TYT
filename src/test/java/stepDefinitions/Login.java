package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import stepDefinitions.World;
import pages.Dashboard;

public class Login {
	
	private World world;
	public static WebDriver driver;	
	public HomePage homePage;
	public Dashboard dashboardPage;	
	

	public Login(World world) {
		this.world = world;
		driver = (WebDriver) this.world.context.get("driver");
		homePage = new HomePage(driver);
		dashboardPage = new Dashboard(driver);
		
	}


	@Given("I as a admin user navigate to {string} Home page")
	public void iAsAAdminUserNavigateToHomePage(String arg0) {

	}

	@When("I try to login with username {string} and password {string}")
	public void i_try_to_login_with_username_and_password(String username, String password) {
		homePage.enterUsername(username);
		homePage.enterPassword(password);
		homePage.clickLogin();
		
	
	}
	
	@Then("I am logged in successfully")
	public void i_am_logged_in_successfully() {	
	  	
	 
		dashboardPage.verifyTitle();

	}	
	
	
	@Then("I am given an error message")
	public void i_am_given_an_error_message() { 		  	
	 
	    homePage.checkError();
		dashboardPage.verifyTitle();
	
	}


}
