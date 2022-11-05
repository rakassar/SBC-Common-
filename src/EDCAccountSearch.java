import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EDCAccountSearch {

	public static void main(String[] args) throws InterruptedException {
	
		
	           // System Property for Chrome Driver   
	        System.setProperty("webdriver.chrome.driver", "D:\\Deepak\\Drivers\\ChromeDriver\\chromedriver.exe");  
	        
	             // Instantiate a ChromeDriver class.     
	        WebDriver driver=new ChromeDriver();  
	         
	           // Launch Website  
	        driver.get("https://ksctest.crmnext.com//sanew/app//login//login");  
	        driver.manage().window().maximize(); // Maximize window
	        driver.findElement(By.xpath("//*[@id=\"TxtName\"]")).sendKeys("APC3");  //Enter user name
	        driver.findElement(By.xpath("//*[@id=\"TxtPassword\"]")).sendKeys("acid_qa"); // Enter Password
	        driver.findElement(By.xpath("//*[@id=\"registration\"]/input")).click();  //Click Login button
	        
	        //************Start Test Case 2, Open The customer*********************//
	        Actions quick = new Actions(driver);
	        quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
            driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a")).click();//Click on EDC Search Option
	       Thread.sleep(5000);	 
	       
	       driver.findElement(By.xpath("//input[@name='cust_741']")).sendKeys("627612001608"); //Passing Citizen ID 
	       
	       driver.findElement(By.xpath("//span[@class='ff-regular']")).click();//Click on Next Button
	     
	       Thread.sleep(5000);	
	       driver.findElement(By.xpath("//a[contains(@data-autoid,'Account Number_0')]")).click();//Clicking on Account
	       Thread.sleep(5000);
	       //**************End Test Case 2******************//
	      
	    
	      // driver.close();
	}

}
