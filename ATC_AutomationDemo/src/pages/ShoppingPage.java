package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Women']")
	WebElement women;
	
	@FindBy(xpath = "//div[@class='block_content']//*[@class='last']/*[@class='grower CLOSE']")
	WebElement expandDresses;

	@FindBy(xpath = "//div[@class='block_content']//*[@class='last']/a[contains(text(),'Summer Dresses')]")
	WebElement summerDresses;

	@FindBy(xpath = "//*[@id='list']")
	WebElement listView;

	@FindBy(xpath = "//*[@class='product_list row list']//a[contains(text(),'Dress')]")
	List<WebElement> dresses;

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(xpath = "//select[@class='form-control attribute_select no-print']")
	WebElement size;

	@FindBy(xpath = "(//*[@id='color_to_pick_list']//a)[1]")
	WebElement color;

	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addToCart;

	@FindBy(xpath = "//*[@title='Continue shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement shoppingCart;

	@FindBy(xpath = "//*[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement checkoutAddressTab;

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsOfService;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement checkoutShippingTab;

	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement bankwire;

	@FindBy(xpath = "//*[@id='cart_navigation']//button")
	WebElement confirmOrder;

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement myProfile;

	@FindBy(xpath = "//*[text()='Order history and details']")
	WebElement orderHistory;

	@FindBy(xpath = "//a[@class='logout']")
	WebElement signOut;

	public ShoppingPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	//Add items to cart
	public void addToCart(){
		
		women.click();
		expandDresses.click();
		summerDresses.click();
		listView.click();

		for(WebElement d : dresses) {
			d.click();
			quantity.sendKeys("5");

			Select sizeSelection = new Select(size);
			sizeSelection.selectByVisibleText("L");

			color.click();
			addToCart.click();
			continueShopping.click();
		}
	}

	// checkout cart
	public void checkoutCart(){
		shoppingCart.click();
		proceedToCheckout.click();
		checkoutAddressTab.click();
		termsOfService.click();
		checkoutShippingTab.click();
		bankwire.click();
		confirmOrder.click();
	}

	// checkout cart
	public void checkOrderHistory(){
		myProfile.click();
		orderHistory.click();
	}
	
	//Sign Out
	public void signOut() {
		signOut.click();
	}

}
