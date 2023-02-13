package object;

import org.openqa.selenium.By;

import resources.Base;

public class Successful_login extends Base{
	 private By account=By.xpath("//span[@title='My Network']");
	 public boolean verify() {
				
	    return !driver.findElements(account).isEmpty();
	}
}
