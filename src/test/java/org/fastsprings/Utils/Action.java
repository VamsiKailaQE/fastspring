package org.fastsprings.Utils;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Action {
	
	WebDriver driver;
	
	//Parameterized Constructor to manage the driver instance 
	public Action(WebDriver driver) {
		this.driver=driver; 
	}
	
	public void click(WebElement element) {
		try {
			
			Utils.explicitly_wait(driver, element);
			element.click();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void sendText(WebElement element, String text) {
		try {
			Utils.explicitly_wait(driver, element);
			element.sendKeys(text);
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	
	public String getText(WebElement element) {
		
		String text = null;
		try {
			Utils.explicitly_wait(driver, element);
			text=element.getText();
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}
	
	public void selectDropDown(WebElement element, String value) {
		
		try {
			Utils.explicitly_wait(driver, element);	
			Select sel=new Select(element);
			sel.selectByValue(value);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
			
		public void get_java_script_click(WebElement element) {
			WebElement elem = element;
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", elem);
			
		}
		
		
		
	
public void move_to_element(WebElement element) {
		
		try {
			Utils.explicitly_wait(driver, element);	
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			//element.click();
			
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}

public void hover_over_element(WebElement element) {
	Utils.explicitly_wait(driver, element);
	Actions hover = new Actions(driver);
    hover.moveToElement(element).build().perform();
}

public void verifyLinks(List<WebElement> elements) {
	
	   String url = "";
	   HttpURLConnection huc = null;
	   int respCode = 200;
	List<WebElement> links = elements;
    
    Iterator<WebElement> it = links.iterator();
    
    while(it.hasNext()){
        
        url = it.next().getAttribute("href");
        
        System.out.println(url);
    
        if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
            
        }

        }
        
        try {
            huc = (HttpURLConnection)(new URL(url).openConnection());
            
            huc.setRequestMethod("HEAD");
            
            huc.connect();
            
            respCode = huc.getResponseCode();
            
            if(respCode >= 400){
                System.out.println("\n"+url+" is a broken link");
            }
            else{
                System.out.println("\n"+url+" is a valid link");
            }
                
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
}
		
		
	}

