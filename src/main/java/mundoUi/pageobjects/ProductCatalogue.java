package mundoUi.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mundoUi.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;

	// If landing page class has to be executed than first constructor will be
	// executed than other methods will be executed
	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;

		// for PageFactory
		PageFactory.initElements(driver, this);
	}
//oldmethods
	// WebElement user_Email = driver.findElement(By.id("userEmail"));

//PageFactory

	@FindBy(css = ".mb-3") // if you wanted to know HOW to write this annotation than ctrl+click on FindBy
	List<WebElement> products;

	@FindBy(css = ".ng-animating") // if you wanted to know HOW to write this annotation than ctrl+click on FindBy
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By toastMessage= By.cssSelector("#toast-container");
	By addToCart = By.cssSelector(".card-body button:last-of-type");

			
			/*
			 * List<WebElement> products = productCatalogue.getProductList();
This code appears to be written in Java and involves the use of Selenium, a popular automation tool for web testing. Let's break down the code step by step:

List<WebElement> products: This line declares a variable named products with a type of List<WebElement>. In Java, a List is a collection that can hold multiple elements, and WebElement is a class provided by Selenium for representing elements on a web page. So, products is expected to be a list of web elements, such as links, buttons, or other HTML elements from a web page.

productCatalogue: This appears to be an instance of a class or object called productCatalogue. It's likely that productCatalogue is an instance of a class designed to represent a webpage or a section of a webpage containing product listings.

getProductList(): This is a method call on the productCatalogue object. It's invoking a method called getProductList() to retrieve a list of web elements representing products from the webpage.
			 * */
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;

	}
	public WebElement getProductByName(String productName)
	{
		
		WebElement prod = getProductList().stream().filter(product ->

		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod =getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}
}
