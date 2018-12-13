package karunyaDemo;


import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DateFormater {
	WebDriver driver;

	@BeforeTest

	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.timeanddate.com/");
	}

	@Test
	public void validateDate() {
		String date = driver.findElement(By.cssSelector("#ij2")).getText();
		Assert.assertTrue(formatIsvalid(date));

	}

	private static boolean formatIsvalid(String date) {
		boolean valid = true;
		try {
			org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM DD, YYYY");
			DateTime dob = formatter.parseDateTime(date);

		} catch (Exception e) {
			valid = false;
		}
		return valid;

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}
}
