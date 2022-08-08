package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import pageObjects.UserRolePageObjects;

public class TestUserRole extends CommonFunctions {


	public void moveToUserPage() {

		Actions actions=new Actions(driver);
		actions.moveToElement(UserRolePageObjects.Admin);
		actions.moveToElement(UserRolePageObjects.user_management);
		actions.moveToElement(UserRolePageObjects.users);
		actions.click().build().perform();
	}

	public void selectUserRole() {

		Select selectrole=new Select(UserRolePageObjects.user_Role);
		selectrole.selectByIndex(1);

	}

	public void selectUserstatus() {

		Select selectStatus=new Select(UserRolePageObjects.user_Status);
		selectStatus.selectByIndex(1);
		
		

	}

	@Test
	public void  Checkuserrole() {


		PageFactory.initElements(driver, UserRolePageObjects.class);
		moveToUserPage();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		selectUserRole();
		selectUserstatus();
		UserRolePageObjects.searchButton.click();
		
		
		String actualRole=UserRolePageObjects.userrole_value.getText();
		
		String actualStatus=UserRolePageObjects.userstatus_value.getText();
		
		Assert.assertEquals(actualRole,"Admin");
		
		Assert.assertEquals(actualStatus,"Enabled");



	}

}
