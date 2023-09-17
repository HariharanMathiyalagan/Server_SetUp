package org.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;

public class Login_Onboarding {
	public WebDriver driver;
	HttpURLConnection connection;

	public Login_Onboarding(WebDriver driver) {
		this.driver = driver;
	}

	public int login(String value) throws MalformedURLException, IOException {
		if (value.equals("Onboarding")) {
			driver.get("https://qaapp.zaigotech.com/onboarding.html");
		} else if (value.equals("Login")) {
			driver.get("https://qaapp.zaigotech.com/login");
		}
		String currentUrl = driver.getCurrentUrl();
		connection = (HttpURLConnection) new URL(currentUrl).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int responseCode = connection.getResponseCode();
		return responseCode;
	}

}
