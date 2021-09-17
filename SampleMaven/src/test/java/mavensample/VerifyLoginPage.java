package mavensample;

import mavensample.LoginPage;
/**
* 
*/
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
 
/**
* @author Mukesh_50
*
*/
public class VerifyLoginPage 
	{
 
 
@Test
	public void verifyValidLogin()
	{

	WebDriverManager.firefoxdriver().setup();
	//WebDriver driver=new FirefoxDriver();
	WebDriver driver= new FirefoxDriver();
	
 
	driver.manage().window().maximize();
 
	driver.get("https://opensource-demo.orangehrmlive.com/");
 
	LoginPage login=new LoginPage(driver);
 
		login.typeUserName("Admin");
		login.typePassword("admin123");
 
		login.clickOnLoginButton();
 
 
		driver.quit();
 
	}
 
 
}
