package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listener.TestListener;
import object.LoginObject;
import object.Successful_login;
import resources.Base;
import utlities.ReadXl;

@Listeners(TestListener.class)
public class Login extends Base {
	@BeforeMethod
	public void launch() throws Exception {
		initialize();
		String address = prop.getProperty("address");
		driver.get(address);
	}

	@Test(dataProviderClass = ReadXl.class, dataProvider = "provide")
	public void login(String mail, String passward) throws Exception {
		Logger log = LogManager.getLogger(Login.class.getName());
		// login
		log.info("login started");
		LoginObject page1 = new LoginObject();
		page1.EnterMail(mail);
		page1.EnterPasswasrd(passward);
		page1.submit();
		// checking

		Successful_login account = new Successful_login();
		Thread.sleep(6000);
		boolean check = account.verify();
		
		if (check == false) {
			log.error("email or passward error");
		}
		Assert.assertTrue(check);
		log.info("login successful");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
