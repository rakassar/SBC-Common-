package cases;



import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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

/**
 * @author Rohin Saini
 * SSC: Bank Initiated Case
 */
public class ETB_SBC_BankInitiatedMaintenanceIndividualCaseJourney_G7_IndividualCaseJourney implements Properties
{
	@Test
	public void individualCaseJourney() throws InterruptedException {

	//	String baseUrl="https://sbcdev.crmnext.com/accg7/app/login/login";
	//	String driverPath="D:\\Ashish\\Projects\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
    	WebDriver driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   //     String baseUrl = "https://sbcdev.crmnext.com/sn/app/login/login";
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        
        driver.get(URL);    
        
    	//driver.manage().deleteAllCookies();
    
    
   //     String baseUrl = "https://sbcdev.crmnext.com/sn/app/login/login";
     
      WebElement username=driver.findElement(By.id("TxtName"));
      WebElement password=driver.findElement(By.id("TxtPassword"));
      
      username.sendKeys("100181");
      password.sendKeys("acid_qa");
      driver.findElement(By.name("command")).click();
//      Thread.sleep(3000);
      //Click Quick Links and Go to Customer Search
      
      Actions quick = new Actions(driver);
      quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
//      Thread.sleep(3000);
      
      driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();
      System.out.println("Click Quick Links");
//      Thread.sleep(3000);
      
      //Customer Search Landing Page

      System.out.println("Customer Search Landing Page");
    
      WebElement inputbbn=driver.findElement(By.name("100000012"));
      inputbbn.sendKeys("25600000469"); //14300000797
      System.out.println("BBN Entered");
      driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click();
      Thread.sleep(2000);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='checkbox0']")));
      driver.findElement(By.xpath("//label[@for='checkbox0']")).click();
      Thread.sleep(3000);
      
      
      driver.findElement(By.xpath("//a[@title='Next']")).click();
    
//      Thread.sleep(2000);
      js.executeScript("window.scrollBy(0,1000)","" );
      driver.findElement(By.xpath(" //a[@data-autoid='WidgetActionButton']")).click(); //gold 7
      System.out.println("Click on Fetch Button");
      
      System.out.println("Customer 360 Landing Page");
      
     
      driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
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

//   driver.switchTo().window(mainWindowHandle);
   wait.until(ExpectedConditions.presenceOfElementLocated(By.name("CASE_SUBCATEGORY1")));
     WebElement SUBCategroy=driver.findElement(By.name("CASE_SUBCATEGORY1"));
     SUBCategroy.sendKeys("Bank Initiated Info Maintenance");
     Thread.sleep(1000);
     SUBCategroy.sendKeys(Keys.ARROW_DOWN);
     SUBCategroy.sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click();
     
     Thread.sleep(1000);
     Select TaxExce = new Select(driver.findElement(By.name("cust_2059")));
     Thread.sleep(2000);
     TaxExce.selectByVisibleText("Yes");
     Thread.sleep(2000);
     System.out.println("Select Tax Exemption Value.");
     
     WebElement ReasonforTag=driver.findElement(By.name("cust_870"));
     ReasonforTag.sendKeys("This is Reason");
     WebElement DetailsofC=driver.findElement(By.name("cust_878"));
    DetailsofC.sendKeys("This is Details");
     WebElement Remarks1=driver.findElement(By.name("cust_471"));
     Remarks1.sendKeys("This is Remarks1");
     
     
// driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click(); // gold 5.5
     driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // gold 7
   
     System.out.println("Save Case.");
     Thread.sleep(2000);

     //     driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div/div/i")).click(); //Gold 5.5
      driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click(); 
     System.out.println("Click Custom Action Button");
//     driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div[2]/div[2]/div/a[2]/i")).click();//gold 5.5
   
     driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons wt-16')]/a[2]")).click();
     System.out.println("Click Perform CRRSC");
     //CRRSC Page
     Select CRRSC1	= new Select(driver.findElement(By.name("cust_2680")));
     CRRSC1.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC2	= new Select(driver.findElement(By.name("cust_2681")));
     CRRSC2.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC3	= new Select(driver.findElement(By.name("cust_2682")));
     CRRSC3.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC4	= new Select(driver.findElement(By.name("cust_2683")));
     CRRSC4.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC5	= new Select(driver.findElement(By.name("cust_2684")));
     CRRSC5.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC6	= new Select(driver.findElement(By.name("cust_2686")));
     CRRSC6.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC7	= new Select(driver.findElement(By.name("cust_2688")));
     CRRSC7.selectByVisibleText("No");
     Thread.sleep(2000);
     
