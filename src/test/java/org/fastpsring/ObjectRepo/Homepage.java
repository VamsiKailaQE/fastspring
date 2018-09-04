package org.fastpsring.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	
	WebDriver driver;
	
	By subscription_terms=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/a[1]");
	By hide_subscription_terms=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/a[2]");
	By trial_period=By.xpath("//*[@id=\'PhotoCollage']/tbody/tr/td[3]/div/div[1]/div/div[2]/div[1]/span[2]");
	By quantity_select=By.xpath("//*[@id='PhotoCollage']/tbody/tr/td[3]/div/div[1]/div/div[1]/div/div/div[1]/select");
	By email=By.name("contact.email");
	By card_button=By.name("payment-option-type");
	
	
	

}
