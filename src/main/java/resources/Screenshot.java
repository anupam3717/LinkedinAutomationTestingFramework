package resources;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends Base{
        public static void takeshot(String methodName){
        	Date d =new Date();
        	
        	String TimeStamp = d.toString().replace(":", "_").replace(" ", "_");
        	
        	File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	try {
				FileUtils.copyFile(src2, new File("Screenshots//"+ methodName + "_" + TimeStamp + ".png"));
			} catch (IOException e) {
				System.out.println(TimeStamp);
				e.printStackTrace();
			}

        
        }
}
