package euroStar.MasterFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import euroStar.Utilities.GenericHelper;

public class Base {

	Logger logger;
	public static WebDriver driver = null;

	@BeforeSuite
	public void initialize() throws Exception {

		logger = Logger.getLogger("EuroStarTest1");
		PropertyConfigurator.configure("log4j.properties");

		String browser = ConfigFileReader.getValueForTheKeywordFromConfigFile("browser");

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
		}

		// Maximize the window
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String applicationUrl = ConfigFileReader.getValueForTheKeywordFromConfigFile("url");

		// To open linkedIn
		driver.get(applicationUrl);

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		String screenShot = GenericHelper.captureScreen(driver, GenericHelper.generateFileName(result));
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("Error screshot location: " + screenShot + "");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Result Pass!!");
		} else {
			logger.info("Test Case SKIPPED");
		}
	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		Base.driver.quit();
	}
}