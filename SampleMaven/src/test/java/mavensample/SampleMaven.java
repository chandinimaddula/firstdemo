package mavensample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SampleMaven {
	
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUp() {
	reporter = new ExtentSparkReporter("myreport.html");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	}
	
			@Test
		    public void TestMethod() {
			//System.setProperty("webdriver.chrome.driver","C://Users/satyasm/eclipse-Selenium-Project/seleniumproject/drivers/chromedriver.exe");
			
			ExtentTest test = extent.createTest("My first test");
			test.log(Status.INFO, "This shows info");
			
			WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://www.google.com");
	        driver.manage().window().maximize();
	        
	        WebElement element=driver.findElement(By.name("q"));
	        element.sendKeys("chromedriver");
	        element.submit();			
	        //Thread.sleep(3000);        
	        
	       // driver.quit();
	        }
			
			@AfterSuite
			public void tearDown() {
			extent.flush();
			}
		
	
} 
