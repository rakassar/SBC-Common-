import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeOwner {
	
public static WebDriver driver;
JavascriptExecutor js = (JavascriptExecutor) driver;


	void WebdriverInvoke() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Deepak\\Drivers\\ChromeDriver\\chromedriver.exe");
        
        driver = new ChromeDriver(); // Instantiate a ChromeDriver class.     
		driver.get("https://ksctest.crmnext.com//sanew/app//login//login"); 
        driver.manage().window().maximize(); // Maximize window  
        
	}
	
	//Login Method
	  void login() throws IOException, InterruptedException {
		  
		  driver.findElement(By.xpath("//*[@id=\"TxtName\"]")).sendKeys("deepak");  //Enter user name
	      driver.findElement(By.xpath("//*[@id=\"TxtPassword\"]")).sendKeys("acid_qa"); // Enter Password
	      driver.findElement(By.xpath("//*[@id=\"registration\"]/input")).click();  //Click Login button
	      

	  }
	 
	  //Click on Lead Object
	  
	  void leadobject() throws InterruptedException {
		  Thread.sleep(2000);
          driver.findElement(By.xpath("//*[@id=\"js-vnav\"]/li[2]/div/div[1]/a[1]")).click();
          JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,250)", "");
	       Thread.sleep(2000);
          driver.findElement(By.xpath("//span[@class='acd-btn-circle__icon']")).click();
          Thread.sleep(2000);
          
          driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
          
          
          
        //driver.findElement(By.cssSelector("//*[@id = 'm_bs_btnClose']")).click();
	  }
	  
		
		
		  void changeowner() throws InterruptedException {
		  
		 Set<String> listofWindows=driver.getWindowHandles();//Move to child window
          Iterator<String> ite = listofWindows.iterator();
          //System.out.println(ite);
          String S1 = ite.next();
          String S2 = ite.next();
          driver.switchTo().window(S2);
          Thread.sleep(12000);
          driver.findElement(By.xpath("//input[@id='m_bs_btnClose']")).click();//Click on Finish Button 
          }
		 
        public static void main(String[] args) throws Exception {
		
		ChangeOwner EDC2 = new ChangeOwner();
		EDC2.WebdriverInvoke();
		EDC2.login();
		EDC2.leadobject();
		EDC2.changeowner();
	}

}
