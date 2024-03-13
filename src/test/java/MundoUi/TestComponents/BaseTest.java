package MundoUi.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import mundoUi.pageobjects.landing_Page;

public class BaseTest {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		// properties-class in java properties can read golbal properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("use.dir")+"\\src\\main\\java\\mundoUi\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	public landing_Page launchApplication() throws IOException{
		
		
		driver = initializeDriver();
		landing_Page landingPage = new landing_Page(driver);
		landingPage.goTo();
		return landingPage;
		
	}
}
