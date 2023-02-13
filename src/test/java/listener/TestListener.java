package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Work.testng.Screenshot;

public class TestListener extends resources.Screenshot implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		try {
			takeshot(result.getMethod().getMethodName()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
