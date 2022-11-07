/**
 * 
 */
package cases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 * @author Ashish Singh
 *
 */
public class EtbJourney1  implements Properties
{

	
	@Test
	public void individualEtbJourney() throws InterruptedException
	{
		
	//	String baseUrl="https://sbcdev.crmnext.com/sn/app/login/login";
//		String baseUrl="https://sbcdev.crmnext.com/accg7/app/login/login";
//		String driverPath="D:\\Ashish\\Projects\\Automation\\Drivers\\chromedriver_win32\\chromedriver.exe";	
		String uname="100082";
		String pwd="acid_qa";
		String expectedTitle = "CRMnext - Smart.Easy.Complete";
		String actualLeadUrl="https://sbcdev.crmnext.biz/sn/app/CRMNextObject/Home/Lead";
		//String bbn="46300000798";
		String ActualleadDetailPageTitle="Individual Onboarding";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(URL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//System.out.println("Browser launch successfully and App is also launched");
		
		driver.findElement(By.xpath("//input[@id='TxtName']")).sendKeys(uname);
		System.out.println("Entered Username");
		
		driver.findElement(By.xpath("//*[@id=\"TxtPassword\"]")).sendKeys(pwd);
		System.out.println("Entered Password");
		
		driver.findElement(By.xpath("//*[@id=\"registration\"]/input")).click();
		System.out.println("Clicked on Login Button");
		//Thread.sleep(5000);
		
		String actualTitle=driver.getTitle();
		System.out.println("Actual Title is:" +actualTitle);
		//Thread.sleep(2000);
	
		if((actualTitle).equalsIgnoreCase(expectedTitle))
		{
			
			System.out.println("Login Successfully");
			
		}
		else
			
		{
		System.out.println("Unable to login into the application");	
		}		
	//	WebElement ele = driver.findElement(By.xpath("//*[@id=\"js-vnav\"]/li[2]/div/div/a/i"));
		
		WebElement ele = driver.findElement(By.xpath("//span[@title='Sales']/parent::div"));
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Sales']/parent::div")));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		System.out.println("Mouse Hower on Sales Management");
		
		WebElement ele2=driver.findElement(By.xpath("//span[@title='Leads']/parent::a"));
		action.moveToElement(ele2).build().perform();
		ele2.click();
		System.out.println("Mouse Hover and click on Lead Object");
		//Thread.sleep(2000);
		String expectedLeadUrl=driver.getCurrentUrl();
		//Thread.sleep(2000);
		System.out.println("Lead Current Url is: "+expectedLeadUrl);
		//Thread.sleep(2000);
		if((expectedLeadUrl).equalsIgnoreCase(actualLeadUrl))
				{
			System.out.println("successfully redirected to Lead Home Page");
				}
		else
		{
			System.out.println("Unable to Open Lead Home Page");
		}
		String mainjourneyWindow=driver.getWindowHandle();
	
		 System.out.println("Main Window:" +mainjourneyWindow);
		driver.findElement(By.xpath("//div[@title='click here to see more actions']")).click();
		System.out.println("Clicked on Custom Action button for starting Journey");
	    Thread.sleep(2000);
	
     
	 //   driver.findElement(By.xpath("//div[@class='overlay-button-list']//i[@title='Sales Journey']")).click();
	 //   driver.findElement(By.xpath("//span[@class='brand f16']/parent::a[@title='Sales Journey']")).click(); //Gold 5.5
     	driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons wt-16')]/a[@title=\"Sales Journey\"]")).click(); // Gold 7
	    
	    //Thread.sleep(2000);
	    System.out.println("Clicked on Sales Journey Button");
        Set <String> allwindows=driver.getWindowHandles();
        Iterator<String> i=allwindows.iterator();
        
        while(i.hasNext())
        {
        	String childWindow=i.next();
        	if(!(childWindow).equalsIgnoreCase(mainjourneyWindow))
        	{
        		driver.switchTo().window(childWindow);
        		System.out.println("Successfully switch to:" +childWindow);
        		WebElement childwin=driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]"));
        		childwin.click();
        		System.out.println("Selected Individual Journey");
        				Thread.sleep(2000);
        			//	driver.switchTo().parentFrame();
        	}
        	
        }
       driver.switchTo().window(mainjourneyWindow);
       System.out.println("Swiched to Main Window");
        Thread.sleep(5000);
        
       WebElement el2= driver.findElement(By.xpath("//input[@name='100000012']"));
       //Thread.sleep(2000);
       el2.click();
       //Thread.sleep(2000);
       el2.sendKeys("46300000798");
       System.out.println("Clicked And Entered BBN in BBN field");
       
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        System.out.println("Clicked Next Button");
        //Thread.sleep(2000);
        
        driver.findElement(By.xpath("//body//div[@id='main']//span//span[1]")).click();
        System.out.println("Clicked on BBN to Open Customer 360");
        //Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
        System.out.println("Clicked on Journey Button on Customer 360");
        //Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons')]/a[@title='Start Your Journey']")).click();//gold 5
      
      
        System.out.println("Clicked on Start Your Journey button");
        //Thread.sleep(2000);
        
        
        String secondMainWindow=driver.getWindowHandle();
        System.out.println("Second Main Window:" +secondMainWindow);
       
       // driver.findElement(By.xpath("//*[@id=\\\"newobject\\\"]/div[3]/div[2]/div[2]/div/a[1]/i")).click();
        //Thread.sleep(2000);
        Set<String> multiplewindows=driver.getWindowHandles();
        Iterator<String> anotherchildwindow=multiplewindows.iterator();
        
        while(anotherchildwindow.hasNext())
        {
        	String childsec=anotherchildwindow.next();
        	if(!(secondMainWindow).equalsIgnoreCase(childsec))
        			{
        		driver.switchTo().window(childsec);
        		WebElement startETblead=driver.findElement(By.xpath("//div[@class='screenFlowJnry__items']/div[2]"));
        				startETblead.click();
        				System.out.println("Switched to Journey Window");
        				//Thread.sleep(2000);
        			}
        }
        driver.switchTo().window(secondMainWindow);
        //Thread.sleep(2000);
        Select leadRating=new Select(driver.findElement(By.xpath("//select[contains(@name,'LE_LEADRATING')]")));
        		leadRating.selectByVisibleText("Hot");
        		System.out.println("Selected Lead Rating");
        	//	Thread.sleep(5000);
        		
        		driver.findElement(By.xpath("//span[text()='Next']")).click();
        		System.out.println("Clicked Next button in basic Information Page");
        		//Thread.sleep(2000);
        		
        Select productCategory=new Select(driver.findElement(By.xpath("//select[contains(@name,'LE_PRODUCTCATEGORY')]")));
        productCategory.selectByVisibleText("Savings");
        System.out.println("Selected Product Category");
        
        Select product=new Select(driver.findElement(By.xpath("//select[@name='LE_PRODUCT' and @data-autoid='LE_PRODUCT_ctrl']")));
        product.selectByIndex(2);
        System.out.println("Selected Product"); 
        
        WebElement pg2nxtbutton=driver.findElement(By.xpath("//span[text()='Next']"));
        pg2nxtbutton.click();
        System.out.println("Click on Next button"); 
        
           
      //  WebElement IgnoreandCreateButton=driver.findElement(By.xpath("//button[text()='Ignore and Create']"));//gold 5
        WebElement IgnoreandCreateButton=driver.findElement(By.xpath("//div[@class='footer--popup']/button[1]"));
      
		IgnoreandCreateButton.click();
		System.out.println("Ignore Lead to Lead Dedupe");
        //Thread.sleep(2000);
        String expectedLeadDetailPageTitle=driver.getTitle();
        System.out.println("Expected Title:"+expectedLeadDetailPageTitle);
        if((ActualleadDetailPageTitle).equalsIgnoreCase(expectedLeadDetailPageTitle))
        {
        	System.out.println("Lead Created Successfully");
        	/*WebElement getLeadID=driver.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div[3]/div[1]/div/div/div/span"));
        	String leadID=getLeadID.getText();
        	System.out.println("Lead ID is:"+leadID);*/
        }
        
        WebElement getLeadID=driver.findElement(By.xpath("//span[@data-autoid='LE_NUMBER_ctrl']"));
    	String leadID=getLeadID.getText();
    	System.out.println("Lead ID is:"+leadID);
        //Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
        System.out.println("Clicked on Custom Action Button in Lead Detail Page");
        
      //////span[@class='brand f16']/parent::a[@title='Edit']']']
     //   driver.findElement(By.xpath("//div[contains(@class,'overlay-button')]//child::a//child::i[@class='icon icon-edit']")).click();//Gold 5.5
        driver.findElement(By.xpath("//span[@class='brand f16']/parent::a[@title='Edit']")).click(); //Gold 7
        System.out.println("Clicked on Edit Button in Lead Detail Page");
        
        driver.findElement(By.xpath("//span[text()='Appointments and Calls']")).click();
        System.out.println("Clicked on Appointment and Call Ribbon");
        
//        driver.findElement(By.xpath("//a[@title='Today Date' and @data-autoid='cust_192_today']")).click();
//        System.out.println("Select Current Date from Calender"); 


        /*driver.findElement(By.xpath("//input[@data-autoid='cust_192_ctrl' and @mask='11:11 aa']")).click();
        System.out.println("Clicked on Time Field"); 
        Thread.sleep(2000);*/
        
       /* JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement appointmentTimeScroller=driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[1]/div/div/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/div/div"));
        js.executeScript("arguments[0].scrollIntoView();", appointmentTimeScroller);
        Thread.sleep(2000);*/
        
driver.findElement(By.id("cust_192")).click();
        
        LocalDate date=LocalDate.now().plusDays(1);// This will get the current date and add 1 more day in that
	        String dateT=date.format(DateTimeFormatter.ofPattern("d-MMMM-u"));// This will display the date in DD-MM-YYYY format
	        System.out.println(dateT);
	        String[] year=dateT.split("-"); // split method spilt the date in 3 different string
	        
	        String actualDate=year[0];
	        String actualMonth=year[1];
	        String actualYear=year[2];
	        	
	        String monthOfAppointment= actualMonth +" "+ actualYear;
	        System.out.println("YearMonth:"+monthOfAppointment);
	        System.out.println("Year:"+actualYear);
	        System.out.println("Month:"+actualMonth);
	        System.out.println("Date:"+actualDate);
	       // If(driver.findElement(By.cssSelector("span.navigation-title")).getText().contains(monthOfAppointment));
	       // {
	        List<WebElement> appointmentDate=driver.findElements(By.xpath("//div[contains(@class,'input-calendar-wrapp')]/child::div/div[3]/div"));
	       int count=appointmentDate.size();
	        for(int ite=0;ite<count;ite++)
	        {
	        	 
	             
	        	//WebElement ate=appointmentDate.get(ite);
	        	String num=driver.findElements(By.xpath("//div[contains(@class,'input-calendar-wrapp')]/child::div/div[3]/div")).get(ite).getText();
	        	
	        	if(num.equals(actualDate))
	        	{
	        		driver.findElements(By.xpath("//div[contains(@class,'input-calendar-wrapp')]/child::div/div[3]/div")).get(ite).click();
	        	break;
	        	}
	        }
	        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-autoid='cust_192_ctrl' and @mask='11:11 aa']")));
       WebElement selectTimeWebelement= driver.findElement(By.xpath("//input[@data-autoid='cust_192_ctrl' and @mask='11:11 aa']"));
       selectTimeWebelement.click();
       selectTimeWebelement.sendKeys("11:50 AM");
      System.out.println("Entered Time");
       
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save and proceed']")));
        driver.findElement(By.xpath("//span[text()='Save and proceed']")).click();
        System.out.println("Click on Save and Proceed button after appointment Fixed");
        
        driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
        System.out.println("Click on Custom Action Button");
        
        driver.findElement(By.xpath("//span[@class='brand f16']/parent::a[@title='Edit']")).click();
        Thread.sleep(2000);
        System.out.println("Click on Edit button in Lead Detail Page");
        
        driver.findElement(By.xpath("//span[text()='Documents Collection']")).click();
        System.out.println("Click on Document Collection Ribbon");
         
        JavascriptExecutor js = (JavascriptExecutor)driver;
       // WebElement appointmentTimeScroller=driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[1]/div/div/div[2]/div[1]/div/div/div[3]/div[2]/div/div/div/div[2]/div/div/div/div/div"));
        js.executeScript("window.scrollBy(0,1000)","");
        Thread.sleep(2000);
        Select isSoleOwnwer= new Select( driver.findElement(By.xpath("//select[@name='cust_162']")));
        System.out.println("Scrolled Window Till IsSole Owner field");
      //  driver.findElement(By.xpath(IssoleOwner)).click();
        
        isSoleOwnwer.selectByVisibleText("Yes");
        Thread.sleep(2000);
        System.out.println("Selected Yes in IsSole Owner field");
        
        js.executeScript("window.scrollBy(0,500)","");
        WebElement businessName=driver.findElement(By.xpath("//input[contains(@name,'cust_494')]"));
        businessName.sendKeys("CRMNEXT");
        System.out.println("Scroll Window till Business Name field");
        Thread.sleep(2000);
        
