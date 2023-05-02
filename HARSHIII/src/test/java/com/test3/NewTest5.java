package com.test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest5 {

  ChromeOptions co=new ChromeOptions();
  WebDriver driver=new ChromeDriver(co);

 @Test
  public void test() {
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  WebElement name=driver.findElement(By.name("username"));
	  name.sendKeys("Suvitha");
	  WebElement pwd=driver.findElement(By.name("password"));
	  pwd.sendKeys("12345");
	  WebElement btn=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	  btn.click();
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String actual=driver.getCurrentUrl();
	  String expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  Assert.assertEquals(actual,expected);
  }
 
@BeforeMethod
public void setup() {
  WebDriverManager.chromedriver().setup();
  co.addArguments("--remote-allow-origins=*");
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  driver.manage().window().maximize();
}


@AfterMethod
public void teardown() {
  driver.close();
}

}