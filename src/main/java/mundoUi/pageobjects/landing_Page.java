package mundoUi.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mundoUi.AbstractComponents.AbstractComponent;

public class landing_Page extends AbstractComponent {
	WebDriver driver;

	// If landing page class has to be executed than first constructor will be
	// executed than other methods will be executed
	public landing_Page(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;

		// for PageFactory
		PageFactory.initElements(driver, this);
	}

	//WebElement user_Email = driver.findElement(By.id("userEmail"));

//PageFactory

	@FindBy(id = "userEmail") // if you wanted to know HOW to write this annotation than ctrl+click on FindBy
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submitbutton;

	public ProductCatalogue loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitbutton.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
