package euroStar.Reports.ReportNGReport;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import euroStar.MasterFile.Base;
import euroStar.pageobject.EuroStarLoginPage;

public class EuroStarTest3_ReportNG extends Base {

	EuroStarLoginPage euroLoginPage;
	Logger logger;

	@BeforeTest
	public void M1() {

		Reporter.log("EuroStarTest1");
		logger = Logger.getLogger("EuroStarTest1");
		PropertyConfigurator.configure("log4j.properties");

		euroLoginPage = PageFactory.initElements(driver, EuroStarLoginPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void verifyWebTitle() throws Exception {

		try {
			euroLoginPage.loginToEuroStarAccount();
			logger.info("Launched Euro Star Application!!");
		}

		catch (Exception e) {
			e.getMessage();
			logger.error(e);
			Reporter.log(e.getMessage());
		}
		String expectedTitle = "EuroSTAR Huddle - Online Software Testing Community!!";
		logger.info("Expected Title: " + expectedTitle);
		Reporter.log("Expected Title: " + expectedTitle);

		String actualtitle = driver.getTitle();
		logger.info("Actual Title: " + actualtitle);
		Reporter.log("Actual Title: " + actualtitle);
		
		Assert.assertEquals(actualtitle, expectedTitle, "Title mismatched");
		logger.info("Expected matched with Actual so test is passed!!");
		Reporter.log("Expected matched with Actual so test is passed!!");
	}
	
	@Test
	public void verifyUrl() throws Exception {

		try {
			euroLoginPage.loginToEuroStarAccount();
			logger.info("Launched Euro Star Application!!");
			Reporter.log("Launched Euro Star Application!!");
		}

		catch (Exception e) {
			e.getMessage();
			logger.error(e);
		}
		String currentUrl = driver.getCurrentUrl();
		logger.info("Current URL: " + currentUrl);
		Reporter.log("Current URL: " + currentUrl);
		

		String expectedUrl = "https://huddle.eurostarsoftwaretesting.com/";
		logger.info("Expected URL: " + expectedUrl);
		Reporter.log("Expected URL: " + expectedUrl);

		Assert.assertEquals(currentUrl, expectedUrl, "URL mismatched");
		logger.info("Expected matched with Actual so test is passed!!");
		Reporter.log("Expected matched with Actual so test is passed!!");
	}

	@Test(dependsOnMethods = {"verifyWebTitle"})
	public void verifyWebTitleToSkip() throws Exception {

		try {
			euroLoginPage.loginToEuroStarAccount();
			logger.info("Launched Euro Star Application!!");
		}

		catch (Exception e) {
			e.getMessage();
			logger.error(e);
			Reporter.log(e.getMessage());
		}
		String expectedTitle = "EuroSTAR Huddle - Online Software Testing Community!!";
		logger.info("Expected Title: " + expectedTitle);
		Reporter.log("Expected Title: " + expectedTitle);

		String actualtitle = driver.getTitle();
		logger.info("Actual Title: " + actualtitle);
		Reporter.log("Actual Title: " + actualtitle);
		
		Assert.assertEquals(actualtitle, expectedTitle, "Title mismatched");
		logger.info("Expected matched with Actual so test is passed!!");
		Reporter.log("Expected matched with Actual so test is passed!!");
	}
	
	
	@AfterTest
	public void afterTest() {

		driver.close();
		logger.info("Close the browser!!");

	}
}
