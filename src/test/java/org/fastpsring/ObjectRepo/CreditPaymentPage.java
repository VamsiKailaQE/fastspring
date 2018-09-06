package org.fastpsring.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditPaymentPage {
	
	WebDriver driver;
	public CreditPaymentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By firstname=By.name("contact.firstName");
	By lastname=By.name("contact.lastName");
	//By email=By.name("contact.email");
	By email=By.xpath("//*[@id='app']/div[4]/div/div/form/fieldset/div[2]/div[2]/div[2]/div/div/div/input");
	By card_number=By.name("card.number");
	By exp_month=By.name("card.month");
	By exp_year=By.name("card.year");
	By cvc=By.id("card-security");
	By billing_address=By.name("contact.addressline1");
	By city=By.id("contact-city");
	By state_select=By.name("contact.region");
	By zip_code=By.id("contact-postal");
	By contact_phone=By.id("contact-phone");
	By save_button=By.xpath("//*[@id=\"app\"]/div[4]/div/div/form/fieldset/div[3]/button/span");	
	By thank_you_msg=By.xpath("//*[@id=\"content\"]/div/div[1]/h3");
	By download_button=By.xpath("//*[@id=\"PhotoCollage\"]/td[2]/div[3]/div[1]/div/button");
	public WebElement getFirstname() {
		
		return driver.findElement(firstname);
		
	}
	public WebElement getLastname() {
		return driver.findElement(lastname);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getCard_number() {
		return driver.findElement(card_number);
	}
	public WebElement getExp_month() {
		return driver.findElement(exp_month);
	}
	public WebElement getExp_year() {
		return driver.findElement(exp_year);
	}
	public WebElement getCvc() {
		return driver.findElement(cvc);
	}
	public WebElement getBilling_address() {
		return driver.findElement(billing_address);
	}
	public WebElement getCity() {
		return driver.findElement(city);
	}
	public WebElement getState_select() {
		return driver.findElement(state_select);
	}
	public WebElement getZip_code() {
		return driver.findElement(zip_code);
	}
	public WebElement getContact_phone() {
		return driver.findElement(contact_phone);
	}
	public WebElement getSave_button() {
		return driver.findElement(save_button);
	}
	public WebElement getthankyoumsg() {
		return driver.findElement(thank_you_msg);
	}
	public WebElement get_download_button() {
		return driver.findElement(download_button);
	}
	
	
	

}
