package org.fastspring.testautomation;
import org.testng.annotations.Test;

import org.fastpsring.ObjectRepo.CreditPaymentPage;
import org.fastpsring.ObjectRepo.Homepage;
import org.fastsprings.Utils.Action;
import org.fastsprings.Utils.Constants;
import org.fastsprings.Utils.Utils;
import org.fastsprings.Utils.testData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.HttpURLConnection;

import java.util.Iterator;

public class ProductServices{
	
	//Global variables for assertions in API vs Web
	String payload;
	String productname;
	String display_en;
	String summary_en;
	Double discount1;
	Double discount2;
	WebDriver driver;
	
	
	@Test (groups = {"API", "APIPost"}, enabled=true, priority=0)
	public void postProducts() {
	
		String url=Constants.getUrl();
		
		
		try {
			
			//Make Post request with payload from testData
			payload=testData.getPayload("vamsi-"+Utils.getrandomNumber());
			HttpURLConnection conn=Utils.makeRequest(url, "POST", payload);
			
			//Assert Response Properties
			int responseCode = conn.getResponseCode();
			System.out.println("\nSent 'POST' request to URL : " + url);
			System.out.println(conn.getResponseMessage());
			System.out.println("\nResponse Code : " + responseCode);
			
			//Get the string response with the details of the product  and convert it to a JSONObject
			String response=Utils.getResponse(conn);
			System.out.println("\nCreate Product - Response: "+response);
			
			JSONParser parser=new JSONParser();
			JSONObject object=(JSONObject) parser.parse(response);
			System.out.println("\nCreated Product Details: "+object+"\n");
			JSONArray allproducts= (JSONArray)object.get("products");
			System.out.print("Product/Products created: ");
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
	
	@Test (groups = { "API", "APIGet" }, enabled=true, priority= 1)
	public void modify_Product(){
		
	try{
		
		String url=Constants.getUrl();
		String requrl=""+url+productname;
		
		//Makes get Request with existing product
		String empty_payload=null;
		HttpURLConnection conn=Utils.makeRequest(requrl, "GET", empty_payload);
		

		//Gets the string response with the details of the product posted into a JSONObject
		String response=Utils.getResponse(conn);
		System.out.println("\nExsting Product Details: "+response+"\n");
		
		//Parse the response from GET and save to global variables for asserting API against Web
		JSONParser parser=new JSONParser();
		JSONObject object=(JSONObject) parser.parse(response);
		JSONArray products_array= (JSONArray)object.get("products");
		
		Iterator<?> it=products_array.iterator();
		while(it.hasNext()) {
			JSONObject objects=(JSONObject) it.next();
			JSONObject display_obj=(JSONObject) objects.get("display");
			display_en=(String) display_obj.get("en");
			//System.out.println(display_en);
			JSONObject desc=(JSONObject)objects.get("description");
			JSONObject summary=(JSONObject) desc.get("summary");
			summary_en=(String) summary.get("en");
			System.out.println(summary_en);
			JSONObject pricing=(JSONObject)objects.get("pricing");
			JSONObject quantity_discounts=(JSONObject) pricing.get("quantityDiscounts");
			JSONObject first_quantity=(JSONObject) quantity_discounts.get("10");
			JSONObject second_quantity=(JSONObject) quantity_discounts.get("30");
			discount1= (Double) first_quantity.get("USD");
			discount2= (Double) second_quantity.get("USD");
			//System.out.println(discount1 +" "+ discount2);	
		}
		
	}
	catch (Exception e) {
	e.printStackTrace();

	}	
	}
	
	@Test(priority= 2, enabled=true)
	public void getUpdatedResult() {
		
		try {
		
			
		String payload1=testData.getPayload(productname);
		String modified_payload=payload1.replace(display_en, "Changed to Video Editor");
		modified_payload=modified_payload.replace(summary_en, "Create amazing videos");
		System.out.println("Modified payload "+modified_payload);
		
		String url=Constants.getUrl();
		
		//Post it again to modify the created product
		HttpURLConnection conn=Utils.makeRequest(url, "POST", modified_payload);
		String updated_response=Utils.getResponse(conn);
		System.out.println("\nProduct Updated - Response: "+updated_response+"\n");
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority= 3, enabled=false)
	public void checkout(String drivername) {
		
	
		try {
			
			
			driver=Utils.getDriver(drivername);
			driver.get(Constants.getCheckoutUrl()+productname);
			
			
			Homepage home=new Homepage(driver);
			CreditPaymentPage payment=new CreditPaymentPage(driver);
			Action action=new Action(driver);
			//action.selectDropDown(home.get_quantity_select(productname), "7");
			action.move_to_element(home.get_subscription_terms(productname));
			String amount=action.getText(home.get_volume_discounts(productname));
			action.hover_over_element(home.get_volume_discounts(productname));
			System.out.println(amount);
			String amount1=action.getText(home.get_volume_amount(productname));
		    System.out.println(amount1);
		   // System.out.println(amount);
			action.click(home.getCard_button());
			action.sendText(payment.getFirstname(), "TestFN");
			action.sendText(payment.getLastname(), "TestLN");
			action.sendText(payment.getEmail(), "test@gmail.com");
			action.sendText(payment.getCard_number(), "4242424242424242");
			action.sendText(payment.getExp_month(), "07");
			action.sendText(payment.getExp_year(), "20");
			action.sendText(payment.getCvc(), "*UMSM");
			action.sendText(payment.getBilling_address(), "1202, Test St ");
			action.sendText(payment.getCity(), "Santa Ana");
			action.selectDropDown(payment.getState_select(), "CA");
			action.sendText(payment.getZip_code(), "92606");
			action.sendText(payment.getContact_phone(), "+91 9087875767");
			//action.click(payment.getSave_button());
			action.move_to_element(payment.getSave_button());
			String checkout_confirmation=action.getText(payment.getthankyoumsg());
			System.out.println(checkout_confirmation);
			Assert.assertTrue(checkout_confirmation.contains("Thank you"));	
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	
	
	}

}

