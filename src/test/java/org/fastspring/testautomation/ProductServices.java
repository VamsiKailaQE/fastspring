package org.fastspring.testautomation;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.fastsprings.Utils.Constants;
import org.fastsprings.Utils.Utils;
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
			HttpURLConnection conn=Utils.makeRequest(url, "POST");
			
			//Assert Response Properties
			int responseCode = conn.getResponseCode();
			System.out.println("\nSent 'POST' request to URL : " + url);
			System.out.println(conn.getResponseMessage());
			System.out.println("\nResponse Code : " + responseCode);
			
			//Read the response contents to get the details of the product posted
			JSONObject object=Utils.getJSONresponse(conn);
			
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
		
		String requrl=""+url+"vamsi090418";
		
		HttpURLConnection conn=Utils.makeRequest(requrl, "GET");
		
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
		
		//Read the response contents to get the details of the product
		
		JSONObject object=Utils.getJSONresponse(conn);
		
		System.out.println("\nResponse Object: "+object+"\n");
		
		
		//JSONArray listofelements= (JSONArray)object.get("products");
		
		
		
		
		
	}

	catch (Exception e) {
	e.printStackTrace();

	}	
	}

}

