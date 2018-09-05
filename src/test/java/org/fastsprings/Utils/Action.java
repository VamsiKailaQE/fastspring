package org.fastsprings.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Action {
	
	WebDriver driver;
	
	//Parameterized Constructor to manage the driver instance 
	public Action(WebDriver driver) {
		this.driver=driver; 
	}
	
	public void click(WebElement element) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(element.isDisplayed());
			element.click();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void sendText(WebElement element, String text) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(element.isDisplayed());
			element.sendKeys(text);
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	
	public String getText(WebElement element) {
		
		String text = null;
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(element.isDisplayed());
			text=element.getText();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}
	
	public void selectDropDown(WebElement element, String value) {
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(element.isDisplayed());	
			Select sel=new Select(element);
			sel.selectByValue(value);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
public void move_to_element(WebElement element) {
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(element.isDisplayed());	
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}

