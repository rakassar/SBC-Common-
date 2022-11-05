package sbc;

//case

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class said {
	public static void main(String[] args) throws InterruptedException {
		
		String BBN = "38000000393";
		String detail_of_concern = "deatils";
		String remarks = "remarkss";		
		
		   
		System.setProperty("webdriver.chrome.driver","D:\\Aman\\Automation\\Browser Driver\\Chrome\\chromedriver_win32\\chromedriver.exe"); // driver path // driver path
		ChromeDriver driver = new ChromeDriver();// webdriver name

		driver.get("https://sbcdev.crmnext.com/sag7/app/login/login"); // url
		driver.manage().window().maximize(); // maximize window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//Login screen
		driver.findElement(By.id("TxtName")).sendKeys("109840"); //loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
		driver.findElement(By.name("command")).click();// click enter
		
		//quick link and customer search
		
		Actions quick = new Actions(driver);
		quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();
		//quick.
		//driver.findElement(By.className("icon-link")) ;  //clicking on quick link icon
		
		driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[1]/a/span[1]")).click();
		
		driver.findElement(By.name("100000012")).sendKeys(BBN);
		driver.findElement(By.linkText("Fetch")).click();
		
		driver.findElement(By.linkText(BBN)).click();
		driver.findElement(By.linkText("Start Your Journey")).click();
		
		Set <String> windows = driver.getWindowHandles();
		System.out.println(windows);
		
		Iterator <String> pc = windows.iterator();
		String PW = pc.next();
		String CW = pc.next();
		driver.switchTo().window(CW);
		
		driver.findElement(By.id("2")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.name("CASE_SUBCATEGORY1")).sendKeys("SA ID/AO Code Maintenance");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name=\"CASE_SUBCATEGORY1\"]")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"CASE_SUBCATEGORY1\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[contains(@data-autoid,'CASE_PRDHOLDINGNUMBER_srch')]//i[contains(@class,'icon icon-acid-search')]")).click(); 
        driver.findElement(By.xpath("//div[@data-autoid='HoldingNumber_0']")).click(); 

    Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
	
	driver.findElement(By.name("cust_878")).sendKeys(detail_of_concern);   
	driver.findElement(By.name("cust_471")).sendKeys(remarks);       
	
   
	Select AO = new Select (driver.findElement(By.xpath("//select[@name='cust_2635']") )); // Select Account Officer Name and Code
     AO.selectByVisibleText("Pankaj");
	
     driver.findElement(By.xpath("//div[220]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//i[1]")).click(); 
     driver.findElement(By.xpath("//div[@data-autoid='DisplayName_0']")).click(); 
     
     
	
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
    System.out.println(driver.findElement(By.className("f13")).getText());
	
	driver.switchTo().window(PW);
	driver.findElement(By.name("ProfileImage_header")).click();
	driver.findElement(By.linkText("Logout")).click();
	// driver.close();

	driver.findElement(By.id("TxtName")).sendKeys("120047"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter
	
	Actions quick1 = new Actions(driver);
	quick1.moveToElement(driver.findElement(By.className("icon-service"))).perform();
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[1]/a/span")).click();//
	
	Select bucket1 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket1.selectByVisibleText("Case");
	
	
	
	Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"js-vnav\"]/li[2]/div/div[1]/a[1]")).click();//Leads object
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
    SM.selectByIndex(1);
    Thread.sleep(1000);
    driver.findElement(By.xpath("//textarea[@placeholder='Please post your comments here']")).sendKeys("ABCD"); //Enter message
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")).click(); // Click on Save and Proceed button
	}

}