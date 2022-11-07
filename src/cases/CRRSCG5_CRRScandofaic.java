package cases;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Webdd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.Chromedd;
import org.openqa.selenium.support.ui.Select;

import repository.Properties;

public class CRRSCG5_CRRScandofaic implements Properties {

	void CRRSC(ChromeDriver driver) throws InterruptedException {

		driver.findElement(By.className("icon-screenflow")).click();

		WebElement risk = driver.findElement(By.name("cust_1520"));
		risk.sendKeys("abu");
		Thread.sleep(500);
		risk.sendKeys(Keys.DOWN);
		risk.sendKeys(Keys.ENTER);

		Select(driver, "cust_1169", "Employed");

		WebElement emrisk = driver.findElement(By.name("cust_2444"));
		emrisk.sendKeys("ADMINISTRATION OF FINANCIAL MARKETS");
		Thread.sleep(1000);
		emrisk.sendKeys(Keys.DOWN);
		emrisk.sendKeys(Keys.ENTER);

		Select(driver, "cust_1699", "No");
		Select(driver, "cust_1700", "No");
		Select(driver, "cust_1701", "No");
		Select(driver, "cust_1702", "No");
		Select(driver, "cust_1703", "No");
		Select(driver, "cust_2427", "No");
		Select(driver, "cust_1706", "No");
		Select(driver, "cust_1708", "No");
		Select(driver, "cust_1709", "No");

		Select(driver, "cust_1717", "Yes");
		Select(driver, "cust_1720", "Yes");
		Select(driver, "cust_1721", "Yes");
		Select(driver, "cust_2032", "Yes");
		Select(driver, "cust_1722", "Yes");
		Select(driver, "cust_1723", "Yes");

		driver.findElement(By.name("cust_2430")).sendKeys("remarks");

		driver.findElement(By.xpath("//a[@data-autoid='FlowFinish']")).click();

//Edit and fill OFAC
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[1]/i")).click();
		Select(driver, "cust_1718", "No Hit");
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/div/a[2]")).click();
///OFAC Complete

	}

	void fillAccountInfo(ChromeDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"object-action-button\"]/a[1]/span")).click();

		Select(driver, "cust_1318", "EVERYDAY MASTERCARD DEBIT/ATM CARD");
		Select(driver, "cust_497", "Allowance/Allotment/Pension");
		driver.findElement(By.xpath("//input[@data-autoid='cust_92_ctrl']")).sendKeys("2323");
		Select(driver, "cust_1185", "Yes");
		Select(driver, "cust_74", "Yes");
		Select(driver, "cust_85", "Yes");
		Select(driver, "cust_107", "Yes");

		driver.findElement(By.xpath("//a[@data-autoid='FlowFinish']")).click();
	}

	void Select(ChromeDriver driver, String Field_name, String value) {
		Select xx = new Select(driver.findElement(By.name(Field_name)));
		xx.selectByVisibleText(value);
	}

}