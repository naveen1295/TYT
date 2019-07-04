package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Dashboard;
import pages.HomePage;
import pages.NewStory;

public class AttachFileStory {
	
	
	private World world;
	public WebDriver driver;	
	public HomePage homePage;
	public Dashboard dashboardPage;	
	public NewStory newStory;
	

	public AttachFileStory(World world) {
		
		this.world = world;
		driver = (WebDriver) this.world.context.get("driver");
		homePage = new HomePage(driver);
		dashboardPage = new Dashboard(driver);
		newStory=new NewStory(driver);
		
	}	

	@When("I try to attach a file to a story {string}")
	public void i_try_to_attach_a_file_to_a_story(String storyName) throws IOException {
		
		dashboardPage.clickNewStory();
		newStory.enterStoryName(storyName);
		newStory.selectFeature();
		newStory.clickCreateAndContinue();
		dashboardPage.uploadFileStory();
		
	}

	@Then("the story should be updated with the attachment")
	public void the_story_should_be_updated_with_the_attachment() {
	    dashboardPage.verifyUpload();
		
	}

	
	

}
