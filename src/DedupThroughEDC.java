import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class DedupThroughEDC {

	public static WebDriver driver;
	
	void WebdriverInvoke() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Deepak\\Drivers\\ChromeDriver\\chromedriver.exe");
        
        driver = new ChromeDriver(); // Instantiate a ChromeDriver class.     
		driver.get("https://ksctest.crmnext.com//sanew/app//login//login"); 
		this.captureScreen();
        driver.manage().window().maximize(); // Maximize window  
        
	}
	
	//Login Method
	  void login() throws IOException {
		  
		  
		  driver.findElement(By.xpath("//*[@id=\"TxtName\"]")).sendKeys("deepak");  //Enter user name
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
           
         //  driver.findElement(By.xpath("//input[@name='cust_741']")).sendKeys("627612001608"); //Passing Citizen ID 
           
           driver.findElement(By.xpath("//input[@name='cust_1104']")).sendKeys("567888813");//Passing Card Number
           
           driver.findElement(By.xpath("//span[@class='ff-regular']")).click();//Click on Next Button
           this.captureScreen();
           Thread.sleep(5000);	
           driver.findElement(By.xpath("//a[contains(@data-autoid,'Customer Key_0')]")).click();//Clicking on Customer Key
           Thread.sleep(5000);
           //**************End Test Case 1******************//
          
	  }
	 
	  //Create Lead Method
	public void createlead() throws InterruptedException, IOException {
		
		//************Start Step 2, Create Lead By clicking on New Button*********************//
	       driver.findElement(By.cssSelector(".icon.icon-stack")).click();
	       driver.findElement(By.cssSelector("a[title='New Lead'] span[class='primary f12 ph-12 truncate ff-medium acd-link-text']")).click();
	       driver.findElement(By.xpath("//a[contains(@data-autoid,'cust_1841_srch')]")).click();
	       Thread.sleep(3000);
	       driver.findElement(By.xpath("//div[@title='Central The1 BLACK']")).click();
	       driver.findElement(By.xpath("//span[normalize-space()='Finish']")).click();
	       Thread.sleep(1000);
	       this.captureScreen();
	}
	
	//Dedup Method
	
	public void dedup() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		 
		WebElement element = driver.findElement(By.xpath("//*[text()='Duplicate Record Listing']"));
		String Dedup = element.getText();
	System.out.println(Dedup + " : Deduplication Screen Visible ");
	this.captureScreen();
	Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class = 'footer--popup']//*[contains(text(),'Ignore And Create')]")).click();
		Thread.sleep(1000);
		this.captureScreen();
	}
	
	public void captureScreen() throws IOException
    {
		Date d = new Date();
        System.out.println(d.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HHmmss"); 
        
        	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             // Now copying it to given location somewhere//
             Files.copy(scrFile, new File("D:\\RND\\"+sdf.format(d)+".png"));

       
    }
	
	public static void main(String[] args) throws Exception {
		
		DedupThroughEDC EDC = new DedupThroughEDC();
		EDC.WebdriverInvoke();
		EDC.login();
		EDC.custsearch();
		EDC.createlead();
		EDC.dedup();
		EDC.captureScreen();

	}

}

