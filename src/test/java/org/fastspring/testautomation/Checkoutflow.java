package org.fastspring.testautomation;
import org.fastsprings.Utils.Constants;
import org.fastsprings.Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Checkoutflow {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters({ "drivername" })
	public void setup(String drivertype) {
	try {
		driver=Utils.getDriver("chrome");
		Utils.ImplicitWait(driver, 10);
		driver.get(Constants.getCheckoutUrl());
		
	}
	catch(Exception e){
		
		e.printStackTrace();	
	}
	
	}
	
	@Test
	public void checkout() {
	
	
	}
	
	
	
	}

