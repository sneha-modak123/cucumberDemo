package cm.cg.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.testbase.TestBase;
import com.cg.utils.ExcelUtils;

public class Login extends TestBase{
	
	
	
public static void main(String[] args) {
	TestBase Base=new TestBase();
		Base.init();
		WebElement userName = driver.findElement(By.id("user_login"));
		WebElement pwd = driver.findElement(By.id("user_pass"));

		
        String projectPath = System.getProperty("user.dir");
		ExcelUtils reader = new ExcelUtils(projectPath +"/Excel/SampleExcel.xlsx");
		String sheetName = "login";
		
		int rowCount = reader.getRowCount(sheetName);

		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String loginId = reader.getCellData(sheetName, "username", rowNum);
			String passsword = reader.getCellData(sheetName, "password", rowNum);

			System.out.println(loginId + " " + passsword);
			
			userName.clear();
			userName.sendKeys(loginId);
			
			pwd.clear();
			pwd.sendKeys(passsword);
			
			
		}
		
		
		
	}


}
