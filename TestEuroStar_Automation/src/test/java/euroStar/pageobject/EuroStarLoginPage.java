package euroStar.pageobject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import euroStar.locators.EuroStarLoginLocators;

public class EuroStarLoginPage {
	Logger logger;
	WebDriver webDriver;

	public EuroStarLoginPage(WebDriver driver) {
		this.webDriver = driver;

		logger = Logger.getLogger("LinkedinTest1");
		PropertyConfigurator.configure("log4j.properties");
	}

	@FindBy(xpath = EuroStarLoginLocators.LOGIN_LINK)
	private WebElement loginLink;

	@FindBy(id = EuroStarLoginLocators.LOGIN_EMAIL_ID)
	private WebElement emailTextField;

	@FindBy(id = EuroStarLoginLocators.LOGIN_PW_ID)
	private WebElement passwordTextField;

	@FindBy(id = EuroStarLoginLocators.SIGN_IN_BUTTON_ID)
	private WebElement signInButton;

	/**
	 * Constructor.
	 *
	 * @param webDriver
	 *            represents an initialized Selenium WebDriver instance
	 */

	public void loginToEuroStarAccount() {
		loginLink.click();
		logger.info("Click on Login link!!");
		emailTextField.sendKeys("stuti.chourasia@gmail.com");
		logger.info("Enter the email id");
		passwordTextField.sendKeys("ag#Xx7YFphkGpVBD");
		logger.info("Enter the password");
		signInButton.click();
		logger.info("Click on submit button");
	}

	public void loginToEuroStarAccount(String email, String password) {
		loginLink.click();
		logger.info("Click on Login link!!");
		emailTextField.sendKeys(email);
		logger.info("Enter the email id");
		passwordTextField.sendKeys(password);
		logger.info("Enter the password");
		signInButton.click();
		logger.info("Click on submit button");

	}
	

}
