import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Trust_indi {

	public static void main(String[] args) throws InterruptedException {

		//$$ Please Provide values here first    Jai bhole kiii
	int f = (int)(Math.random()*10000);
	String first_name = "Trustch";
	String Last_name = "account8";
	String Phone_no = "938" + f;
	String accountype = "OTHER TRUST PRODUCTS";
	String product = "SPECIAL PURPOSE TRUST";
	String DOB = "15-1-1989"; // DD-MM-YYYY
	String[] splittedStrings = DOB.split("-");                                                                                                                                    
	String email = "";
	String Customertype ="INDIVIDUAL";
	String CIVIL = "Single";
	String customer_contact = "Tele Outbound";
	String VVIP = "Business banking";
	String Emplytype = "Employed";  // Employed , Self-Employed , Unemployed 
	String Occupation1 = "Senior Executives";
	String For_Employment = "Yes";
	String TIN = "52317"+f;
		   
	System.setProperty("webdriver.chrome.driver","D:\\Java\\selenium\\chromedriver.exe"); // driver path
	ChromeDriver driver = new ChromeDriver();  // webdriver name
	driver.get("https://sbcdev.crmnext.com/sn/app/login/login"); //url
	driver.manage().window().maximize(); // maximize window

	//Login screen
	driver.findElement(By.id("TxtName")).sendKeys("109840"); //loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); //password
	driver.findElement(By.name("command")).click();// click enter


	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));



	//quick link and sales journey
	Actions quick = new Actions(driver);
	quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();


	driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[4]/a")).click();//clicking on sales jopurney

	//creating individual lead
	driver.findElement(By.id("1")).click();  //click on individual leads
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click(); // search page will open and then we click next


	//1st screenflow
	driver.findElement(By.name("FIRSTNAME")).sendKeys(first_name); // enter first name string value provided on top
	driver.findElement(By.name("LASTNAME")).sendKeys(Last_name); //enter last name ,string value provided on top
	driver.findElement(By.name("MIDDLENAME")).sendKeys("");
	driver.findElement(By.name("LE_MOBILE")).sendKeys(Phone_no); // enter phone number , string value provided on top
	Select intrstin = new Select (driver.findElement(By.name("cust_1261")));
	intrstin.selectByVisibleText("Trust");
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click(); //click next


	//2nd screen flow providing account type
	Select product_category = new Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
	product_category.selectByVisibleText(accountype);  //account ype

	Select Product = new Select(driver.findElement(By.name("LE_PRODUCT")));
	Product.selectByVisibleText(product);  //account ype

	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();  //next
	// dedupe handled
			Thread.sleep(2000);
			driver.switchTo().activeElement();
			List<WebElement> dedupe = driver.findElements(By.className("button-group__item"));
			if (dedupe.size() > 1) {
				driver.findElement(By.className("button-group__item")).click();
				Thread.sleep(1000);
			}

	//Lead created



	//Clicking on edit and selecting status code document collection
	

	Thread.sleep(2000);
	driver.findElement(By.className("icon-edit")).click();

	driver.findElement(By.id("2")).click();  //selecting status code

	//start filling values
	//Key information
	CRRScandofaic call = new CRRScandofaic();
	call.Select(driver, "cust_2038", "Open New Settlement Account");

	driver.findElement(By.name("LE_EMAIL")).sendKeys(email); //Email
	driver.findElement(By.name("cust_47")).sendKeys("Bombay"); //Place of birth
	driver.findElement(By.name("cust_212")).sendKeys("Mumma"); //Mother maiden

	//DOB
	Select mm =new Select (driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[1]/div/select")));
	mm.selectByValue(splittedStrings[1]);  

	Select dd =new Select(driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[2]/div/select")));
	dd.selectByValue(splittedStrings[0]);

	Select YY =new Select(driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[3]/div/select")));
	YY.selectByValue(splittedStrings[2]);

	call.Select(driver, "LE_GENDER", "Male"); // Gender
	call.Select(driver, "cust_50", Customertype); // Customer type
	call.Select(driver, "cust_920", customer_contact); // Customer contact

	call.Select(driver, "cust_66", CIVIL); // Civil status
	
	driver.findElement(By.name("cust_1806")).sendKeys("12345Qwert");
	//Select business_Segment = new Select(driver.findElement(By.name("cust_2592"))); //Segment type autofilling right now
	//business_Segment.selectByValue("");

	WebElement clients =  driver.findElement(By.name("cust_2593"));    //VIP STATUS
	clients.sendKeys(VVIP);
	Thread.sleep(1000);
	clients.sendKeys(Keys.ARROW_DOWN);
	clients.sendKeys(Keys.ENTER);



	call.Select(driver, "cust_162", "Yes"); // Sole owner

	//Employment section


	Select empt = new Select(driver.findElement(By.name("cust_63")));
	empt.selectByVisibleText(Emplytype);
		
		Select Stated_Income_Range = new Select( driver.findElement(By.name("cust_2597")));
		Stated_Income_Range.selectByVisibleText("Above 5M");
		
		
		if (Emplytype != "Unemployed")
		{
			WebElement Industry_Classification  = driver.findElement(By.name("cust_1563")); 
			Industry_Classification.sendKeys("CAFETERIAS");
			Thread.sleep(1000);
			Industry_Classification.sendKeys(Keys.DOWN);
			Industry_Classification.sendKeys(Keys.ENTER);
			
			WebElement Nature_work  = driver.findElement(By.name("cust_57")); 
			Nature_work.sendKeys("Airlines");
			Thread.sleep(1000);
			Nature_work.sendKeys(Keys.DOWN);
			Nature_work.sendKeys(Keys.ENTER);
			
			Select occupation = new Select( driver.findElement(By.name("cust_77")));
			occupation.selectByVisibleText(Occupation1);
			Thread.sleep(1000);
			
			if (Occupation1 == "Others") {
				driver.findElement(By.name("cust_80")).sendKeys("hihello");
				
			}
			
			Select for_Employment = new Select( driver.findElement(By.name("cust_2353")));
			for_Employment.selectByVisibleText(For_Employment);
			
			if (For_Employment == "No")
			{
				Thread.sleep(1000);
				driver.findElement(By.name("cust_86")).sendKeys(TIN);
			}

			if (Emplytype == "Employed") {
				driver.findElement(By.name("cust_48")).sendKeys("employer1f");

				Select Working_Since_m = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[1]/div/select")));
				Working_Since_m.selectByVisibleText("April");
				
				Select Working_Since_y = new Select( driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[2]/div/select")));
				Working_Since_y.selectByVisibleText("2007");
			
			}
		    else if (  Emplytype == "Self-Employed") {
		    	driver.findElement(By.name("cust_494")).sendKeys("businessman");
				
		    	Select source = new Select (driver.findElement(By.name("cust_61")));
		    	source.selectByVisibleText("Business");
				
			}
		}
			
	else {
		    	Select source = new Select (driver.findElement(By.name("cust_61")));
		    	source.selectByVisibleText("Inheritance");
		    	
		    }
			
			    



	//ID
	WebElement ID =  driver.findElement(By.name("cust_467"));
	ID.sendKeys("Driver's License");
	Thread.sleep(1000);
	ID.sendKeys(Keys.DOWN);
	ID.sendKeys(Keys.ENTER);

	driver.findElement(By.name("cust_90")).sendKeys("qwert"+f); //id no


	//AOCODE
	//Select AO = new Select(driver.findElement(By.name("cust_2624")));
	//AO.selectByVisibleText("Rocky");
	
	Select dosri = new Select(driver.findElement(By.name("cust_1540")));
	dosri.selectByVisibleText("Yes");
	
	Select Fatca = new Select (driver.findElement(By.name("cust_1575")));
	Fatca.selectByVisibleText("Yes");




	//Address section
	driver.findElement(By.xpath("//span[@title='Address']")).click(); //click on address tab

	driver.findElement(By.name("LE_LOCALITY")).sendKeys("Street"); //street field

	


	//ZIPCODE
	WebElement zip = driver.findElement(By.name("LE_ZIP_CODE"));
	zip.sendKeys("manila");
	Thread.sleep(1000);
	zip.sendKeys(Keys.DOWN);

	zip.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();

	// dedupe handled
	Thread.sleep(2000);
	while (driver.findElements(By.className("button-group__item")).size() > 2) {
		driver.switchTo().activeElement();
		driver.findElements(By.className("button-group__item")).get(1).click();
		Thread.sleep(2000);
	}
	/////// Documentation stage completed

	Thread.sleep(3000);
  driver.findElement(By.className("icon-screenflow")).click();
  Set<String>Windowsettle =  driver.getWindowHandles();
  System.out.println(Windowsettle);
	Iterator <String> DW =  Windowsettle.iterator();
	String W1 = DW.next();
	String W2 = DW.next();

	driver.switchTo().window(W2);
	
	Select product_category1 = new Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
	product_category1.selectByVisibleText("Savings");  //account ype
	
	Select leadrat = new Select (driver.findElement(By.name("LE_LEADRATING")));
	leadrat.selectByVisibleText("Warm");
	
	Select Product1 = new Select(driver.findElement(By.name("LE_PRODUCT")));
	Product1.selectByVisibleText("EASY ACCOUNT");  //account ype

  driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click();
//dedupe handled
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		List<WebElement> dedupe1 = driver.findElements(By.className("button-group__item"));
		if (dedupe1.size() > 1) {
			driver.findElement(By.className("button-group__item")).click();
			Thread.sleep(1000);
		}
//Clicking on edit and selecting status code document collection
Thread.sleep(3000);
driver.findElement(By.className("icon-edit")).click(); //click edit
driver.findElement(By.id("2")).click();  //selecting status code

if (Emplytype != "Unemployed")
{
	
	
	Select for_Employment = new Select( driver.findElement(By.name("cust_2353")));
	for_Employment.selectByVisibleText(For_Employment);
	
	if (For_Employment == "No")
	{
		Thread.sleep(1000);
		driver.findElement(By.name("cust_86")).sendKeys(TIN);
	}
}

driver.findElement(By.xpath("//span[@title='Address']")).click(); //click on address tab


Select mail = new Select(driver.findElement(By.name("cust_1812"))); //mailing address
	mail.selectByVisibleText("Present");
	
	
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();
	//dedupe
	while (driver.findElements(By.className("button-group__item")).size() > 3) {
		driver.switchTo().activeElement();
		driver.findElements(By.className("button-group__item")).get(1).click();
		Thread.sleep(2000);
	}
	

	///// CRRS START

	call.CRRSC(driver);


	/// fill account info
	call.fillAccountInfo(driver);
	///Account information complete


	//clicking on process appliacation
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[2]/span")).click();
	driver.manage().window().maximize();
	driver.navigate().refresh();
	
	String leadid = driver.findElement(By.xpath("//span[@data-autoid='LE_NUMBER_ctrl']")).getText();
	System.out.println(leadid);
	  String status = driver.findElement(By.xpath("//span[@data-autoid = 'LE_STATUSCODE_ctrl']")).getText();
		while (status.equalsIgnoreCase("sent for processing")) {
			
      	status = driver.findElement(By.xpath("//span[@data-autoid = 'LE_STATUSCODE_ctrl']")).getText();
      	driver.navigate().refresh();
      	
      }

		System.out.println(status + " for lead id " + leadid);
	Thread.sleep(5000);
	driver.close();
    driver.switchTo().window(W1);
	driver.findElement(By.className("icon-edit")).click();
	Select settleType = new Select(driver.findElement(By.name("cust_2038")));
	settleType.selectByVisibleText("Choose from Existing Account");
	driver.findElement(By.className("picker-icon")).click();
	Thread.sleep(1000);
	driver.switchTo().activeElement().click();

	Select updetb = new Select(driver.findElement(By.name("cust_2739")));
	updetb.selectByVisibleText("No");
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();

	// again
	Thread.sleep(3000);
	driver.findElement(By.className("icon-edit")).click();
	Select settleType1 = new Select(driver.findElement(By.name("cust_2038")));
	settleType1.selectByVisibleText("Choose from Existing Account");
	driver.findElement(By.className("picker-icon")).click();
	Thread.sleep(1000);
	driver.switchTo().activeElement().click();
	Select updetb1 = new Select(driver.findElement(By.name("cust_2739")));
	updetb1.selectByVisibleText("No");
	driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();
	Thread.sleep(1000);

	while (status.equalsIgnoreCase("Documents Collection")) {

		status = driver.findElement(By.xpath("//span[@data-autoid = 'LE_STATUSCODE_ctrl']")).getText();
		driver.navigate().refresh();

	}
	driver.navigate().to("https://sbcdev.crmnext.biz/sn/app/CRMNextObject/Home/Lead");
	// Login screen
	driver.findElement(By.id("TxtName")).sendKeys("208004"); // loginid
	driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); // password
	driver.findElement(By.name("command")).click();// click enter

	Select bucket1 = new Select(driver.findElement(By.name("QueryCategoryId")));
	bucket1.selectByVisibleText("Trust-Individual");
	Select bucket2 = new Select(driver.findElement(By.name("QueryViewId")));
	bucket2.selectByVisibleText("Assigned to Trust");

	driver.findElement(By.className("filterGroup__button")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("select-all-checkbox")).click();
	driver.findElement(By.className("icon-Mass-Update")).click();
	Thread.sleep(1000);
	driver.navigate().refresh();
	Select bucket3 = new Select(driver.findElement(By.name("QueryViewId")));
	bucket3.selectByVisibleText("Assigned Leads");
	driver.findElement(By.className("filterGroup__button")).click();
	Thread.sleep(1000);
	Integer leadId1 = new Integer(leadid);
	int this1 = leadId1 - 1;
	String this123 = Integer.toString(this1);
	driver.findElement(By.linkText(this123)).click();
	List<WebElement> process = driver.findElements(By.className("icon-Mass-Update"));
	process.get(1).click();
	driver.navigate().refresh();
	driver.findElement(By.className("icon-Mass-Update")).click();

	}

}


