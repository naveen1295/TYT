package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTask {

	public WebDriver driver;
	public String taskNameValue;
	List<String> TaskList = new ArrayList<String>();
	@FindBy(xpath = "//input[@placeholder='Enter the name of a new task']")
	private WebElement txtNewTaskName;

	@FindBy(xpath = "//a[@placeholder='Choose a type or a parent story']")
	private WebElement ddNewTaskType;

	@FindBy(xpath = "//div[@class='select2-result-label ui-select-choices-row-inner']//span[@class='ng-binding ng-scope'][contains(text(),'Urgent task')]")
	private WebElement ddNewTaskTypeUrgenttaskOption;

	@FindBy(xpath = "//div[@class='select2-result-label ui-select-choices-row-inner']//span[@class='ng-binding ng-scope'][contains(text(),'Recurrent task')]")
	private WebElement ddNewTaskTypeRecurrenttaskOption;

	@FindBy(xpath = "//button[contains(text(),'Create and continue')]")
	private WebElement btnClickAndContinue;

	@FindBy(xpath = "//div[@class='dropdown btn-group']//button[@type='button']")
	private WebElement btnDeleteTaskMenu;

	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	private WebElement btnDeleteTask;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnConfirmDeleteTask;
	
	private List<WebElement> txtTaskName;

	public List<WebElement> getTasks() {
		txtTaskName = driver.findElements(By.xpath("//h3[@class='title title-sm ng-binding']"));
		return txtTaskName;
	}

	public NewTask(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public NewTask enterTaskName(String taskName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		txtNewTaskName.sendKeys(taskName);
		taskNameValue = taskName;
		return this;
	}

	public NewTask selectTaskType(String taskType) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (taskType.equals("Urgent task")) {
			ddNewTaskType.click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ddNewTaskTypeUrgenttaskOption));
			ddNewTaskTypeUrgenttaskOption.click();

		} else if (taskType.equals("Recurrent task")) {
			ddNewTaskType.click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(ddNewTaskTypeRecurrenttaskOption));
			ddNewTaskTypeRecurrenttaskOption.click();
		} else {
			System.out.println("Error in Task Type");
		}
		return this;
	}

	public NewTask clickCreateAndContinue() {
		btnClickAndContinue.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public NewTask VerifyTask(String taskName) {
		getTasks();


		for (WebElement element : txtTaskName) {
			TaskList.add(element.getText());
			System.out.println(element.getText());
		}

		if (TaskList.contains(taskName)) {
			System.out.println("Task has been created successfully");
		} else {
			System.out.println("Task has not been created successfully");
		}
		// txtTaskName.getText().equals(taskNameValue);
		return this;
	}
	public NewTask deleteTask(String taskName) {
		getTasks();
		List<String> TaskList = new ArrayList<>();

		for (WebElement element : txtTaskName) {
			TaskList.add(element.getText());
			//System.out.println(element.getText());
		
			if (element.getText().equals(taskName)) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Got the Task");				
				element.click();
				btnDeleteTaskMenu.click();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOf(btnDeleteTask));
				btnDeleteTask.click();
				wait.until(ExpectedConditions.visibilityOf(btnConfirmDeleteTask));
				btnConfirmDeleteTask.click();
				break;
			}
			else
			{
				System.out.println("Task not found");
				
			}
		}
		
		// txtTaskName.getText().equals(taskNameValue);
		return this;
	}


}
