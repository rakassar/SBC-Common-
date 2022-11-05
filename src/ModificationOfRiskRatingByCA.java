package sbc;


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



public class ModificationOfRiskRatingByCA
{

	WebDriver driver;
	JavascriptExecutor js;
	 WebDriverWait wait;
	 String caseIDCreated;
	 
	
	@Test(priority=1)
	public void individualCustomercreditCardCaseJourney() throws InterruptedException
	{
		String baseUrl="https://sbcdev.crmnext.com/sag7/app/login/login";
		String driverPath="D:\\Aman\\Automation\\Browser Driver\\Chrome\\chromedriver_win32\\chromedriver.exe";
		String BBN="45600000731";
		
		System.setProperty("webdriver.chrome.driver",driverPath);
    	driver = new ChromeDriver();
    
        js = (JavascriptExecutor) driver;
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get(baseUrl);    
        
   
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
     SUBCategroy.sendKeys("Modification Of Risk Rating"); //Enter SSC
     Thread.sleep(1000);
     SUBCategroy.sendKeys(Keys.ARROW_DOWN);
     SUBCategroy.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
//     this is for account selection
//     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")));
//     driver.findElement(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")).click();
//     Thread.sleep(1000);
//     driver.findElement(By.xpath("//input[@name='Grid_SearchTextBox']")).sendKeys("EAN122892"); // Selecting account 
//     Thread.sleep(1000);
//   //  driver.findElement(By.xpath("//i[@class='icon icon-arrow-right2']")).click();
//     driver.findElement(By.xpath("//div[@title='EAN122892']")).click();
//     Thread.sleep(1000);
     
    
     
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
  
    driver.findElement(By.xpath("//*[@data-autoid='cust_471_ctrl']")).sendKeys("Test Remarks"); // Enter Remark
    System.out.println("Remarks Entered");
    
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
    System.out.println("Clicked on Save and Proceed button"); // Click on Save and Proceed button
    
    WebElement caseID=driver.findElement(By.xpath("//div[@class='summaryband__item flex items-center']/div/div/div/span[@data-autoid='CASE_NUMBER_ctrl']"));
    caseIDCreated=caseID.getText();  
    System.out.println("Contact Information By CCA:"+caseIDCreated);
    
    
    Thread.sleep(1000);
    
    
    driver.findElement(By.xpath("//i[@class='icon icon-close pointer f13']")).click();

	Thread.sleep(1000);

	driver.findElement(By.xpath("//i[@class='icon icon-stack']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[@class='primary f12 ph-12 truncate ff-medium acd-link-text'][normalize-space()='Perform CRRSC']")).click();

	
	// Select Is the customer, beneficiary, benefactor included in OFAC / AMLC / UN / JMOF Sanction List? drop down
	Thread.sleep(1000);
	WebElement ddown21 = driver.findElement(By.xpath("//select[@name='cust_2680']")); 
	Select SM21 = new Select(ddown21);
	SM21.selectByVisibleText("Yes"); 
	

	// Select Is the customer, beneficiary or benefactor included in the Bank's Internal Watchlist 1 (Convicted or Restricted) ? drop down
	Thread.sleep(1000);
	WebElement ddown22 = driver.findElement(By.xpath("//select[@name='cust_2681']")); 
	Select SM22 = new Select(ddown22);
	SM22.selectByVisibleText("Yes"); 
	
	

	// Select Is the customer, beneficiary or benefactor included in the Bank's Internal Watchlist 2 (Alleged or Person of Interest) ? drop down
	Thread.sleep(1000);
	WebElement ddown23 = driver.findElement(By.xpath("//select[@name='cust_2682']")); 
	Select SM23 = new Select(ddown23);
	SM23.selectByVisibleText("Yes"); 
	
	

	// Select Is the customer, beneficiary, benefactor an HPI, publicly declared known to be related or closely associated to an HPI OR a joint accountholder of an existing customer rated as High Risk? drop down
	Thread.sleep(1000);
	WebElement ddown24 = driver.findElement(By.xpath("//select[@name='cust_2683']")); 
	Select SM24 = new Select(ddown24);
	SM24.selectByVisibleText("Yes"); 
	
	

	// Select Is the customer, beneficiary or benefactor an OFW? drop down
	Thread.sleep(1000);
	WebElement ddown25 = driver.findElement(By.xpath("//select[@name='cust_2684']")); 
	Select SM25 = new Select(ddown25);
	SM25.selectByVisibleText("Yes"); 
	
	

	// Select If Yes, please specify the country where the customer is working: drop down
	Thread.sleep(1000);
	WebElement ddown26 = driver.findElement(By.xpath("//select[@name='cust_2706']")); 
	Select SM26 = new Select(ddown26);
	SM26.selectByVisibleText("Austria"); 
	
	

	// Select Is the customer a Foreign National? drop down
	Thread.sleep(1000);
	WebElement ddown27 = driver.findElement(By.xpath("//select[@name='cust_2686']")); 
	Select SM27 = new Select(ddown27);
	SM27.selectByVisibleText("Yes"); 
	

	// Select Please specify where the customer is residing or its nationality and /or citizenship: drop down
	Thread.sleep(1000);
	WebElement ddown28 = driver.findElement(By.xpath("//select[@name='cust_2707']")); 
	Select SM28 = new Select(ddown28);
	SM28.selectByVisibleText("Austria"); 
	

	// Select Is the customer opening a Numbered Account? drop down
	Thread.sleep(1000);
	WebElement ddown29 = driver.findElement(By.xpath("//select[@name='cust_2688']")); 
	Select SM29 = new Select(ddown29);
	SM29.selectByVisibleText("Yes"); 
	

	// Select Employment Type drop down
	Thread.sleep(1000);
	WebElement ddown30 = driver.findElement(By.xpath("//select[@name='cust_2689']")); 
	Select SM30 = new Select(ddown30);
	SM30.selectByVisibleText("Employed"); 
	
	// Select Kindly specify the Industry where the customer is affiliated to: drop down
	WebElement element = driver.findElement(By.xpath("//input[@name='cust_2709']"));
	element.sendKeys("ACTIVITIES OF AMUSEMENT PARKS AND THEME PARKS");
	Thread.sleep(1000);
	element.sendKeys(Keys.ARROW_DOWN);
	element.sendKeys(Keys.ENTER);
	
	
	
	// Select Is he / she the owner or in a senior managerial decision making position? drop down
	Thread.sleep(1000);
	WebElement ddown31 = driver.findElement(By.xpath("//select[@name='cust_2691']")); 
	Select SM31 = new Select(ddown31);
	SM31.selectByVisibleText("Yes"); 

	
	// Select Does he/she have direct dealing with clients? drop down
	Thread.sleep(1000);
	WebElement ddown32 = driver.findElement(By.xpath("//select[@name='cust_2692']")); 
	Select SM32 = new Select(ddown32);
	SM32.selectByVisibleText("Yes"); 
	
	// Select Please select City of Residency/Work: drop down
	WebElement element2 = driver.findElement(By.xpath("//input[@name='cust_2709']"));
	element2.sendKeys("Abulug");
	Thread.sleep(1000);
	element2.sendKeys(Keys.ARROW_DOWN);
	element2.sendKeys(Keys.ENTER);
	
	// Select Is the customer residing or working within the vicinity of the branch or is the branch accessible by ordinary transportation, such that transporting / withdrawing deposits is practical / not too risky? drop down
	Thread.sleep(1000);
	WebElement ddown33 = driver.findElement(By.xpath("//select[@name='cust_2699']")); 
	Select SM33 = new Select(ddown33);
	SM33.selectByVisibleText("No"); 
	
	// Select Is initial deposit and type of product aligned with the customer profile? drop down
	Thread.sleep(1000);
	WebElement ddown34 = driver.findElement(By.xpath("//select[@name='cust_2700']")); 
	Select SM34 = new Select(ddown34);
	SM34.selectByVisibleText("No"); 
	
	// Select Are there expected inward/outward remittances(within or outside the Phils.)? drop down
	Thread.sleep(1000);
	WebElement ddown35 = driver.findElement(By.xpath("//select[@name='cust_2701']")); 
	Select SM35 = new Select(ddown35);
	SM35.selectByVisibleText("No"); 
	
	// Select Are you comfortable with the customer based on information provided drop down
	Thread.sleep(1000);
	WebElement ddown36 = driver.findElement(By.xpath("//select[@name='cust_2703']")); 
	Select SM36 = new Select(ddown36);
	SM36.selectByVisibleText("No"); 
	
	// Select Are you comfortable with the customer based on documents presented drop down
	Thread.sleep(1000);
	WebElement ddown37 = driver.findElement(By.xpath("//select[@name='cust_2704']")); 
	Select SM37 = new Select(ddown37);
	SM37.selectByVisibleText("No"); 
	
	//Fill Remarks
	driver.findElement(By.xpath("//textarea[@name='cust_2705']")).sendKeys("Completed");
	Thread.sleep(1000);
	//Click on finish button
	driver.findElement(By.xpath("//span[@class='ff-regular']")).click();
	Thread.sleep(3000);
    
    
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
    
 // In case of High CRRSC risk and If case assign to BBOG user then kindly comment the Customer Branch(Branch - BCM) user approval code
    
    // Given Below case when case assign to Customer Branch(Branch - BCM) user
   
    // Record send to Customer Branch(Branch - BCM)   
       
    driver.findElement(By.id("TxtName")).sendKeys("120006"); //loginid
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
       
       
    // Record send to Maintenance Analyst(Processor)
       
       
       
       driver.findElement(By.id("TxtName")).sendKeys("206578"); //loginid
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
