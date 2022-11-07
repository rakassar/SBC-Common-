package cases;


import java.io.IOException;
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

public class Individual_onboard {
	public static void main(String[] args) throws InterruptedException, IOException {

		// $$ Please Provide values here first Jai bhole kiii
		String Salutation = "Mr.";
		String suffix = "II";

		String FIRSTNAME = "NAMEee";
		String Middlename = "";
		String LASTNAME = "ISe";
		int MOBILE = 9852825;

		int f = (int) (Math.random() * 10000);
		String DOB = "20/4/2006";
		String[] splittedStrings = DOB.split("/");
		String email = "";// f+"55dd@kk10.com";
		String customertype = "INDIVIDUAL";
		String CIVIL = "Separated";
		String customer_contact = "Tele Outbound";
		String VVIP = "Blue";
		String Emplytype = "Employed"; // Employed , Self-Employed , Unemployed
		String Occupation1 = "Business Proprietors and Owners";
		String For_Employment = "Yes";
		String TIN = "55556";

		System.setProperty("webdriver.chrome.driver", "D:\\Java\\selenium\\chromedriver.exe"); // driver path
		ChromeDriver driver = new ChromeDriver(); // webdriver name

		driver.get("https://sbcdev.crmnext.com/sn/app/login/login"); // url
		driver.manage().window().maximize(); // maximize window

//Login screen
		driver.findElement(By.id("TxtName")).sendKeys("208309"); // loginid
		driver.findElement(By.id("TxtPassword")).sendKeys("acid_qa"); // password
		driver.findElement(By.name("command")).click();// click enter

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

//quick link and sales journey
		Actions quick = new Actions(driver);
		quick.moveToElement(driver.findElement(By.className("icon-link"))).perform();

		driver.findElement(By.xpath("//*[@id=\"QuickLinksDiv\"]/ul/li[4]/a")).click();// clicking on sales jopurney

//creating individual lead
		driver.findElement(By.id("1")).click(); // click on individual leads
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click(); // search page will open and
																							// then we click next

//1st screenflow
		Individual_onboard call = new Individual_onboard();
		call.Select(driver, "SALUTATION", Salutation);
		call.Select(driver, "SUFFIX", suffix);
		driver.findElement(By.name("FIRSTNAME")).sendKeys(FIRSTNAME); // enter first name string value provided on top
		driver.findElement(By.name("LASTNAME")).sendKeys(LASTNAME); // enter last name ,string value provided on top
		driver.findElement(By.name("MIDDLENAME")).sendKeys(Middlename);
		driver.findElement(By.name("LE_MOBILE")).sendKeys(Integer.toString(MOBILE)); // enter phone number , string
																						// value provided on
		// top
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click(); // click next

//2nd screen flow providing account type

		Select product_category = new Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
		product_category.selectByVisibleText("Savings"); // account yype

		Select mm = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[1]/div/select")));
		mm.selectByValue(splittedStrings[1]);

		Select dd = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[2]/div/select")));
		dd.selectByValue(splittedStrings[0]);

		Select YY = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[3]/div[1]/div/div/div/div[3]/div/select")));
		YY.selectByValue(splittedStrings[2]);

		Select Product = new Select(driver.findElement(By.name("LE_PRODUCT")));
		Product.selectByVisibleText("EASY ACCOUNT"); // account ype

		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click(); // next

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

		driver.findElement(By.className("icon-edit")).click(); // click edit
		driver.findElement(By.id("2")).click(); // selecting status code

//start filling values
//Key information
		driver.findElement(By.name("LE_EMAIL")).sendKeys(email); // Email
		driver.findElement(By.name("cust_47")).sendKeys("Bombay"); // Place of birth
		driver.findElement(By.name("cust_212")).sendKeys("Mumma"); // Mother maiden

		Select gender = new Select(driver.findElement(By.name("LE_GENDER"))); // Gender
		gender.selectByVisibleText("Male");

		Select cust_type = new Select(driver.findElement(By.name("cust_50"))); // Customer type
		cust_type.selectByVisibleText(customertype);

		Select cust_contact = new Select(driver.findElement(By.name("cust_920"))); // Customer contact
		cust_contact.selectByVisibleText(customer_contact);

		Select civil = new Select(driver.findElement(By.name("cust_66"))); // Civil status
		civil.selectByVisibleText(CIVIL);

//Select business_Segment = new Select(driver.findElement(By.name("cust_2592"))); //Segment type autofilling right now
//business_Segment.selectByValue("");

		WebElement clients = driver.findElement(By.name("cust_2593")); // VIP STATUS
		clients.sendKeys(VVIP);
		Thread.sleep(1000);
		clients.sendKeys(Keys.ARROW_DOWN);
		clients.sendKeys(Keys.ENTER);

		WebElement salesId = driver.findElement(By.name("cust_175"));
		salesId.sendKeys("0013-Vivo, Rhett A.");
		Thread.sleep(500);
		salesId.sendKeys(Keys.DOWN);
		salesId.sendKeys(Keys.ENTER);

		Select sole = new Select(driver.findElement(By.name("cust_162"))); // Sole owner
		sole.selectByVisibleText("Yes");

//Employment section

		Select empt = new Select(driver.findElement(By.name("cust_63")));
		empt.selectByVisibleText(Emplytype);

		Select Stated_Income_Range = new Select(driver.findElement(By.name("cust_2597")));
		Stated_Income_Range.selectByVisibleText("Above 5M");

		if (Emplytype != "Unemployed") {
			WebElement Industry_Classification = driver.findElement(By.name("cust_1563"));
			Industry_Classification.sendKeys("CAFETERIAS");
			Thread.sleep(1000);
			Industry_Classification.sendKeys(Keys.DOWN);
			Industry_Classification.sendKeys(Keys.ENTER);

			WebElement Nature_work = driver.findElement(By.name("cust_57"));
			Nature_work.sendKeys("Airlines");
			Thread.sleep(1000);
			Nature_work.sendKeys(Keys.DOWN);
			Nature_work.sendKeys(Keys.ENTER);

			Select occupation = new Select(driver.findElement(By.name("cust_77")));
			occupation.selectByVisibleText(Occupation1);
			Thread.sleep(1000);

			if (Occupation1 == "Others") {
				driver.findElement(By.name("cust_80")).sendKeys("hihello");

			}

			Select for_Employment = new Select(driver.findElement(By.name("cust_2353")));
			for_Employment.selectByVisibleText(For_Employment);

			if (For_Employment == "No") {
				Thread.sleep(1000);
				driver.findElement(By.name("cust_86")).sendKeys(TIN);
			}

			if (Emplytype == "Employed") {
				driver.findElement(By.name("cust_48")).sendKeys("employer1f");

				Select Working_Since_m = new Select(driver.findElement(By.xpath(
						"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[1]/div/select")));
				Working_Since_m.selectByVisibleText("April");

				Select Working_Since_y = new Select(driver.findElement(By.xpath(
						"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/div[2]/div/select")));
				Working_Since_y.selectByVisibleText("2007");

			} else if (Emplytype == "Self-Employed") {
				driver.findElement(By.name("cust_494")).sendKeys("businessman");

				Select source = new Select(driver.findElement(By.name("cust_61")));
				source.selectByVisibleText("Business");

			}
		}

		else {
			Select source = new Select(driver.findElement(By.name("cust_61")));
			source.selectByVisibleText("Inheritance");

		}

//ID
		WebElement ID = driver.findElement(By.name("cust_467"));
		ID.sendKeys("Driver's License");
		Thread.sleep(1000);
		ID.sendKeys(Keys.DOWN);
		ID.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		driver.findElement(By.name("cust_90")).sendKeys("qwert" + f); // id no

//AOCODE
		Select AO = new Select(driver.findElement(By.name("cust_2624")));
		AO.selectByVisibleText("Mohit");

//Address section
		driver.findElement(By.xpath("//span[@title='Address']")).click(); // click on address tab

		driver.findElement(By.name("LE_LOCALITY")).sendKeys("Street"); // street field

		Select mail = new Select(driver.findElement(By.name("cust_1812"))); // mailing address
		mail.selectByVisibleText("Present");

//ZIPCODE
		WebElement zip = driver.findElement(By.name("LE_ZIP_CODE"));
		zip.sendKeys("manila");
		Thread.sleep(1000);
		zip.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		zip.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();
/////// Documentation stage completed
		Thread.sleep(2000);
// dedupe handled

		while (driver.findElements(By.className("button-group__item")).size() > 3) {
			driver.switchTo().activeElement();
			driver.findElements(By.className("button-group__item")).get(1).click();
			Thread.sleep(2000);
		}

///// CRRSC START
		call.CRRSC(driver);
///CRRSC complete

/// fill account info
		call.fillAccountInfo(driver);

///Account information complete

//clicking on process appliacation
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[2]/span")).click();
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> LW = Window.iterator();
		String W1 = LW.next();
		String W2 = LW.next();

		driver.switchTo().window(W2);
		driver.findElement(By.name("m$bs$bc")).click();

		driver.switchTo().window(W1);

		System.out.println("lead id = " + driver
				.findElement(By.xpath("//*[@id=\"objectWrapper\"]/div/div[3]/div[1]/div/div/div/span")).getText());

	}

	private void fillAccountInfo(ChromeDriver driver) {
		// TODO Auto-generated method stub
		
	}

	private void CRRSC(ChromeDriver driver) {
		// TODO Auto-generated method stub
		
	}

	private void Select(ChromeDriver driver, String string, String salutation) {
		// TODO Auto-generated method stub
		
	}



}
