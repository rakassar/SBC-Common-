package cases;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import repository.Properties;



public class MC_Chargeback_GoodsServiceNotRenderedComplexCategory implements Properties
{

	WebDriver driver;
	JavascriptExecutor js;
	 WebDriverWait wait;
	 String caseIDCreated;
	 
	
	@Test(priority=1)
	public void individualCustomercreditCardCaseJourney() throws InterruptedException
	{
//		String baseUrl="https://sbcdev.crmnext.com/sag7/app/login/login";
//		String driverPath="D:\\Aman\\Automation\\Browser Driver\\Chrome\\chromedriver_win32\\chromedriver.exe";
		String BBN="10000000537";
		
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
    	driver = new ChromeDriver();
    
        js = (JavascriptExecutor) driver;
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get(URL);    
        
   
      WebElement username=driver.findElement(By.id("TxtName"));
      WebElement password=driver.findElement(By.id("TxtPassword"));
      
      username.sendKeys("109840");
      password.sendKeys("acid_qa");
      driver.findElement(By.name("command")).click();
      //Click Quick Links and Go to Customer Search
      
      Actions quick = new Actions(driver);
      quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();

      
      driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();
      System.out.println("Click Quick Links");

      
      //Customer Search Landing Page

      System.out.println("Customer Search Landing Page");
    
      WebElement inputbbn=driver.findElement(By.name("100000012"));
      inputbbn.sendKeys(BBN); //25600000469 
      System.out.println("BBN Entered");
      driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='checkbox0']")));
      driver.findElement(By.xpath("//label[@for='checkbox0']")).click();
      Thread.sleep(3000);
      
      
      driver.findElement(By.xpath("//a[@title='Next']")).click();
    
//      Thread.sleep(2000);
      js.executeScript("window.scrollBy(0,1000)","" );
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-autoid='WidgetActionButton']")));
      driver.findElement(By.xpath("//*[@data-autoid='WidgetActionButton']")).click(); //gold 7
      System.out.println("Click on Fetch Button");
      
      System.out.println("Customer 360 Landing Page");
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'click here to see more actions')]")));
      driver.findElement(By.xpath("//*[contains(@title,'click here to see more actions')]")).click();
    //  driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
      System.out.println("Clicked on Custom Action Button in Customer 360");
      
//      Thread.sleep(2000);
      List<WebElement> cust350CustumButton=driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link"));
      for(int i=0;i<cust350CustumButton.size();i++)
      {
      	String customActionButtonList =cust350CustumButton.get(i).getText();
      	if(customActionButtonList.equalsIgnoreCase("start your journey"))
      	{
      		//driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link")).get(i).click();
      		cust350CustumButton.get(i).click();
      	}
      }
      
      
      System.out.println("Clicked on Start your journey button in Customer 360 for Case creation");

      
      Set<String> listofWindows=driver.getWindowHandles();//Move to child window
      Iterator<String> ite = listofWindows.iterator();
      String S1 = ite.next();
      String S2 = ite.next();
      driver.switchTo().window(S2);
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id=\"2\"]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//select[@name='CASE_ORIGIN']")).click();
      
      
//      driver.manage().window().maximize();
//      Select bucket1 = new Select(driver.findElement(By.xpath("//select[@name='CASE_ORIGIN']")));
//  	bucket1.selectByVisibleText("Website");
//      
      Thread.sleep(1000);
     
      driver.manage().window().maximize();
      Thread.sleep(1000);
   wait.until(ExpectedConditions.presenceOfElementLocated(By.name("CASE_SUBCATEGORY1")));
     WebElement SUBCategroy=driver.findElement(By.name("CASE_SUBCATEGORY1"));
     Thread.sleep(1000);
     SUBCategroy.sendKeys("Mc Chargeback - Goods/Service Not Rendered"); //Enter SSC
     Thread.sleep(1000);
     SUBCategroy.sendKeys(Keys.ARROW_DOWN);
     Thread.sleep(1000);
     SUBCategroy.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
