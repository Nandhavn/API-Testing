package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObjects {

	@FindBy(linkText="Admin")
	public static WebElement Admin;
	@FindBy(linkText="User Management")
	public static WebElement user_management;
	@FindBy(linkText="Users")
	public static WebElement users;
	@FindBy(id="searchSystemUser_userType")
	public static WebElement user_Role;
	@FindBy(id="searchSystemUser_status")
	public static WebElement user_Status;
	@FindBy(id="searchBtn")
	public static WebElement searchButton;
	@FindBy(xpath="//tr/td[3]")
	public static WebElement userrole_value;
	@FindBy(xpath="//tr/td[5]")
	public static WebElement userstatus_value;
	
	
}

