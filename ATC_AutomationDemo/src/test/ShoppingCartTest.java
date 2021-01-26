package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddressPage;
import pages.LoginPage;
import pages.ShoppingPage;




public class ShoppingCartTest {

	WebDriver driver;
	LoginPage objLogin;
	AddressPage objAddressPage;
	ShoppingPage objShoppingPage;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	/**
	 * This test go to http://demo.guru99.com/V4/
	 * Verify login page title as guru99 bank
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct(){
		//Create Login Page object
		objLogin = new LoginPage(driver);

		//login to application
		objLogin.goToSignIn();
		objLogin.loginToGuru99("test@atc.net", "123456789");

		//Create Address Page object
		objAddressPage = new AddressPage(driver);

		//Add New Address
		objAddressPage.addAddress();

		//Create Shopping Page object
		objShoppingPage = new ShoppingPage(driver);

		//Add to cart
		objShoppingPage.addToCart();

		//Checkout Cart
		objShoppingPage.checkoutCart();

		//Check Order History
		objShoppingPage.checkOrderHistory();

		//Take Screenshot
		takeSnapShot(driver);

		//Sign Out
		objShoppingPage.signOut();
	}

	@AfterTest
	public void quit(){
		driver.quit();
	}

	public void takeSnapShot(WebDriver webdriver){

		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
		System.out.println("****************The Screenshot is taken****************");
	}

}



