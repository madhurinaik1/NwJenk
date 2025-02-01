package com.pom.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginTest {
	WebDriver driver=null;
	public LoginPage lp=null;
	public DashboardPage dp=null;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/OldLapptopData/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		

	}
	@Test
	public void  test01() {
		LoginPage lp=new LoginPage(driver);
		
		 dp=lp.valid_Login();
		
//		lp.login_to_application("kiran@gmail.com","123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void  test02() {
		
		
		boolean flag=dp.titleee();
		Assert.assertTrue(flag);
		//	Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");

	}

	//@Test
	//public void test01() {
	//	DashboardPage dp=lp.valid_Login();
	//	boolean flag=dp.check_title();
	//	Assert.assertTrue(flag);
	//	
	//}

@Test
public void test03() {
	ArrayList<String> expectedCourses=new ArrayList<String>();
	expectedCourses.add("Selenium");
	expectedCourses.add("Java / J2EE");
	expectedCourses.add("Python");
	expectedCourses.add("Php");
	ArrayList<String> actualCourses=dp.verifyCorses();
	Assert.assertEquals(actualCourses,expectedCourses);
}

}
