package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Dashboard;
import pages.HomePage;
import pages.NewStory;
import stepDefinitions.World;

public class CreateStory {	
	
	private World world;
	public WebDriver driver;	
	public HomePage homePage;
	public Dashboard dashboardPage;	
	public NewStory newStory;
	

	public CreateStory(World world) {
		
		this.world = world;
		driver = (WebDriver) this.world.context.get("driver");
		homePage = new HomePage(driver);
		dashboardPage = new Dashboard(driver);
		newStory=new NewStory(driver);
		
	}	
	
	@Given("I am in the dashboard page")
	public void i_am_in_the_dashboard_page() {
		
	//	homePage.loginWithDefaultCredentials();		
			dashboardPage.verifyTitle();
		
	}
	
	@When("I try to create a new story {string}")
	public void i_try_to_create_a_new_story(String storyName) {		
		
		dashboardPage.clickNewStory();
		newStory.enterStoryName(storyName);
		newStory.selectFeature();
		newStory.clickCreateAndContinue();
		
	}
	
	@Then("the story {string} should be displayed in the dashboard")
	public void the_story_should_be_displayed_in_the_dashboard(String storyName) {
	
		dashboardPage.checkCreatedStory(storyName);
	//	dashboardPage.deleteStory();
		
}
	
}