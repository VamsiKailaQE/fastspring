package org.fastspring.testautomation;
import org.testng.annotations.Test;
import org.fastsprings.Utils.Action;
import org.fastsprings.Utils.Constants;
import org.fastsprings.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.fastpsring.ObjectRepo.*;


public class Checkoutflow {
	
	WebDriver driver;
	
			
	
	@BeforeTest
	@Parameters({ "drivername" })
	public void setup(String drivername) {
	try {
		driver=Utils.getDriver(drivername);
		Utils.ImplicitWait(driver, 10);
		driver.get(Constants.getCheckoutUrl());
	}
	catch(Exception e){
		
		e.printStackTrace();	
	}
	
	}
	
	@Test
	public void postordercheck() {
		
		
	}
	
	@Test
	public void checkout() {
		
	
		try {
			Homepage home=new Homepage(driver);
			CreditPaymentPage payment=new CreditPaymentPage(driver);
			Action action=new Action(driver);
			
			action.selectDropDown(home.getQuantity_select(), "7");
			Utils.ImplicitWait(driver, 10);
			action.move_to_element(home.getSubscription_terms());
			//action.sendText(home.getEmail(), "test@gmail.com");
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

