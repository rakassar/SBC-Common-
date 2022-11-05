import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EDCLeadSrch {

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
	        
	        //************Start Test Case 1,Step 1 , Search The customer*********************//
	        Actions quick = new Actions(driver);
	        quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
            driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a")).click();//Click on EDC Search Option
	       Thread.sleep(5000);	 
	       
	       driver.findElement(By.xpath("//input[@name='cust_741']")).sendKeys("627612001608"); //Passing Citizen ID 
	       
	       
	       
	       driver.findElement(By.xpath("//span[@class='ff-regular']")).click();//Click on Next Button
	     
	       Thread.sleep(5000);	
	       driver.findElement(By.xpath("//a[contains(@data-autoid,'Customer Key_0')]")).click();//Clicking on Customer Key
	       Thread.sleep(5000);
	       //**************End Test Case 1******************//
	      
	       //************Start Step 2, Create Lead By clicking on New Button*********************//
	       
	       driver.findElement(By.cssSelector(".icon.icon-stack")).click();
	       driver.findElement(By.cssSelector("a[title='New Lead'] span[class='primary f12 ph-12 truncate ff-medium acd-link-text']")).click();
	       driver.findElement(By.xpath("//a[contains(@data-autoid,'cust_1841_srch')]")).click();
	       
	      // driver.switchTo().activeElement();
	       
			/*
			 * int size = driver.findElements(By.tagName("iframe")).size();
			 * 
			 * for(int i=0; i<=size; i++){ driver.switchTo().frame(i); int
			 * total=driver.findElements(By.xpath("//div[@title='Siam Takashimaya JCB']")).
			 * size(); System.out.println(total); driver.switchTo().defaultContent();}
			 */

	       Thread.sleep(5000);
	       driver.findElement(By.xpath("//div[@title='Krungsri JCB Platinum']")).click();
	       
	     //  driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
	       
	       driver.findElement(By.xpath("//span[normalize-space()='Finish']")).click();
	       
	}

}
