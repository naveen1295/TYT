package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	private WebDriver driver;
	
	
	@FindBy(id="txtUserID")
	private WebElement txtUsername;
	
	@FindBy(id="txtPassword")
	private WebElement txtPassword;
	
	@FindBy(id="sub")
	private WebElement btnLogin;	
	
	@FindBy(xpath="//div[@class='ng-binding notification-error'][contains(text(),'Login error, please check your username and your password')]")
	private WebElement checkError;
	

	
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	
	public HomePage verifyTitle() {
		
		if(driver.getTitle().equals("iceScrum -"))
			System.out.println("HomePage launched successfully");
		else
			System.out.println("HomePage not launched");
		
		return this;
	}
	 
	public HomePage enterUsername(String username) {
		
		txtUsername.clear();
		txtUsername.sendKeys(username);		
		return this;
	}

	public HomePage enterPassword(String password) {

		txtPassword.clear();
		txtPassword.sendKeys(password);
		return this;
	}

	public HomePage clickLogin() {

		btnLogin.click();
		
		return this;

	 
 }
 
 public void checkError() {
 
	 try {
		 Thread.sleep(3000);
	 } catch (InterruptedException e) {
		 e.printStackTrace();
	 }

	 if(checkError.isDisplayed())
		 System.out.println("Error message is displayed for invalid credentials");
	 else
		 System.out.println("No error message is displayed for invalid credentials");

	 
 } 
	
	 public HomePage loginWithDefaultCredentials() {
		verifyTitle()
		.enterUsername("Admin")
		.enterPassword("Admin123")
		.clickLogin();
		
		return this;
		 
	 }
	 
	
}
 
