package org.fastspring.testautomation;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterTest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Iterator;

public class ProductServices{
	
	String productname;
	
	@Test (groups = {"insertInfo"}, enabled=true, priority=0)
	public void postProducts() {
		
		
		String url=Constants.getUrl();
		
		
		try {
			
			//Make Post request with payload from testData
			HttpURLConnection conn=Utils.getConnection(url, "POST");
			
			//Assert Response Properties
			int responseCode = conn.getResponseCode();
			System.out.println("\nSent 'POST' request to URL : " + url);
			System.out.println("\nResponse Code : " + responseCode);
			
			//Read the response contents to get the details of the product posted
			BufferedReader input = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			JSONParser parser=new JSONParser();
			JSONObject object=(JSONObject) parser.parse(input);
			System.out.println("\nResponse Object: "+object+"\n");
			JSONArray allproducts= (JSONArray)object.get("products");
			System.out.print("Product/Products Inserted: ");
			Iterator<?> it=allproducts.iterator();
			while(it.hasNext()) {
				JSONObject product=(JSONObject) it.next();
				productname=(String) product.get("product");
				System.out.println(productname);
			}

		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (groups = { "getInfo" }, enabled=true, priority= 1)
	public void getProducts(){
		
	try{
		
		String url=Constants.getUrl();
		
		HttpURLConnection conn=Utils.getConnection(""+url+productname, "GET");

		String response=conn.getResponseMessage();
		//System.out.println(response);
		BufferedReader input = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
		JSONParser parser=new JSONParser();
		JSONObject object=(JSONObject) parser.parse(input);
		System.out.println("\n"+object);
		
	}

	catch (Exception e) {
	e.printStackTrace();

	}	
	}

}