     //Customer Details
     Select CRRSC8	= new Select(driver.findElement(By.name("cust_2689")));
     CRRSC8.selectByVisibleText("Employed");
     Thread.sleep(2000);
     
     WebElement IndustryClass=driver.findElement(By.name("cust_2709"));
     IndustryClass.sendKeys("CAFETERIAS");
     Thread.sleep(2000);
     IndustryClass.sendKeys(Keys.ARROW_DOWN);
     IndustryClass.sendKeys(Keys.ENTER);
     Thread.sleep(2000);
     
     Select CRRSC9	= new Select(driver.findElement(By.name("cust_2691")));
     CRRSC9.selectByVisibleText("No");
     Thread.sleep(2000);
     
     Select CRRSC10	= new Select(driver.findElement(By.name("cust_2692")));
     CRRSC10.selectByVisibleText("No");
     Thread.sleep(2000);
    
     
     //Geo Graphical
     WebElement Residence=driver.findElement(By.name("cust_1733"));
     Residence.sendKeys("Aglipay");
     Thread.sleep(2000);
     Residence.sendKeys(Keys.ARROW_DOWN);
     Residence.sendKeys(Keys.ENTER);
     Thread.sleep(2000);
     
     Select CRRSC11	= new Select(driver.findElement(By.name("cust_2699")));
     CRRSC11.selectByVisibleText("Yes");
     Thread.sleep(2000);
     
     //CRRSC KYC 
     Select CRRSC12	= new Select(driver.findElement(By.name("cust_2700")));
     CRRSC12.selectByVisibleText("Yes");
     Thread.sleep(2000);
     
     Select CRRSC13	= new Select(driver.findElement(By.name("cust_2701")));
     CRRSC13.selectByVisibleText("Yes");
     Thread.sleep(2000);

     Select CRRSC14	= new Select(driver.findElement(By.name("cust_2702")));
     CRRSC14.selectByVisibleText("Yes");
     Thread.sleep(2000);
     
     Select CRRSC15	= new Select(driver.findElement(By.name("cust_2703")));
     CRRSC15.selectByVisibleText("Yes");
     Thread.sleep(2000);
     
     Select CRRSC16	= new Select(driver.findElement(By.name("cust_2704")));
     CRRSC16.selectByVisibleText("Yes");
     Thread.sleep(2000);
     
    WebElement CRRSCRemarks= driver.findElement(By.name("cust_2705"));
    CRRSCRemarks.sendKeys("Remarks Full Fill");
    Thread.sleep(2000);
    System.out.println("Remarks FIlled");
    
    driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
    Thread.sleep(2000);
    System.out.println("Save CRRSC");
    
    WebElement caseID=driver.findElement(By.xpath("//div[@class='summaryband__item flex items-center']/div/div/div/span[@data-autoid='CASE_NUMBER_ctrl']"));
    String caseIDCreated=caseID.getText();
// List<WebElement> caseID1=driver.findElements(By.xpath("//span[@data-autoid='CASE_NUMBER_ctrl']"));
//    Stream<String> caseID=caseID1.stream().map(s->s.getText()).limit(1);
//    caseID.forEach(s->System.out.println("Created Case is: "+s));
// 
//    
//    String caseIDcasting=caseID;
    
    
    //Case Page Closed
    Thread.sleep(2000);
  // 	  driver.switchTo().window(parentWindow);    
    driver.switchTo().window(mainWindowHandle);

    
 //   driver.navigate().refresh();
   //Logout
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img")));
    WebElement logoutElement=driver.findElement(By.xpath("//div[contains(@class,'header__item header__profile')]/a/img"));
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    jse.executeScript("arguments[0].click()", logoutElement);
//    driver.findElement(By.id("header_usericon")).click()
    Thread.sleep(2000);
    System.out.println("Clicked on right Top cornor for logout");
    
   // driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
    driver.findElement(By.xpath("//a[@title='Logout']")).click();
    Thread.sleep(2000);
    System.out.println("Logout Successfully");
        
        
        driver.findElement(By.name("UserName")).sendKeys("206578");
    	Thread.sleep(2000);
        driver.findElement(By.name("SecureTextBox.Text")).sendKeys("acid_qa");
       // Thread.sleep(2000);
        driver.findElement(By.name("command")).click();
       // Thread.sleep(3000);
        System.out.println("BBOG CDC(Maintenance Analyist Successfull Login");
        
