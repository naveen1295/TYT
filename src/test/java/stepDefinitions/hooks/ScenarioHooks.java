package stepDefinitions.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import pages.Dashboard;
import pages.HomePage;
import stepDefinitions.World;

public class ScenarioHooks {
    private World world;
    private WebDriver driver;

   public ScenarioHooks(World world) {
       driver = (WebDriver) world.context.get("driver");
       System.out.println(driver);
    }

   @Before("@adminUserLoggedIn")
   public void login(){
       HomePage homePage = new HomePage(driver);
       homePage.loginWithDefaultCredentials();
       Dashboard dashboardPage= new Dashboard(driver);
      dashboardPage.verifyTitle();

}
   
   @After("@adminUserLoggedIn and @inProgress")
   public void deleteStory() {
	   
	   Dashboard dashboardPage= new Dashboard(driver); 
	   dashboardPage.deleteStory();
	   
	   
   }
}