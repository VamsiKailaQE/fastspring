package org.fastsprings.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	
	
	
	public static HttpURLConnection makeRequest(String url, String methodType){

		HttpURLConnection conn = null;
		try {
			
	
			String username=Constants.getUsername();
			String password=Constants.getPassword();

			URL obj = new URL(url);
			conn = (HttpURLConnection) obj.openConnection();
			String encoded = Base64.getEncoder().encodeToString((username+":"+password).getBytes(StandardCharsets.UTF_8));  //Java 8
			conn.setRequestProperty("Authorization", "Basic "+encoded);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			if(methodType=="POST") {
				String payload=testData.payload;
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
				wr.writeBytes(payload);
				wr.flush();
				wr.close();
			}
			else if(methodType=="GET") {
				conn.setRequestMethod("GET");	

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}	
			
			}
			
			else {
				
				System.out.println("Invalid Method Type");
			}
			

		  } 

		  catch (MalformedURLException e) {

			e.printStackTrace();

		  } 

		   catch (IOException e) {

			 e.printStackTrace();
		   }
		return conn;
		}
	
	public static JSONObject getJSONresponse(HttpURLConnection conn) {
		
		JSONObject object=null;
		try {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(conn.getInputStream()));
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		String resp=response.toString();
		
		System.out.println(resp);
		
		JSONParser parser=new JSONParser();
		object=(JSONObject) parser.parse(resp);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return object;
		
		
	}
	public static WebDriver getDriver(String drivername ) {
		
		WebDriver driver = null;
		
		try {
			
			if(drivername.equals("chrome")) {
				//WebDriverManager.chromedriver().setup();
				ChromeDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "/Applications/Softwares/ChromeDriver/chromedriver");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				
			}
		
			else if(drivername.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				//System.setProperty("webdriver.gecko.driver","");
				driver = new FirefoxDriver();
				
			}
			
			else
			{
				System.out.println(drivername+" is an invalid browser type");
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return driver;
		
	}
	
	public static void ImplicitWait(WebDriver driver, int time) {
		
		
		try {
			
				driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
				
			}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	
		
	}

}


















































