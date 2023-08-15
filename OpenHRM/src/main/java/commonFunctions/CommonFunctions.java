package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	public static Properties properties = null;
	public static WebDriver driver = null;
	static Logger logger = Logger.getLogger(CommonFunctions.class);

	public Properties loadPropertyFile() throws IOException {
		// Property File Load and Return
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		logger.info("OrangeHRM Test Begins");
		logger.info("Loading the Property File");
		properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		loadPropertyFile();
		String browser = properties.getProperty("Browser");
		String url = properties.getProperty("URL");
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			logger.info("Launching Chrome Browser");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			logger.info("Launching Edge Browser");
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Navigating to Application");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void tearDown() {
		logger.info("Execution is Completed Close the Browser");
		driver.close();

	}
}
