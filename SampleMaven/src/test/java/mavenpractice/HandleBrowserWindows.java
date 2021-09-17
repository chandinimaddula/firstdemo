package mavenpractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
		//gives window id for current window
		//String singleWindowHandle=driver.getWindowHandle();
		//System.out.println(singleWindowHandle);
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		//getting multiple windows id 
		Set<String> multipleWindowHandles=driver.getWindowHandles(); //set duplicates r not allowed
		
		//first method- Iterator to get multiple window handles
		/*Iterator<String> it= multipleWindowHandles.iterator();
		String parentID=it.next();
		String childID=it.next();
		System.out.println(parentID);
		System.out.println(childID);
		*/
		
		//Second type- using list to get multiple window handles
		List<String> windowIds= new ArrayList(multipleWindowHandles); //List allows duplicates
		/*String parentID=windowIds.get(0);
		String childID= windowIds.get(1);
		System.out.println(parentID);
		System.out.println(childID);
		
		//How to switch to another window using window id
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		*/
		
		//using for each loop
		for(String winId:windowIds) {
			//To print the multiple handles in a single shot
			//System.out.println(winId);
			
			String winTitle=driver.switchTo().window(winId).getTitle();
			System.out.println(winTitle);
		}

	}

}
