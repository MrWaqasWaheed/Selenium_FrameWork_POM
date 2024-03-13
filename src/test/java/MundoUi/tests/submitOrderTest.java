package MundoUi.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MundoUi.TestComponents.BaseTest;
import mundoUi.pageobjects.CartPage;
import mundoUi.pageobjects.CheckoutPage;
import mundoUi.pageobjects.ConfirmationPage;
import mundoUi.pageobjects.ProductCatalogue;
import mundoUi.pageobjects.landing_Page;

public class submitOrderTest extends BaseTest {

		@Test
		public void submitOrder() {
		String productName = "ZARA COAT 3";
		landing_Page landingPage =launchApplication();
		// making object of landing_Page Class then will pass driver as object from
		// StandAloneTest Class to landing_Page's constructor
		landing_Page landing_Page = new landing_Page(driver);
		landing_Page.goTo();
		ProductCatalogue ProductCatalogue = landing_Page.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
		CartPage cartPage = ProductCatalogue.goToCardPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage =checkoutPage.submitOrder();
		String confirmMessage= confirmationPage.getConfirmatiomMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
	
}
// Add javascriptExecutor and scroll down the window, then only it works. Please
// refer the below code -

//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

//JavascriptExecutor js = (JavascriptExecutor) driver;
//
//js.executeScript("window.scrollBy(0,100)");
//
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
//
//driver.findElement(By.cssSelector(".action__submit")).click();
//
//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//
//Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	//package rahulshettyacademy.tests;

//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import rahulshettyacademy.TestComponents.BaseTest;
//import rahulshettyacademy.pageobjects.CartPage;
//import rahulshettyacademy.pageobjects.CheckoutPage;
//import rahulshettyacademy.pageobjects.ConfirmationPage;
//import rahulshettyacademy.pageobjects.LandingPage;
//import rahulshettyacademy.pageobjects.OrderPage;
//import rahulshettyacademy.pageobjects.ProductCatalogue;
//
//public class SubmitOrderTest extends BaseTest{
//	String productName = "ZARA COAT 3";
//
//	@Test(dataProvider="getData",groups= {"Purchase"})
//	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
//	{
//
//		
//		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
//		List<WebElement> products = productCatalogue.getProductList();
//		productCatalogue.addProductToCart(input.get("product"));
//		CartPage cartPage = productCatalogue.goToCartPage();
//
//		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
//		Assert.assertTrue(match);
//		CheckoutPage checkoutPage = cartPage.goToCheckout();
//		checkoutPage.selectCountry("india");
//		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		
//
//	}
//	
//	@Test(dependsOnMethods= {"submitOrder"})
//	public void OrderHistoryTest()
//	{
//		//"ZARA COAT 3";
//		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
//		OrderPage ordersPage = productCatalogue.goToOrdersPage();
//		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
//		
//}
//	
//
//	
//	//Extent Reports - 
//	
//	
//	@DataProvider
//	public Object[][] getData() throws IOException
//	{
//
//		
//		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
//		return new Object[][]  {{data.get(0)}, {data.get(1) } };
//		
//	}
	
	
	
	
//	 @DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//	    
//	  }
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "anshika@gmail.com");
//	map.put("password", "Iamking@000");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");
	  
	
	
	
	
	
	
	
	


}

