package AutomationFrameworkPractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFrameworkPractice.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	 public LandingPage(WebDriver driver){
		 super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPsswd;
	
	@FindBy(id="login")
	WebElement submitBtn;
	
	public void loginApplication(String email, String psswd) {
		userEmail.sendKeys(email);
		userPsswd.sendKeys(psswd);
		submitBtn.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
