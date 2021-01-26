package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInButton;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement submitLogin;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	// Go to SignIn option
	public void goToSignIn() {
		signInButton.click();
	}

	//Set user name in textbox
	public void setUserName(String strUserName){
		emailAddress.sendKeys(strUserName);
	}

	//Set password in password textbox
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin(){
		submitLogin.click();
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void loginToGuru99(String strUserName,String strPasword){
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();
	}
}
