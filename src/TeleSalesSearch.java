import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TeleSalesSearch {

	
		public static WebDriver driver;
		
		void WebdriverInvoke() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Deepak\\Drivers\\ChromeDriver\\chromedriver.exe");
	        
	        driver = new ChromeDriver(); // Instantiate a ChromeDriver class.     
			driver.get("https://ksctest.crmnext.com//sanew/app//login//login"); 
			//this.captureScreen();
	        driver.manage().window().maximize(); // Maximize window  
	        
		}
		
		//Login Method
		  void login() throws IOException {
			  
			  
			  driver.findElement(By.xpath("//*[@id=\"TxtName\"]")).sendKeys("aman2");  //Enter user name
		      driver.findElement(By.xpath("//*[@id=\"TxtPassword\"]")).sendKeys("acid_qa"); // Enter Password
		      driver.findElement(By.xpath("//*[@id=\"registration\"]/input")).click();  //Click Login button
		      
		  }
		 
		
		  //Customer search cross entity [Account will not visible in this case , only customer will be visible]
		
		  void custsearch() throws InterruptedException, IOException {
		  
			  //************Start Test Case 1,Step 1 , Search The customer*********************//
			  
	    		Actions quick = new Actions(driver);
	            quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a")).click();//Click on EDC Search Option
	           Thread.sleep(3000);	 
	           driver.findElement(By.xpath("//input[@name='100003']")).sendKeys("627612001608");//Passing Card Number
	           Thread.sleep(3000);	
	           driver.findElement(By.cssSelector("a[class='acd-btn acd-btn--brand mh-12 '] span[class='ff-bold']")).click();//Click on Next Button
	    
	           Thread.sleep(3000);	
	           driver.findElement(By.xpath("//a[contains(@data-autoid,'Customer Key_0')]")).click();//Clicking on Customer Key
	           //Thread.sleep(5000);
	           JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("window.scrollBy(0,250)", "");
		   }
	           public static void main(String[] args) throws Exception {
	       		
	        	TeleSalesSearch EDC = new TeleSalesSearch();
	       		EDC.WebdriverInvoke();
	       		EDC.login();
	       		EDC.custsearch();
	           }

	}