        Select isemployment= new Select(driver.findElement(By.xpath("//select[@name='cust_2353']")));
        Thread.sleep(2000);
        isemployment.selectByIndex(2);
        Thread.sleep(2000);
        System.out.println("Select Yes in For Employment field");
        //boolean tinPresentNow=driver.findElement(By.)
        
        
        driver.findElement(By.xpath("//input[@name='cust_86']")).sendKeys("73667286286");
        System.out.println("Entered TIN");
        
        js.executeScript("window.scrollBy(0,300)","");
        driver.findElement(By.xpath("//a[@title='Search' and @data-autoid='cust_467_srch']")).click();
        System.out.println("Click on Primary ID field");
   
        driver.findElement(By.xpath("//input[@name='Grid_SearchTextBox']")).sendKeys("Driver");
        System.out.println("Entered Driver in Search box");
        
        driver.findElement(By.xpath("//a[@data-autoid='gridHF_cust_467']")).click();
        System.out.println("Click Search button In Order to Search the Driving License from the list");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//div[starts-with(@title,'Driver')]")).click();
        System.out.println("Select Driving License as First ID proof");
        
        driver.findElement(By.xpath("//input[contains(@name,'cust_90')]")).sendKeys("76757664765");
        System.out.println("Entered Driving License Number");
        
