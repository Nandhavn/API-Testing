package testCases; 


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.DashBoardPageObjects;
import pageObjects.LoginPageObjects;

public class TestPendingLeaveRequest extends CommonFunctions{
	String actualMessage=null;


	public void login() {
		
		PageFactory.initElements(driver,LoginPageObjects.class);
		LoginPageObjects.username.sendKeys(properties.getProperty("username"));
		LoginPageObjects.password.sendKeys(properties.getProperty("password"));
		LoginPageObjects.loginbtn.click();

	}

	public void dashboardmessage() {
		PageFactory.initElements(driver,DashBoardPageObjects.class);
		actualMessage=DashBoardPageObjects.pending_Leave_Requests.getText();
		

	}

	@Test
	public void verifypendingRequest() {
		

		login();
		dashboardmessage();
		Assert.assertEquals(actualMessage,"No Records are Available");
		
 

	}


}

