package org.fastspring.testautomation;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utils {
	
	
	
	public static HttpURLConnection getConnection(String url, String methodType){

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
	
	public static void getPayload() {
		
		
	}

}