        driver.findElement(By.className("icon-service")).click();
        System.out.println("Click Service");
       // Thread.sleep(5000);
        
        driver.findElement(By.className("icon-obj9")).click();
        System.out.println("Click Cases");
     //   Thread.sleep(3000);
        System.out.println("Cases Home Page Open");
        
     // This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("QueryViewId")));
       // driver.navigate().refresh();
    Select View = new Select(driver.findElement(By.name("QueryViewId")));
 //   driver.navigate().refresh();
    
        View.selectByVisibleText("Assigned to Department");
//Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='filterGroup__button acid-btn acid-btn--outline-brand']")).click();
        

//     String CaseIDStage1=caseIDcasting;
       String CaseActual=caseIDCreated.replaceFirst("^0+(?!$)", "");
        List<WebElement> caseSelectiNmyBucket=driver.findElements(By.xpath("//div[@class='react-grid-Cell']"));
        for(int i=0;i<caseSelectiNmyBucket.size();i++)
        {
        	String caseID2=caseSelectiNmyBucket.get(i).getText();
        	if(caseID2.equals(CaseActual))
        	{
     		
				driver.findElement(By.cssSelector(".react-grid-Cell.react-grid-Cell--frozen.rdg-last--frozen")).click();
				System.out.println("Checkbox against cases is selected");
        		break;
        	}
        }
        
        
        driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
      System.out.println("Clicked on Custom Action Button in Customer 360");

   List<WebElement> cust350CustumButtonView=driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link"));
      for(int i=0;i<cust350CustumButtonView.size();i++)
      {
      	String customActionButtonList =cust350CustumButtonView.get(i).getText();
      	if(customActionButtonList.equalsIgnoreCase("Self assign cases"))
      	{
      		//driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link")).get(i).click();
      		cust350CustumButtonView.get(i).click();
      		System.out.println("Self Assigned Successfully");
      		break;
      		 
      	}
      }
driver.navigate().refresh();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-autoid='QueryViewId_ctrl']")));
Select view1=new Select(driver.findElement(By.xpath("//select[@data-autoid='QueryViewId_ctrl']")));
view1.selectByValue("56");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-grid-Row react-grid-Row--even']/div[@class='react-grid-Cell']")));
   //   driver.findElement(By.xpath("//div[@class='react-grid-Row react-grid-Row--even']/div[@class='react-grid-Cell']")).click();
     // System.out.println("Click Case ID");
      
      List<WebElement> caseAssignedToMe= driver.findElements(By.xpath("//div[@class='react-grid-Row react-grid-Row--even']/div[@class='react-grid-Cell']"));
     
      for(int i=0;i<caseAssignedToMe.size();i++)
      {
    	  String editCaseID=caseAssignedToMe.get(i).getText();
    	  if(editCaseID.equals(caseIDCreated))
    	  {
    		  driver.findElement(By.xpath("//div[@class='react-grid-Row react-grid-Row--even']/div[@class='react-grid-Cell']")).click();
    		  System.out.println("Click Case ID");
    		  break;
    		  }
      }
      
      
      
      driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
  System.out.println("Clicked on Custom Action Button in Customer 360");
//Code of clicking on Edit button against case
 List<WebElement> cust350CustumButtononCase=driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link"));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mb-24.flex.items-center.acd-link")));
    for(int i=0;i<cust350CustumButtononCase.size();i++)
    {
    	String customActionButtonList =cust350CustumButtononCase.get(i).getText();
    	if(customActionButtonList.equalsIgnoreCase("Edit"))
    	{
    		//driver.findElements(By.cssSelector(".mb-24.flex.items-center.acd-link")).get(i).click();
    		cust350CustumButtononCase.get(i).click();
    		System.out.println("Case Opened in Edit Mode");
    		break;
    		 
    	}
    }

        
    Select Department = new Select(driver.findElement(By.xpath("//select[@name='cust_512']")));
    Thread.sleep(2000);
    Department.selectByVisibleText("Accept");
    System.out.println("Seelct Department Decision");
    Thread.sleep(3000);
    
    driver.findElement(By.name("cust_471")).sendKeys("Remarks by Processor");
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
    System.out.println("Click Save and Proceed Button");
	
//	driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
//  Thread.sleep(2000);
//  System.out.println("Logout Successfully");

    

}

}