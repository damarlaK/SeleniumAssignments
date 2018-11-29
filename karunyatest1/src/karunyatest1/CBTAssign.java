package karunyatest1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CBTAssign {
	WebDriver driver;

	@BeforeTest

	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
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
