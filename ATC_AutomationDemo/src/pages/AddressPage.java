package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='My addresses']")
	WebElement myAddresses;
	
	@FindBy(xpath = "//a[@title='Add an address']")
	WebElement addNewAddress;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='company']")
	WebElement company;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postcode;
	
	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement homePhone;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobilePhone;
	
	@FindBy(xpath = "//*[@id='other']")
	WebElement additionalInfo;
	
	@FindBy(xpath = "//input[@id='alias']")
	WebElement addressTtitle;
	
	@FindBy(xpath = "//button[@id='submitAddress']")
	WebElement save;
	
	
	public AddressPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	//Get the User name from Home Page
	public void addAddress(){
		myAddresses.click();
		addNewAddress.click();
		firstName.clear();
		firstName.sendKeys("Test");
		lastName.clear();
		lastName.sendKeys("Customer");
		company.sendKeys("Test Company");
		address1.sendKeys("Test Address1");
		address2.sendKeys("Test Address2");
		city.sendKeys("Test City");
		
		Select stateSelection = new Select(state);
		stateSelection.selectByVisibleText("Iowa");
		
		postcode.sendKeys("12345");
		
		Select countrySelection = new Select(country);
		countrySelection.selectByVisibleText("United States");
		
		homePhone.sendKeys("9874563210");
		mobilePhone.sendKeys("9876543210");
		additionalInfo.sendKeys("This is a test Info");
		addressTtitle.sendKeys("My Test Address");
		save.click();
		
	}
}
