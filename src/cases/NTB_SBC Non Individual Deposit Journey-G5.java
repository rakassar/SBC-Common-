
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

public class Nonindi_onboard {
	public static void main(String[] args) throws InterruptedException {

		// $$ Please Provide values here first Jai bhole kiii
		int f = (int) (Math.random() * 10000);
		String company_name = "crrscds";
		String Phone_no = "93101" + f;
		String product = "EASY ACCOUNT";
		String DOB = "24-7-1999"; // DD-MM-YYYY
		String[] splittedStrings = DOB.split("-");
		String email = f + "s34d@kk10.com";
		String customer_contact = "Tele Outbound";
		String VVIP = "Business banking";
		String said1 = "0013-Vivo, Rhett A.";
		String TIN = "52317" + f;

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

//creating non-individual lead
		List<WebElement> elementName = driver.findElements(By.id("1")); // click on non-individual leads
		System.out.println(elementName);
		elementName.get(2).click();

		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[1]")).click(); // search page will open and
																							// then we click next

//1st screenflow
		driver.findElement(By.name("cust_494")).sendKeys(company_name); // enter first name string value provided on top
		Select intrested = new Select(driver.findElement(By.name("cust_1261")));// enter last name ,string value
																				// provided on top
		intrested.selectByVisibleText("Deposit");
		driver.findElement(By.name("LE_MOBILE")).sendKeys(Phone_no); // enter phone number , string value provided on
																		// top
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a")).click(); // click next

//2nd screen flow providing account type
		Select product_category = new Select(driver.findElement(By.name("LE_PRODUCTCATEGORY")));
		product_category.selectByVisibleText("Savings"); // account ype
		Thread.sleep(1000);
		Select Product = new Select(driver.findElement(By.name("LE_PRODUCT")));
		Product.selectByVisibleText(product); // account ype

		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click(); // next
//dedupe handled
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

//DOBR
		Select mm = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[16]/div[1]/div/div/div/div[1]/div/select")));
		mm.selectByValue(splittedStrings[1]);

		Select dd = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[16]/div[1]/div/div/div/div[2]/div/select")));
		dd.selectByValue(splittedStrings[0]);

		Select YY = new Select(driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[1]/div/div[2]/div[16]/div[1]/div/div/div/div[3]/div/select")));
		YY.selectByValue(splittedStrings[2]);

		Select cust_cat = new Select(driver.findElement(By.name("cust_49"))); // customer category
		cust_cat.selectByVisibleText("FINANCIAL CORPORATION (BANK)");

		Select cust_contact = new Select(driver.findElement(By.name("cust_920"))); // Customer contact
		cust_contact.selectByVisibleText(customer_contact);

		Select cust_type = new Select(driver.findElement(By.name("cust_50"))); // Customer type
		cust_type.selectByVisibleText("Foreign Banks");

//Select civil =new Select(driver.findElement(By.name("cust_66")));  //Civil status
//civil.selectByVisibleText(CIVIL);

//Select business_Segment = new Select(driver.findElement(By.name("cust_2592"))); //Segment type autofilling right now
//business_Segment.selectByValue("");

		WebElement clients = driver.findElement(By.name("cust_2593")); // client Segment
		clients.sendKeys(VVIP);
		Thread.sleep(1000);
		clients.sendKeys(Keys.ARROW_DOWN);
		clients.sendKeys(Keys.ENTER);

		WebElement said = driver.findElement(By.name("cust_175")); // client Segment
		said.sendKeys(said1);
		Thread.sleep(1000);
		said.sendKeys(Keys.ARROW_DOWN);
		said.sendKeys(Keys.ENTER);

//Select sole =new Select(driver.findElement(By.name("cust_162"))); //Sole owner
//sole.selectByVisibleText("Yes");

//business info
//driver.findElement(By.xpath("//*[@id=\"newobject\"]/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div[7]/div[1]/div/div/div/input")).sendKeys("32423");

		Select typeofcorp = new Select(driver.findElement(By.name("cust_56")));
		typeofcorp.selectByVisibleText("Domestic Corporation");

		WebElement Industry_Classification = driver.findElement(By.name("cust_1563"));
		Industry_Classification.sendKeys("CAFETERIAS");
		Thread.sleep(1000);
		Industry_Classification.sendKeys(Keys.DOWN);
		Industry_Classification.sendKeys(Keys.ENTER);

		WebElement business = driver.findElement(By.name("cust_57"));
		business.sendKeys("Airlines");
		Thread.sleep(1000);
		business.sendKeys(Keys.DOWN);
		business.sendKeys(Keys.ENTER);

		// Select occupation = new Select( driver.findElement(By.name("cust_77")));
		// occupation.selectByVisibleText(Occupation1);

		driver.findElement(By.name("cust_47")).sendKeys("bombay");

		// Select for_Employment = new Select(
		// driver.findElement(By.name("cust_2353")));
		// for_Employment.selectByVisibleText(For_Employment);

		driver.findElement(By.name("cust_86")).sendKeys(TIN);

		driver.findElement(By.xpath("//input[@title = 'MM/DD/YYYY']")).sendKeys("04042025");

		Select source = new Select(driver.findElement(By.name("cust_61")));
		source.selectByVisibleText("Business Income");

		Select entitytype = new Select(driver.findElement(By.name("cust_928")));
		entitytype.selectByVisibleText("Private");

//Id

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@data-autoid='cust_1391_srch']")).click();
		driver.findElement(By.id("select-all-checkbox")).click();

		driver.findElement(By.xpath("//button[@type = 'button']")).click(); // id no

//AOCODE
		Select AO = new Select(driver.findElement(By.name("cust_2624")));
		AO.selectByVisibleText("Mohit");

//Address section
		driver.findElement(By.xpath("//span[@title='Address Details']")).click(); // click on address tab

//ZIPCODE
		WebElement zip = driver.findElement(By.name("cust_526"));
		zip.sendKeys("manila");
		Thread.sleep(1000);
		zip.sendKeys(Keys.DOWN);
		zip.sendKeys(Keys.ENTER);

		driver.findElement(By.name("cust_527")).sendKeys("Street"); // street field

		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]/span")).click();

/////// Documentation stage completed
		Thread.sleep(2000);
//dedupe handled

		while (driver.findElements(By.className("button-group__item")).size() > 3) {
			driver.switchTo().activeElement();
			driver.findElements(By.className("button-group__item")).get(1).click();
			Thread.sleep(2000);
		}

///// CRRS START
		CRRScandofaic call = new CRRScandofaic();

		call.CRRSC(driver);
///CRRSC complete

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

}
