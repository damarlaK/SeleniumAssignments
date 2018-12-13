package karunyaDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBTAssign {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")

	public void openbrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browser.equals("FireFox")) {
			System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.linkedin.com//");
	}

	@Test
	public void VerifySignInBtnvisibility() {
		boolean signBtnvisbility = driver.findElement(By.id("login-submit")).isEnabled();
		Assert.assertFalse(signBtnvisbility);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();

	}

}
