//package (default package);

/**
 * 
 */



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Bank_Initiated {

	/**
	 * @author Rohin Saini
	 *
	 */

	public static void main(String[] args) throws InterruptedException {
	    	System.setProperty("webdriver.chrome.driver","D:\\Rohin Data\\Personal_Rohin\\Automation KIT\\chromedriver_win32\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        String baseUrl = "https://sbcdev.crmnext.com/sn/app/login/login";
	        driver.get(baseUrl);
	        WebElement username=driver.findElement(By.id("TxtName"));
	        WebElement password=driver.findElement(By.id("TxtPassword"));
	        
	        username.sendKeys("100181");
	        password.sendKeys("acid_qa");
	        driver.findElement(By.name("command")).click();
	        Thread.sleep(3000);
	        //Click Quick Links and Go to Customer Search
	        
	        Actions quick = new Actions(driver);
	        quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();
	        System.out.println("Click Quick Links");
	        Thread.sleep(3000);
	        
	        //Customer Search Landing Page

	        System.out.println("Customer Search Landing Page");
	      
	        WebElement inputbbn=driver.findElement(By.name("100000012"));
	        inputbbn.sendKeys("14300000797");
	        driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click();
	        Thread.sleep(2000);
	        
	        //Select Radio Button
	        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div/div/div/div/div[10]/div/div/span/div/label")).click();
	        Thread.sleep(2000);
	        
	        
	        //Click Next 
	        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div[2]/a")).click();
	        Thread.sleep(2000);
	        
	        //Click View Customer
	        driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();
	        System.out.println("Customer 360 Landing Page");
	        
	        //Click Start Journey Button
	        driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div/div/i")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div[2]/div[2]/div/a[2]")).click();
	        Thread.sleep(2000);
	        
	     //   driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/a"));
	       // Thread.sleep(2000);
	        
	      //Get handles of the windows
	        String mainWindowHandle = driver.getWindowHandle();
	        //driver.findElement(By.linkText("Start Your Journey")).click();
	        Thread.sleep(3000);
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator=	allWindowHandles.iterator();
	        System.out.println("Handle Child Windows");
	        //    Iterator<String> iterator = allWindowHandles.iterator();
	      //  Iterator<String> anotherchildwindow=allWindowHandles.iterator();

	        while (iterator.hasNext()) 
	        {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
	                {
	                driver.manage().window().maximize();
	                driver.switchTo().window(ChildWindow);
	                Thread.sleep(2000);
	                WebElement CustomerService = driver.findElement(By.xpath("//*[@id=\"2\"]"));
	           //     System.out.println("Heading of child window is " + text.getText());
	                CustomerService.click();	
	                }    
	        }

	      //  WebElement Category = driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/div/div/a[2]")).click();
	       WebElement SUBCategroy=driver.findElement(By.name("CASE_SUBCATEGORY1"));
	       SUBCategroy.sendKeys("Bank Initiated Info Maintenance");
	       Thread.sleep(1000);
	       SUBCategroy.sendKeys(Keys.ARROW_DOWN);
	       SUBCategroy.sendKeys(Keys.ENTER);
	       Thread.sleep(1000);
	       driver.findElement(By.className("button-icon-text")).click();
	       System.out.println("Fill SSC");
	     //  Thread.sleep(1000);
	    //   Select CRRSCValue = new Select(driver.findElement(By.name("cust_2713")));
	    //   CRRSCValue.selectByVisibleText("Yes");
	       Thread.sleep(1000);
	       Select TaxExce = new Select(driver.findElement(By.name("cust_2059")));
	       TaxExce.selectByVisibleText("Yes");
	       Thread.sleep(2000);
	       System.out.println("Select Tax Exemption Value.");
	       
	       WebElement ReasonforTag=driver.findElement(By.name("cust_870"));
	       ReasonforTag.sendKeys("This is Reason");
	       WebElement DetailsofC=driver.findElement(By.name("cust_878"));
	       DetailsofC.sendKeys("This is Details");
	       WebElement Remarks1=driver.findElement(By.name("cust_471"));
	       Remarks1.sendKeys("This is Remarks1");
	       
	       
	       driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
	       System.out.println("Save Case.");
	       Thread.sleep(2000);
	       //String Case_value = driver.findElement(By.className("f13")).getAttribute("value");
	       //System.out.println("Case Detail."+ driver.findElement(By.className("f13")).getText());
	       WebElement getCaseID=driver.findElement(By.className("f13"));
	        String CaseID=getCaseID.getText();
	        System.out.println("Case ID is:"+CaseID);
	      // WebElement CaseID = driver.findElement(By.className("f13"));
	       //CaseID.getText();
	       //System.out.println("Case Detail."+CaseID);
	       driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div/div/i")).click();
	       System.out.println("Click Custom Action Button");
	       driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div[2]/div[2]/div/a[2]/i")).click();
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
	      System.out.println("Reamrks FIlled");
	      
	      driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
	      Thread.sleep(2000);
	      System.out.println("Save CRRSC");
	      
	      
	      //Case Page Closed
	      driver.close();
	      Thread.sleep(2000);
	     	      
	      // Switch to Real Window
	      driver.switchTo().window(mainWindowHandle);
	      driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div[1]/div/i")).click();
	      Thread.sleep(2000);
	      System.out.println("Move to Customer 360.");
	      
	      
	     //Logout
	      driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[2]/a")).click();
	      Thread.sleep(2000);
	      System.out.println("Save CRRSC");
	      
	      driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
	      Thread.sleep(2000);
	      System.out.println("Logout Successfully");
	      
	      	driver.findElement(By.name("UserName")).sendKeys("120047");
	        driver.findElement(By.name("SecureTextBox.Text")).sendKeys("acid_qa");
	        driver.findElement(By.name("command")).click();
	        Thread.sleep(3000);
	        System.out.println("Successfull Login by User");
	        
	        driver.findElement(By.className("icon-service")).click();
	        System.out.println("Click Service");
	        Thread.sleep(5000);
	        
	        driver.findElement(By.className("icon-obj9")).click();
	        System.out.println("Click Cases");
	        Thread.sleep(3000);
	        System.out.println("Cases Home Page Open");
	        
	     // This  will scroll down the page by  1000 pixel vertical		
	        js.executeScript("window.scrollBy(0,1000)");
	        
	        Select View = new Select(driver.findElement(By.name("QueryViewId")));
	        View.selectByVisibleText("Assigned to Department");
	        Thread.sleep(3000);
	        
	        /**
	        * Validate checkbox using isEnabled() and then click
	        */

	        
	        driver.findElement(By.xpath("//div[contains(@class,'react-grid-checkbox')]//child::label[@for='checkbox0']")).click();
	        System.out.println("Select CheckBox");
	       //driver.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div/div[14]/div/div/span/div/label")).click();
	        
	        driver.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div/i")).click();
	        System.out.println("Go for Self Assign");
	        driver.findElement(By.xpath("//div[@class='overlay-button-list']//child::a//child::i[@title='Self Assign Cases']")).click();
	        System.out.println("Click Self Assign");
	        driver.findElement(By.xpath("//div[@class='footer--popup']//child::button")).click();
	        System.out.println("Click Pop Up Self Assign OK");
	        Select AssignView = new Select(driver.findElement(By.name("QueryViewId")));
	        AssignView.selectByVisibleText("Assigned to Me");
	        System.out.println("Assigned to ME View");
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/span/a")).click();
	        System.out.println("Click Case ID");
	        driver.findElement(By.className("fixed-action-button")).click();
	        System.out.println("Go for Edit Button");
	        driver.findElement(By.xpath("//*[@id=\"newobject\"]/div[3]/div[2]/div[2]/div/a[1]")).click();
	        System.out.println("Click Edit Button");
	        Thread.sleep(3000);
	        Select Department = new Select(driver.findElement(By.xpath("//select[@name='cust_512']")));
	        Thread.sleep(2000);
	        Department.selectByVisibleText("Accept");
	        System.out.println("Seelct Department Decision");
	        Thread.sleep(3000);
	        
	        driver.findElement(By.name("cust_471")).sendKeys("Remarks by Processor");
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
	        System.out.println("Click Save and Proceed Button");
			
			driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[2]/div/div[2]/div[2]/div/a")).click();
	      Thread.sleep(2000);
	      System.out.println("Logout Successfully");
		     
	}
}