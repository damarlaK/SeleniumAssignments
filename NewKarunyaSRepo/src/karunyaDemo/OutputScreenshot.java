package karunyaDemo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OutputScreenshot {

	WebDriver driver;

	@BeforeTest
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}

	@Test
	public void booking() throws IOException, InterruptedException {
		try {

			driver.findElement(By.name("userName")).sendKeys("mercury");
			driver.findElement(By.name("password")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			// driver.findElement(By.cssSelector("body > div > table > tbody > tr >
			// td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr >
			// td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody
			// > tr:nth-child(4) > td:nth-child(1) > font > b")).sendKeys("London");
			driver.findElement(By.name("fromPort")).sendKeys("London");
			driver.findElement(By.name("toPort")).sendKeys("NewYork");
			driver.findElement(By.name("findFlights")).click();
			driver.findElement(By.name("reserveFlights")).click();
			driver.findElement(By.name("passFirst0")).sendKeys("karunya");
			driver.findElement(By.name("passLast0")).sendKeys("Damarla");
			driver.findElement(By.name("creditnumber")).sendKeys("1234");
			driver.findElement(By.name("buyFlights")).click();

		}

		catch (Exception e) {
			takeScreenshot();
		}

	}

	private void takeScreenshot() throws IOException ,InterruptedException {
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile method.
		FileHandler.copy(ss, new File("C:\\Users\\karunya.damarla\\Documents\\ECLIPSE\\TakesScreenshot" + (new Random().nextInt()) + ".png"));

	}

	@AfterTest

	public void closeBrowser() {
		driver.close();
	}
}
