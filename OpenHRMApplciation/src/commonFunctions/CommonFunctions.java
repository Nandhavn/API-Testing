package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {

	public static WebDriver driver=null;
	public static Properties properties=null;
	
	public static Logger logger=Logger.getLogger(CommonFunctions.class);

	public Properties propertyload() throws IOException{
		logger.info("Configuring property file");

		FileInputStream fileInputStream=new FileInputStream("config.properties");
		properties=new Properties();
		properties.load(fileInputStream);
		return properties;
	}



	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		propertyload();
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String DriverLocation=properties.getProperty("DriverLocation");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", DriverLocation);
			driver=new ChromeDriver();
		} else if(browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("WebDriver.gecko.driver", DriverLocation);
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}
	@AfterSuite
	public void tearDown() {
		driver.quit();

	}

}