        driver.findElement(By.xpath("//span[text()='Save and proceed']")).click();
        System.out.println("Click on Save and Proceed button after appointment Fixed"); 
        
        driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
        System.out.println("Click on Custom Action Button");
        
        Thread.sleep(2000);
       // WebElement clickPerformCRRSC=driver.findElement(By.xpath("//div[contains(@class,'overlay-button-list')]//child::a[@title='Perform CRRSC']//child::i']"));
        js.executeScript("window.scrollBy(0,500)","");
       
//        WebElement clickPerformCRRSC=driver.findElement(By.xpath(" //div[@class='overlay-button-list']//i[@class='icon icon icon-screenflow']"));gold 5.5
        WebElement clickPerformCRRSC=driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons wt-16 bg-white')]/child::a[2]"));
     
       
      
        clickPerformCRRSC.click();
        System.out.println("Clicked Perform CRRSC button");
        
        Select isCustomerBenefactorInOFACCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1699']")));
        isCustomerBenefactorInOFACCRRSC.selectByVisibleText("No");
        System.out.println("Question 1: Is the customer, beneficiary, benefactor included in OFAC / AMLC / UN / JMOF Sanction List?");
        System.out.println("Selected CRRSC Question 1: No");
        
        Select isCustomerinBankWatchlistOneCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1700']")));
        isCustomerinBankWatchlistOneCRRSC.selectByVisibleText("No");
        System.out.println("Question 2: Is the customer, beneficiary or benefactor included in the Bank's Internal Watchlist 1 (Convicted or Restricted) ?\r\n");
        System.out.println("Selected CRRSC Question 2: No");
        
        Select isCustomerinBankWatchlistTwoCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1701']")));
        isCustomerinBankWatchlistTwoCRRSC.selectByVisibleText("No");
        System.out.println("Question 3: Is the customer, beneficiary or benefactor included in the Bank's Internal Watchlist 2 (Alleged or Person of Interest) ?\r\n");
        System.out.println("Selected CRRSC Question 3: No");
        
        js.executeScript("window.scrollBy(0,510)","");
        
        Select isCustomerBenefatcorHPICRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1702']")));
        isCustomerBenefatcorHPICRRSC.selectByVisibleText("No");
        System.out.println("Question 4: Is the customer, beneficiary, benefactor an HPI, publicly declared known to be related or closely associated to an HPI OR a joint accountholder of an existing customer rated as High Risk");
        System.out.println("Selected CRRSC Question 4: No");
        
        
        Select isCustomerBenefatcorOFWCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1703']")));
        isCustomerBenefatcorOFWCRRSC.selectByVisibleText("No");
        System.out.println("Question 5: Is the customer, beneficiary or benefactor an OFW?");
        System.out.println("Selected CRRSC Question 5: No");
        
        
        Select isCustomerForeignNationalsCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_2427']")));
        isCustomerForeignNationalsCRRSC.selectByVisibleText("No");
        System.out.println("Question 6: Is the customer a Foreign National?");
        System.out.println("Selected CRRSC Question 6: No");
        
        
        Select isCustomerNumberAccCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1706']")));
        isCustomerNumberAccCRRSC.selectByVisibleText("No");
        System.out.println("Question 7: Is the customer opening a Numbered Account?");
        System.out.println("Selected CRRSC Question 7: No");
        
        
        Select isEmploymentTypeCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1169']")));
        isEmploymentTypeCRRSC.selectByVisibleText("Employed");
        System.out.println("Question 8: Employment Type");
        System.out.println("Selected CRRSC Question 8: No");
        
        js.executeScript("window.scrollBy(0,500)",""); 
        
       driver.findElement(By.xpath("//a[@data-autoid='cust_2444_srch']")).click();
       System.out.println("Clicked on Industry Search button");
       
       WebElement searchIndustryElement= driver.findElement(By.xpath("//input[@name='Grid_SearchTextBox']"));
       searchIndustryElement.sendKeys("INTELLECTUAL PROPERTY RESEARCH AND DOCUMENTATION ACTIVITIES");
       System.out.println("Entered Text in Seach Box");
       
