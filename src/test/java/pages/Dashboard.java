package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Dashboard {
	
	@FindBy(xpath = "//title[contains(text(),'iceScrum - WebAutomation')]")
	private WebElement txtPageTitle;
	
	@FindBy(xpath="//a[@class='btn btn-default'][text()='New story']")
	private WebElement btnNewStory;		
	
	@FindBy(xpath="//a[@class='btn btn-default ng-scope']")
	private WebElement btnNewTask;
	
	@FindBy(xpath="//*[text()='Test']")
	private WebElement checkStory;
	
	@FindBy(xpath="(//i[@class=\"fa fa-ellipsis-h\"])[3]")
	private WebElement ellipsisDelete;
	
	@FindBy(xpath="//div[@class=\"panel-body\"]")
	private WebElement panelBody;
	
	@FindBy(xpath="(//div[@class=\"content without-description\"])[3]")
	private WebElement selectStory;
	
	@FindBy(xpath="(//i[@class='fa fa-caret-down'])[6]")
	private WebElement ddDelete;
	
	@FindBy(xpath="//a[@class=\"ng-binding\"][contains(text(),\"Delete\")]")
	private WebElement selDelete;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement btnDelete;		
	
	@FindBy(xpath="//i[@class=\"fa fa-upload\"]")
	private WebElement btnUpload;
		
	@FindBy(xpath="//button/input[@type=\"file\"]")
	private WebElement fileUpload;	
	
	@FindBy(xpath="//a[@class=\"ng-binding\"][text()=\"ab.xlsx\"]")
	private WebElement txtVerifyUpload;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement btnSave;
	
	private WebDriver driver;	

	public Dashboard(WebDriver driver) {
		
		 this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public Dashboard verifyTitle() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	
		if(driver.getTitle().equals("iceScrum - WebAutomation"))			
			System.out.println("Logged in Successfully");

		else			
			System.out.println("Login Unsuccessful");		
		return this;
		
	}
	
	public Dashboard clickCreateTask() {	
		
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(btnNewTask));
		btnNewTask.click();	
		return this;
	}	
	
	public Dashboard clickNewStory() {		
		
		if(btnNewStory.isEnabled())
			btnNewStory.click();
		else
			System.out.println("Button New story not found");		
		return this;
	}
	
	public Dashboard checkCreatedStory(String storyName) {
		
		if(checkStory.getText().contains(storyName))
			System.out.println("The story "+storyName+" has been created in Dashboard");
		else	
			System.out.println("The story has not been created in Dashboard");
		return this;

}
	
public Dashboard deleteStory() {   	   

	panelBody.click();	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(selectStory));
	selectStory.click();       
	ddDelete.click();
	selDelete.click();
	btnDelete.click();
	return this;

	}

public Dashboard uploadFileStory() throws IOException {	
	
	panelBody.click();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(selectStory));
	selectStory.click();	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	String path=System.getProperty("user.dir");	
	fileUpload.sendKeys(path+"\\src\\test\\resources\\dataFiles\\ab.xlsx");	
	return this;
}

public Dashboard verifyUpload() {		
	panelBody.click();
	btnSave.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}	
	selectStory.click();	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(txtVerifyUpload.isDisplayed())
		System.out.println("File Uploaded");
	else
		System.out.println("File  Not Uploaded");
	return this;
	
}
	
}

