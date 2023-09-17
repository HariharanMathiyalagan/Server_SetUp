package org.server;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.test.Login_Onboarding;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class URL_Check {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
	}

	@AfterMethod
	private void afterMethod() {
		driver.quit();
	}

	@Test(priority = 1)
	public void onboarding() throws MalformedURLException, IOException {
		Login_Onboarding login_Onboarding = new Login_Onboarding(this.driver);
		int login = login_Onboarding.login("Onboarding");
		if (login == 200) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	@Test(priority = 2)
	public void login() throws MalformedURLException, IOException {
		Login_Onboarding login_Onboarding = new Login_Onboarding(this.driver);
		int login = login_Onboarding.login("Login");
		if (login == 200) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

}
