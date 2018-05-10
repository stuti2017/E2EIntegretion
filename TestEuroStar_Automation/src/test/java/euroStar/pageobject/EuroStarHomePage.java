package euroStar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import euroStar.locators.EuroStarLoginLocators;

public class EuroStarHomePage {
	
	WebDriver webDriver;
    public EuroStarHomePage(WebDriver driver){ 
            this.webDriver=driver; 
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
	   * @param webDriver represents an initialized Selenium WebDriver instance
	   */
	  
	  public void loginToEuroStarAccount() {
		  loginLink.click();
		  emailTextField.sendKeys("stuti.chourasia@gmail.com");
		  passwordTextField.sendKeys("ag#Xx7YFphkGpVBD");
		  signInButton.click();
	  }
	  
	  public void loginLinkedin(String email,String password) {

		  emailTextField.sendKeys(email);
		  passwordTextField.sendKeys(password);
		  signInButton.click();
		  
	  }
	  

}
