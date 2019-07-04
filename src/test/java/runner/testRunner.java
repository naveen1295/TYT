package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
	
	@CucumberOptions(features = "src/test/resources/features",
	        glue = { "stepDefinitions" },
	        tags = {"" },
	        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
					"html:target/cucumber-reports" },
	        monochrome = false,
	        dryRun = false,
	        strict = false)
	public class testRunner extends AbstractTestNGCucumberTests {
		 @AfterSuite
		    public static void writeCucumberHtmlReport() {
		        File reportOutputDirectory = new File("target");
		        List<String> jsonFiles = new ArrayList<>();
		        jsonFiles.add("./target/cucumber-reports/Cucumber.json");


		        String buildNumber = "1";
		        String projectName = "iScrum Website Test Scenarios";
		        boolean runWithJenkins = false;
//		    	boolean parallelTesting = false;

		        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		        // optional configuration - check javadoc
		        configuration.setRunWithJenkins(runWithJenkins);
		        configuration.setBuildNumber(buildNumber);
		        // Additional metadata presented on main page
		        configuration.addClassifications("Platform", "Windows");
		    	configuration.addClassifications("Browser", "Chrome");

		        // optionally add metadata presented on main page via properties file
//		    	List<String> classificationFiles = new ArrayList<>();
//		    	classificationFiles.add("properties-1.properties");
//		    	classificationFiles.add("properties-2.properties");
//		    	configuration.addClassificationFiles(classificationFiles);

		        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		        @SuppressWarnings("unused")
		        Reportable result = reportBuilder.generateReports();
		        // and here validate 'result' to decide what to do
		        // if report has failed features, undefined steps etc
		    }
}
	

