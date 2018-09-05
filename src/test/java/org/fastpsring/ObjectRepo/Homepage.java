package org.fastpsring.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	WebDriver driver;
	
	//By subscription_terms=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/a[1]");
	By subscription_terms=By.xpath("//a[contains(text(), ' Subscription terms ')]");
	
	By hide_subscription_terms=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/a[2]");
	By trial_period=By.xpath("//*[@id=\'PhotoCollage']/tbody/tr/td[3]/div/div[1]/div/div[2]/div[1]/span[2]");
	By quantity_select=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/div[1]/div/div[1]/div/div/div[1]/select");
	By amount=By.xpath("//div[@class='price-row no-margin ng-scope']");
	By email=By.name("contact.email");
	By card_button=By.xpath("//span[contains(text(),'Credit / Debit Card')]");
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
	}
	

	public WebElement getSubscription_terms() {
		return driver.findElement(subscription_terms);
	}
	public WebElement getHide_subscription_terms() {
		return driver.findElement(hide_subscription_terms);
	}
	public WebElement getTrial_period() {
		return driver.findElement(trial_period);
	}
	public WebElement getQuantity_select() {
		return driver.findElement(quantity_select);
	}
	public WebElement getamount() {
		return driver.findElement(amount);
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getCard_button() {
		return driver.findElement(card_button);
	}
	

	

}
