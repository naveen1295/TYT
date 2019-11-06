package stepDefinitions.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import stepDefinitions.World;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

	private World world;
	private String testEnv = "dev";
	private WebDriver driver;

	public Hooks(World world) {
		this.world = world;
		System.out.println("Value of TEST_ENV is " + System.getenv("TEST_ENV"));
		testEnv = (System.getenv("TEST_ENV") == null) ? testEnv : System.getenv("TEST_ENV");
	}

	@Before(order=0)
	public void doSetupBeforeExecution() {
		Properties properties;
		String browser;
		String url;
		String projectPath = System.getProperty("user.dir");
		properties = new Properties();

		try {
			properties.load(new FileInputStream(new File("./src/test/resources/config/stg1.properties")));
		} 	catch (IOException e) {
			e.printStackTrace();
		}

		browser = properties.getProperty("Browser");
		url = properties.getProperty("URL");

		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();

		HashMap<String, String> map= new HashMap<String, String>();
		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		this.world.context.put("config", map);
		this.world.context.put("testEnv", testEnv.toLowerCase());
		world.context.put("driver", driver);
	}

	@After(order=0)
	public void doCleanupAfterExecution(Scenario scenario){
		if (scenario.isFailed()) {
			TakesScreenshot browser = (TakesScreenshot) new Augmenter().augment(driver);
			final byte[] screenshot = browser.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			scenario.write("URL: " + driver.getCurrentUrl());
		}
		driver.close();
	}
}
