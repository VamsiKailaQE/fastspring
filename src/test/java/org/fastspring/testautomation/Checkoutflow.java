package org.fastspring.testautomation;
import org.testng.annotations.Test;
import org.fastsprings.Utils.Action;
import org.fastsprings.Utils.Constants;
import org.fastsprings.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.fastpsring.ObjectRepo.*;


public class Checkoutflow {
	
	WebDriver driver;
	
	String productname="PhotoCollage";
	
	@BeforeTest
	//@Parameters({ "drivername" })
	public void setup() {
	try {
		String drivername="chrome";
		driver=Utils.getDriver(drivername);
		driver.get(Constants.getCheckoutUrl()+productname);
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
			
			WebElement page_heading=home.get_page_heading(productname);
			action.click(page_heading);
			String page_heading_text=action.getText(page_heading);
			Assert.assertEquals(page_heading_text, "Photo Collage & Photo Editor","Description summary not Mathched");
			WebElement image=home.get_image();
			Assert.assertTrue(image.isDisplayed(), "Image Displayed");
			action.click(home.get_close_button());
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			action.get_java_script_click(home.get_subscription_terms(productname));
			
			action.hover_over_element(home.get_volume_discounts(productname));
			String amount=action.getText(home.get_volume_amount(productname));
			System.out.println(amount);
			Assert.assertTrue(amount.contains("10+   |   -$25.00\n" + 
					"30+   |   -$25.00"), "Quantity Discounts not displayed");
		    //System.out.println(amount1);
			
			action.verifyLinks(driver.findElements(By.tagName("a")));
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
			action.get_java_script_click(payment.getSave_button());
			WebElement element=payment.get_download_button();
			Assert.assertTrue(element.isDisplayed(), "Download button not displayed");

			String checkout_confirmation=action.getText(payment.getthankyoumsg());
			System.out.println(checkout_confirmation);
			Assert.assertTrue(checkout_confirmation.contains("Thank you"));
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		
	
	
	}
	
	
	
	}

