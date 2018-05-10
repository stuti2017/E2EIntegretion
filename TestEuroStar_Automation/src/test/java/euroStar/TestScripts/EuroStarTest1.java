package euroStar.TestScripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import euroStar.MasterFile.Base;
import euroStar.pageobject.EuroStarLoginPage;

public class EuroStarTest1 extends Base {

	EuroStarLoginPage euroLoginPage;
	Logger logger;

	@BeforeTest
	public void M1() {

		logger = Logger.getLogger("EuroStarTest1");
		PropertyConfigurator.configure("log4j.properties");

		euroLoginPage = PageFactory.initElements(driver, EuroStarLoginPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void webTitle() throws Exception {

		try {
			euroLoginPage.loginToEuroStarAccount();
			logger.info("Launched Euro Star Application!!");
		}

		catch (Exception e) {
			e.getMessage();
			logger.error(e);
		}
		String expectedTitle = "EuroSTAR Huddle - Online Software Testing Community!!";
		logger.info("Expected Title: " + expectedTitle);

		String actualtitle = driver.getTitle();
		logger.info("Actual Title: " + actualtitle);

		Assert.assertEquals(actualtitle, expectedTitle, "Title mismatched");
		logger.info("Expected matched with Actual so test is passed!!");
	}

	@AfterTest
	public void afterTest() {

		driver.close();
		logger.info("Close the browser!!");

	}
}
