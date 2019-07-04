package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewStory {	
	
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement txtName;
	
	@FindBy(xpath="//span[text()='No associated feature']")
	private WebElement ddFeature;
	
	
	@FindBy(xpath="//span[text()='Web Automation']")
	private WebElement ddSelectFeature;
	
	
	@FindBy(xpath="//label[@for='feature']")
	private WebElement labelFeature;
	
	@FindBy(xpath="//button[@hotkey-description=\"Create and continue\"]")
	private WebElement btnCreateAndContinue;
	
	public WebDriver driver;
	
	public NewStory(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public NewStory enterStoryName(String storyName) {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(txtName));
		txtName.sendKeys(storyName);
		return this;
		
	}
	
	public NewStory selectFeature() {
		
		ddFeature.click();
		ddSelectFeature.click();
		return this;
	}
	
	public NewStory clickCreateAndContinue() {
		
		btnCreateAndContinue.click();
		return this;	
	
}
}
