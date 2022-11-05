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



public class ChangeInDueDate
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
		String BBN="14300000797";
		
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
      
//      Thread.sleep(2000);
      
    //Get handles of the windows
      String mainWindowHandle = driver.getWindowHandle();

//      Thread.sleep(3000);
      Set<String> allWindowHandles = driver.getWindowHandles();
      Iterator<String> iterator=	allWindowHandles.iterator();
//     String parentWindow= iterator.next();
//     String childWindow= iterator.next();
      System.out.println("Handle Child Windows");
   
      while (iterator.hasNext()) 
      {
          String ChildWindow = iterator.next();
              if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
              {
              driver.manage().window().maximize();
              driver.switchTo().window(ChildWindow);
//              Thread.sleep(2000);
              WebElement CustomerService = driver.findElement(By.xpath("//*[@id=\"2\"]"));
   
              CustomerService.click();	
              }    
      }
      
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
     SUBCategroy.sendKeys("Change In Due Date");
     Thread.sleep(1000);
     SUBCategroy.sendKeys(Keys.ARROW_DOWN);
     SUBCategroy.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")));
     driver.findElement(By.xpath("//a[@data-autoid='CASE_PRDHOLDINGNUMBER_srch']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//input[@name='Grid_SearchTextBox']")).sendKeys("11111235");
     driver.findElement(By.xpath("//i[@class='icon icon-arrow-right2']")).click();
     driver.findElement(By.xpath("//div[@title='11111235']")).click();
     Thread.sleep(1000);
     
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-autoid='FlowNext']")));
	 driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
     
    

   //  driver.navigate().refresh();
     js.executeScript("window.scrollBy(0,1500)", "");
    driver.findElement(By.xpath("//*[@data-autoid='cust_878_ctrl']")).sendKeys("Test Details of Concern Field"); // Input data in Details of Concern field
    System.out.println("Entered text in Details of Concern field");
    
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@name='cust_1386']")).sendKeys("2"); // Input data in From field
    driver.findElement(By.xpath("//input[@name='cust_1387']")).sendKeys("8"); // Input data in To field
    Thread.sleep(1000);
    
    
   
    driver.findElement(By.xpath("//*[@data-autoid='cust_471_ctrl']")).sendKeys("Test Remarks");
    System.out.println("Remarks Entered");
    
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
    System.out.println("Clicked on Save and Proceed button");
    
    WebElement caseID=driver.findElement(By.xpath("//div[@class='summaryband__item flex items-center']/div/div/div/span[@data-autoid='CASE_NUMBER_ctrl']"));
    caseIDCreated=caseID.getText();  
    System.out.println("Account Balance Computation CaseID:"+caseIDCreated);
    
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    jse.executeScript("arguments[0].click()", logoutElement);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
    
 
    Thread.sleep(1000);
    
    
  // Record send to on SFD - Processor	   
    
	driver.findElement(By.id("TxtName")).sendKeys("60702"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick1 = new Actions(driver);
	quick1.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
	
	Select bucket2 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket2.selectByVisibleText("Case");  //Click on case object
	
	
	
	Thread.sleep(1000);
    JavascriptExecutor js =(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
    driver.findElement(By.xpath("//select[@name='QueryViewId']")).click(); //Click to select view
    driver.findElement(By.xpath("//option[@value='55']")).click(); // Select record
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
    Thread.sleep(4000);
    driver.findElement(By.xpath("//label[@for='checkbox0']")).click();// select the lead
    driver.findElement(By.xpath("//i[@title='Self Assign Cases']")).click();// Click on Self assign button
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click(); // Click on OK in pop up
   Thread.sleep(1000);
    driver.findElement(By.xpath("//option[@value='56']")).click(); // Select My Leads view
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
  Thread.sleep(2000);
    driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
    //Click on the record
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
    
    driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
    Thread.sleep(1000);
    WebElement ddown = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
    Select SM = new Select(ddown);
    SM.selectByVisibleText("Accept");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    //logout
    
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement4=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    Thread.sleep(1000);
    JavascriptExecutor jse1= (JavascriptExecutor)driver;
    jse1.executeScript("arguments[0].click()", logoutElement4);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
    
   
	//Record send to the LOSD (Processor)
    
    
    driver.findElement(By.id("TxtName")).sendKeys("206271"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick3 = new Actions(driver);
	quick3.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
	
	Select bucket3 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket3.selectByVisibleText("Case");  //Click on case object
	
	
	
	Thread.sleep(1000);
    JavascriptExecutor js3 =(JavascriptExecutor)driver;
    js3.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
    driver.findElement(By.xpath("//select[@name='QueryViewId']")).click(); //Click to select view
    driver.findElement(By.xpath("//option[@value='55']")).click(); // Select record
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
    Thread.sleep(4000);
    driver.findElement(By.xpath("//label[@for='checkbox0']")).click();// select the lead
    driver.findElement(By.xpath("//i[@title='Self Assign Cases']")).click();// Click on Self assign button
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click(); // Click on OK in pop up
   Thread.sleep(1000);
    driver.findElement(By.xpath("//option[@value='56']")).click(); // Select My Leads view
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
  Thread.sleep(2000);
    driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
    //Click on the record
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
    
    driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
    Thread.sleep(1000);
    WebElement ddown3 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
    Select SM3 = new Select(ddown3);
    SM3.selectByVisibleText("Accept");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    //logout
    
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement3=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    Thread.sleep(1000);
    JavascriptExecutor jse3= (JavascriptExecutor)driver;
    jse3.executeScript("arguments[0].click()", logoutElement3);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
	
	
	
	
	// Record send to LOSD (Supervisor)
	    

	
    driver.findElement(By.id("TxtName")).sendKeys("202472"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick5 = new Actions(driver);
	quick5.moveToElement(driver.findElement(By.className("icon-service"))).perform();
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
    Select SM10 = new Select(ddown2);
    SM10.selectByVisibleText("Assigned to Me");   // Select Assigned to Me in drop down
    
    
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
  Thread.sleep(2000);
    driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
    //Click on the record
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
    
    driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
    Thread.sleep(1000);
    WebElement ddown10 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
    Select SM4 = new Select(ddown10);
    SM4.selectByVisibleText("Accept");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    
    Thread.sleep(2000);
    
    
    // Below code for Logout
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement1=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    
    JavascriptExecutor jse0= (JavascriptExecutor)driver;
    jse0.executeScript("arguments[0].click()", logoutElement1);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
    
 
    Thread.sleep(1000);
    
    
    // Record send to the SFD - Processor
    
    
	driver.findElement(By.id("TxtName")).sendKeys("60702"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick6 = new Actions(driver);
	quick6.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
	
	Select bucket5 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket5.selectByVisibleText("Case");  //Click on case object
	
	
	
	Thread.sleep(1000);
    JavascriptExecutor js6 =(JavascriptExecutor)driver;
    js6.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
    
    
    driver.findElement(By.xpath("//option[@value='56']")).click(); // Select My Leads view
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
  Thread.sleep(2000);
    driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
    //Click on the record
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
    
    driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
    Thread.sleep(1000);
    WebElement ddown1 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
    Select SM6 = new Select(ddown1);
    SM6.selectByVisibleText("Accept");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/button")).click(); // Click on OK in POP up
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    //logout
    
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement7=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    Thread.sleep(1000);
    JavascriptExecutor jse6= (JavascriptExecutor)driver;
    jse6.executeScript("arguments[0].click()", logoutElement7);

    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
//    
    
    // Record send to the SFD - Supervisor
    
    
    
    driver.findElement(By.id("TxtName")).sendKeys("62451"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick7 = new Actions(driver);
	quick7.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
	
	Select bucket8 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket8.selectByVisibleText("Case");  //Click on case object
	
	
	
	Thread.sleep(1000);
    JavascriptExecutor js4 =(JavascriptExecutor)driver;
    js4.executeScript("window.scrollBy(0,1100)", " "); //Move Down the page
    
    Thread.sleep(1000);
    WebElement ddown8 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
    Select SM7 = new Select(ddown8);
    SM7.selectByVisibleText("Assigned to Department"); // Select Assigned to Department in drop down
    
   
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
    Thread.sleep(4000);
    driver.findElement(By.xpath("//label[@for='checkbox0']")).click();// select the lead
    driver.findElement(By.xpath("//i[@title='Self Assign Cases']")).click();// Click on Self assign button
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click(); // Click on OK in pop up
   Thread.sleep(1000);
   
   Thread.sleep(1000);
    WebElement ddown9 = driver.findElement(By.xpath("//select[@name='QueryViewId']")); // Select Document Classification drop down
    Select SM8 = new Select(ddown9);
    SM8.selectByVisibleText("Assigned to Me");   // Select Assigned to Me in drop down
    
    
    driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click(); // Click on arrow
  Thread.sleep(2000);
    driver.findElement(By.cssSelector("#home-page > div.react-form.form > div > div > div > div > div:nth-child(2) > div > div > div > div > div > div > div.tableWrapper.overflow-y-hidden.flex > div > div.customViewGrid.crm-table__body.overflow-auto.scroll.grid-without-actions > div:nth-child(1) > div > div.react-grid-Main > div > div:nth-child(2) > div > div > div:nth-child(2) > div:nth-child(1) > div.react-grid-Row.react-grid-Row--even > div:nth-child(1) > div > div > span > a > span") ).click();// select the lead
    //Click on the record
    Thread.sleep(1000);
    driver.findElement(By.xpath("//i[@class='icon icon-edit']")).click(); // Click on edit button
    
    driver.findElement(By.xpath("//select[@name='cust_512']")).click(); // Click on dropdown
    Thread.sleep(1000);
    WebElement ddown11 = driver.findElement(By.xpath("//select[@name='cust_512']")); // Select Accept in drop down
    Select SM11 = new Select(ddown11);
    SM11.selectByVisibleText("Accept");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
    
    Thread.sleep(2000);
  
    
	}	

}
