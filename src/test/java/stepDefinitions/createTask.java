package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Dashboard;
import pages.NewTask;
import stepDefinitions.World;

public class createTask {
	private World world;
	private WebDriver driver;
	private Dashboard DashboardPage;
	private NewTask NewTaskPage;

	public createTask(World world) {
		this.world = world;
		driver = (WebDriver) this.world.context.get("driver");
		DashboardPage = new Dashboard(driver);
		NewTaskPage = new NewTask(driver);

	}

	@Given("user clicks on new task button on Dashboard Page")
	public void user_clicks_on_new_task_button_on_Dashboard_Page() {
		// Write code here that turns the phrase above into concrete actions
		// homePage.loginWithDefaultCredentials();
		// DashboardPage.verifyTitle();
		DashboardPage.clickCreateTask();

	}

	@When("user enters new task name {string}")
	public void user_enters_new_task_name(String taskName) {
		// Write code here that turns the phrase above into concrete actions
		NewTaskPage.enterTaskName(taskName);

	}

	@When("user selects new task type{string}")
	public void user_selects_new_task_type(String taskType) {
		// Write code here that turns the phrase above into concrete actions
		NewTaskPage.selectTaskType(taskType);

	}

	@When("user clicks on button Create and continue")
	public void user_clicks_on_button_Create_and_continue() {
		// Write code here that turns the phrase above into concrete actions
		NewTaskPage.clickCreateAndContinue();

	}

	@Then("verify that a card with new task {string} is visible")
	public void verify_that_a_card_with_new_task_is_visible(String taskName) {
		// Write code here that turns the phrase above into concrete actions
		NewTaskPage.VerifyTask(taskName);

	}

	@Then("delete the new task {string}")
	public void delete_the_new_task(String taskName) {
		// Write code here that turns the phrase above into concrete actions
		NewTaskPage.deleteTask(taskName);
	}

}