       driver.findElement(By.xpath("//a[@data-autoid='gridHF_cust_2444']")).click();
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("//div[@data-autoid='Level2_0']")).click();
       System.out.println("Question 9: Kindly specify the Industry where the customer is affiliated to");
       System.out.println("Selected CRRSC Question 9: No");
       
       
       
       WebElement riskassociatedCRRSC=driver.findElement(By.xpath("//select[@name='cust_1710']"));
       System.out.println("Risk After Industry Selection Was:"+riskassociatedCRRSC.getText());
       
       
       Select isHESHEMangerialCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1708']")));
       isHESHEMangerialCRRSC.selectByVisibleText("No");
       System.out.println("Question 9: Is he / she the owner or in a senior managerial decision making position?");
       System.out.println("Selected CRRSC Question 9: No");
       
       
       Select isSHEDirectDealwithClientCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1709']")));
       isSHEDirectDealwithClientCRRSC.selectByVisibleText("No");
       System.out.println("Question 10: Does he/she have direct dealing with clients?");
       System.out.println("Selected CRRSC Question 10: No");
       
      
       js.executeScript("window.scrollBy(0,300)",""); 
	
        
       driver.findElement(By.xpath("//a[@data-autoid='cust_1520_srch']")).click();
       
       WebElement searchCityOfResidenceElement1CRRSC= driver.findElement(By.xpath("//input[@data-autoid='Grid_SearchTextBox_ctrl']"));
       searchCityOfResidenceElement1CRRSC.sendKeys("Aborlan");
       driver.findElement(By.xpath("//a[@data-autoid='gridHF_cust_1520']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@data-autoid='CityName_0']")).click();
       System.out.println("Question 11: Please select City of Residency/Work");
       System.out.println("Selected CRRSC Question 11: No");
      

       Select isCustomerResidingInsameVicinitySelectCRRCS = new Select(driver.findElement(By.xpath("//select[@name='cust_1717']")));
       isCustomerResidingInsameVicinitySelectCRRCS.selectByVisibleText("Yes");
       System.out.println("Question 12: Is the customer residing or working within the vicinity of the branch or is the branch accessible by ordinary transportation, such that transporting/withdrawing deposits is practical/ not too risky?");
       System.out.println("Selected CRRSC Question 12: Yes");
      
       js.executeScript("window.scrollBy(0,300)","");
       
       Select isInitialDepositCRRSCSelectCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1720']")));
       isInitialDepositCRRSCSelectCRRSC.selectByVisibleText("Yes");
       System.out.println("Question 13: Is initial deposit and type of product aligned with the customer profile?");
       System.out.println("Selected CRRSC Question 13: Yes");
       
       
       Select areThereExpectedInwardSelectCRRCS = new Select(driver.findElement(By.xpath("//select[@name='cust_1721']")));
       areThereExpectedInwardSelectCRRCS.selectByVisibleText("Yes");
       System.out.println("Question 14: Are there expected inward/outward remittances(within or outside the Phils.)?");
       System.out.println("Selected CRRSC Question 14: Yes");
       Thread.sleep(2000);
       
       Select isItAlignedWithCustomerSourceSelectCRRCS = new Select(driver.findElement(By.xpath("//select[@name='cust_2032']")));
       isItAlignedWithCustomerSourceSelectCRRCS.selectByVisibleText("Yes");
       System.out.println("Question 15: Is it aligned with the customer's declared source of funds?");
       System.out.println("Selected CRRSC Question 15: Yes");
       
       Select areYouComfortableWithCustomerInfoSelectCRRCS = new Select(driver.findElement(By.xpath("//select[@name='cust_1722']")));
       areYouComfortableWithCustomerInfoSelectCRRCS.selectByVisibleText("Yes");
       System.out.println("Question 16: Are you comfortable with the customer based on information provided");
       System.out.println("Selected CRRSC Question 16: Yes");
       
       
       Select areYouComfortableWithCustomerDocSelectCRRSC = new Select(driver.findElement(By.xpath("//select[@name='cust_1723']")));
       areYouComfortableWithCustomerDocSelectCRRSC.selectByVisibleText("Yes");
       System.out.println("Question 17: Are you comfortable with the customer based on documents presented");
       System.out.println("Selected CRRSC Question 17: Yes");
       
      WebElement remarkCRRSC= driver.findElement(By.xpath("//textarea[@name='cust_2430']"));
      remarkCRRSC.sendKeys("Test Automated CRRSC Remarks");
      System.out.println("Entered remarks of CRRSC");
      
       driver.findElement(By.xpath("//a[@class='acd-btn acd-btn--brand mh-8 ']")).click();
       System.out.println("CRRSC Done");
       
       driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
       System.out.println("Click on Custom Action Button");
    
      driver.findElement(By.xpath("//span[@class='brand f16']/parent::a[@title='Edit']")).click();
       
      js.executeScript("window.scrollBy(0,300)","");
       
       driver.findElement(By.xpath("//span[text()='Save and proceed']")).click();
       System.out.println("Click on Save and Proceed button after appointment Fixed");
       
       driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
       System.out.println("Click on Custom Action Button");
    
