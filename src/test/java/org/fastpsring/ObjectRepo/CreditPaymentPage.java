package org.fastpsring.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreditPaymentPage {
	
	WebDriver driver;
	
	By firstname=By.name("contact.firstName");
	By lastname=By.name("contact.lastName");
	By card_number=By.name("card.number");
	By exp_month=By.name("card.month");
	By exp_year=By.name("card.year");
	By cvc=By.id("card-security");
	By billing_address=By.name("contact.addressline1");
	By state=By.name("contact.addressline1");
	By state_select=By.name("contact.region");
	By zip_code=By.id("contact-postal");
	By contact_phone=By.id("contact-phone");
	By save_button=By.xpath("//*[@id=\"app\"]/div[4]/div/div/form/fieldset/div[3]/button");

}