//     this is for account selection
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")));
     driver.findElement(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//input[@name='Grid_SearchTextBox']")).sendKeys("249999996"); // Selecting account 
     Thread.sleep(1000);
   //  driver.findElement(By.xpath("//i[@class='icon icon-arrow-right2']")).click();
     driver.findElement(By.xpath("//div[@title='249999996']")).click();
     Thread.sleep(1000);
     
     Thread.sleep(1000);
     
     WebElement ComplaintCategory =driver.findElement(By.xpath("//input[@name='CASE_RESOLUTIONCODE']"));
     Thread.sleep(1000);
     ComplaintCategory.sendKeys("Complex"); //Enter Complaint Category
     Thread.sleep(1000);
     ComplaintCategory.sendKeys(Keys.ARROW_DOWN);
     Thread.sleep(1000);
     ComplaintCategory.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
     
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-autoid='FlowNext']")));
	 driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();

   //  driver.navigate().refresh();
     js.executeScript("window.scrollBy(0,1500)", "");
    driver.findElement(By.xpath("//*[@data-autoid='cust_878_ctrl']")).sendKeys("Test Details of Concern Field"); // Input data in Details of Concern field
    System.out.println("Entered text in Details of Concern field");
    
    Thread.sleep(1000);
    JavascriptExecutor js2 =(JavascriptExecutor)driver;
    js2.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
    
    Thread.sleep(1000);
  
    driver.findElement(By.xpath("//input[@title='File Input']")).sendKeys("D:\\File\\image\\SC.png"); //File placed
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("22"); //Enter Amount
    driver.findElement(By.xpath("//input[@name='cust_2812']")).sendKeys("vijay"); //Enter Merchant Name

    
  
    driver.findElement(By.xpath("//*[@data-autoid='cust_471_ctrl']")).sendKeys("Test Remarks"); // Enter Remark
    System.out.println("Remarks Entered");
    
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
    System.out.println("Clicked on Save and Proceed button"); // Click on Save and Proceed button
    
    
    // Below code for Logout
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    jse.executeScript("arguments[0].click()", logoutElement);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
    
 
    Thread.sleep(2000);
     
    // Record send to Fraud - Chargeback (Processor)
       
    driver.findElement(By.id("TxtName")).sendKeys("120077"); //loginid
   	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
   	driver.findElement(By.name("command")).click();// click enter
   	
   	Actions quick1 = new Actions(driver);
   	quick1.moveToElement(driver.findElement(By.className("icon-service"))).perform();
   	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
   	
   	Select bucket1 = new Select(driver.findElement(By.name("QueryCategoryId")));
   	bucket1.selectByVisibleText("Case");  //Click on case object
   	
   	
   	
   	Thread.sleep(1000);
       JavascriptExecutor js1 =(JavascriptExecutor)driver;
       js1.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
       
       Thread.sleep(1000);
       WebElement ddown4 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
       Select SM2 = new Select(ddown4);
       SM2.selectByVisibleText("Assigned to Department"); // Select Assigned to Department in drop down
       
      
       driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
       Thread.sleep(4000);
       driver.findElement(By.xpath("//label[@for='checkbox0']")).click();// select the lead
       driver.findElement(By.xpath("//i[@title='Self Assign Cases']")).click();// Click on Self assign button
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click(); // Click on OK in pop up
      Thread.sleep(1000);
      
      Thread.sleep(1000);
       WebElement ddown2 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
       Select SM3 = new Select(ddown2);
       SM3.selectByVisibleText("Assigned to Me");   // Select Assigned to Me in drop down
       
       
       driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
     Thread.sleep(2000);
       driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
       //Click on the record
       Thread.sleep(1000);
       driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
       
       driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
       Thread.sleep(1000);
       WebElement ddown3 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
       Select SM4 = new Select(ddown3);
       SM4.selectByVisibleText("Accept");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
       
       Thread.sleep(3000);
       
       
       // Below code for Logout
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
       WebElement logoutElement1=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
       
       JavascriptExecutor jse1= (JavascriptExecutor)driver;
       jse1.executeScript("arguments[0].click()", logoutElement1);

       Thread.sleep(2000);
       System.out.println("Clicked on right Top cornor for logout");
       
       driver.findElement(By.xpath("//a[@title='Logout']")).click();
       Thread.sleep(2000);
       System.out.println("Logout Successfully");
       
    
       Thread.sleep(2000);
       
       
    // Record send to Fraud - Chargeback (supervisor)
       
       
       
       driver.findElement(By.id("TxtName")).sendKeys("901116"); //loginid
   	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
   	driver.findElement(By.name("command")).click();// click enter
   	
   	Actions quick2 = new Actions(driver);
   	quick2.moveToElement(driver.findElement(By.className("icon-service"))).perform();
   	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
   	
   	Select bucket2 = new Select(driver.findElement(By.name("QueryCategoryId")));
   	bucket2.selectByVisibleText("Case");  //Click on case object
   	
   	
   	
   	Thread.sleep(1000);
       JavascriptExecutor js3 =(JavascriptExecutor)driver;
       js3.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
       
       Thread.sleep(1000);
       WebElement ddown5 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
       Select SM = new Select(ddown5);
       SM.selectByVisibleText("Assigned to Department"); // Select Assigned to Department in drop down
       
      
       driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
       Thread.sleep(4000);
       driver.findElement(By.xpath("//label[@for='checkbox0']")).click();// select the lead
       driver.findElement(By.xpath("//i[@title='Self Assign Cases']")).click();// Click on Self assign button
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click(); // Click on OK in pop up
      Thread.sleep(1000);
      
      Thread.sleep(1000);
       WebElement ddown6 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
       Select SM5 = new Select(ddown6);
       SM5.selectByVisibleText("Assigned to Me");   // Select Assigned to Me in drop down
       
       
       driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
     Thread.sleep(2000);
       driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
       //Click on the record
       Thread.sleep(1000);
       driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
       
       driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
       Thread.sleep(1000);
       WebElement ddown7 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
       Select SM6 = new Select(ddown7);
       SM6.selectByVisibleText("Accept");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
       
       Thread.sleep(2000);
   

    
    
    
	}	

}