//       driver.findElement(By.xpath("//div[@class='overlay-button-list list-scroll']//child::a[@title='Fill Account Information']")).click();
 //      driver.findElement(By.xpath("//div[contains(@class,'overlay-button-list')]//child::a//child::i[@class='icon icon icon-screenflow']")).click(); // Gold 5.5
       driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons wt-16 bg')]/a[1]")).click();
       
     
       System.out.println("Clicked on Fill Account Information Button");
       Thread.sleep(2000);
       Select requestTypeSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_1318']")));
       requestTypeSelect.selectByVisibleText("EVERYDAY MASTERCARD DEBIT/ATM CARD");
       System.out.println("Selected EVERYDAY MASTERCARD DEBIT/ATM CARD As Request Type");
       
       Select pureposeOfAccountOpeningSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_497']")));
       pureposeOfAccountOpeningSelect.selectByVisibleText("Business Transactions");
       System.out.println("Selected Business Transactions As Purpose of Account Opening");
       
       js.executeScript("window.scrollBy(0,500)","");
       
       WebElement adbRequiredElement=driver.findElement(By.xpath("//input[@data-autoid='cust_92_ctrl']"));
       adbRequiredElement.sendKeys("1000");
       System.out.println("Entered Amount in ADB");
       
       js.executeScript("window.scrollBy(0,500)","");
       
       Select productPromoEmailSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_1185']")));
       productPromoEmailSelect.selectByVisibleText("Yes");
       System.out.println("Selected Yes in Products / Promos (Email)");
       
       Select productPromoSmsSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_74']")));
       productPromoSmsSelect.selectByVisibleText("Yes");
       System.out.println("Selected Yes in Products / Promos (SMS)");
       
       Select transactionalSmsSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_107']")));
       transactionalSmsSelect.selectByVisibleText("Yes"); 
       System.out.println("Selected Yes in Transactional (SMS)");
       
       Select transactionalEmailSelect = new Select(driver.findElement(By.xpath("//select[@name='cust_85']")));
       transactionalEmailSelect.selectByVisibleText("Yes"); 
       System.out.println("Selected Yes in Transactional (EMAIL)");
       
       
       driver.findElement(By.xpath("//a[@data-autoid='FlowFinish']")).click();
       System.out.println("Clicked on Finish Button");
       
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[contains(@title,'click here to see more actions')]")).click();
       System.out.println("Click on Custom Action Button");
       
       
  //  driver.findElement(By.xpath("//*[@id=\\\"newobject\\\"]/div[3]/div[2]/div[2]/div/a[2]/i")).click();  
       driver.findElement(By.xpath("//div[contains(@class,'stack-action-buttons wt-16 bg')]/a[2]")).click();
       Set<String> Window = driver.getWindowHandles();
       Iterator<String> LW = Window.iterator();
       String W1 = LW.next();
       String W2 = LW.next();

       driver.switchTo().window(W2);
       driver.findElement(By.name("m$bs$bc")).click();

       driver.switchTo().window(W1);

       System.out.println("lead id = " + driver
               .findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div[3]/div[1]/div/div/div/span")).getText());
       
     //driver.quit();
       
	}
}
