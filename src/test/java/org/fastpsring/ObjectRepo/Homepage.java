        package org.fastpsring.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
  WebDriver driver;
  
  

  By image=By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/img");
  By close=By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/button"); 
  
  By amount=By.xpath("//div[@class='price-row no-margin ng-scope']");
  By email=By.name("contact.email");
  By card_button=By.xpath("//span[contains(text(),'Credit / Debit Card')]");
  
  public Homepage(WebDriver driver) {
    this.driver=driver;
  }
  

  public WebElement get_subscription_terms(String productname) {
    //return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[3]/div/a[1]"));
    
    return driver.findElement(By.xpath("//a[contains(text(), ' Subscription terms ')]"));
   
  }
  public WebElement get_volume_discounts(String productname) {
    return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[3]/div/div[2]/div/div[3]/div[3]/small"));
  }
  
  public WebElement get_volume_amount(String productname) {
    return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[3]/div/div[2]/div/div[3]/div[3]/div"));
  }
  
  public WebElement gettrial_period(String productname) {
    return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[3]/div/div[1]/div/div[2]/div[1]/span[2]"));
  }
  public WebElement get_quantity_select(String productname) {
    return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[3]/div/div[1]/div/div/div/div/div[1]/select"));
  }
  public WebElement getamount() {
    return driver.findElement(amount);
  }
//  public WebElement getEmail() {
//    return driver.findElement(email);
//  }
  public WebElement getCard_button() {
    return driver.findElement(card_button);
  }
  public WebElement get_page_heading(String productname) {
    return driver.findElement(By.xpath("//*[@id="+'"'+productname+'"'+"]/tbody/tr/td[2]/div[1]/strong/a"));
    ////*[@id="PhotoCollage"]/tbody/tr/td[2]/div[1]/strong/a
  }
  
  public WebElement get_image() {
    return driver.findElement(image);
  }
  public WebElement get_close_button() {
    return driver.findElement(close);
  }
  

}