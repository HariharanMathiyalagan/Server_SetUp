package org.server;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sddsfdsf {
	
	public static void main(String[] args) {
		try {
			// Create a custom TrustManager that trusts all certificates
			TrustManager[] trustAllCertificates = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };

			// Create an SSLContext that uses the custom TrustManager
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

			// Set the custom SSLContext as the default for HttpsURLConnection
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

			// Now you can create a WebDriver instance and navigate to the website
			WebDriver driver = new ChromeDriver();
			driver.get("https://app.getfieldy.com/onboarding.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
