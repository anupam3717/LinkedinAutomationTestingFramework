package object;

import org.openqa.selenium.By;
import resources.Base;

public class LoginObject extends Base {
	
     private By email=By.id("session_key");
     private By passwared=By.id("session_password");
     private By submit= By.xpath("//button[@class='sign-in-form__submit-button']");
     
    
     public void EnterMail(String s) {
    	 driver.findElement(email).sendKeys(s);
     }
     
     public void EnterPasswasrd(String s) {
    	 driver.findElement(passwared).sendKeys(s);
     }
     public void submit() {
    	 driver.findElement(submit).click();
     }
     
}
