package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchFirefox {

	public static void main(String[] args) {
    // System Property for Firefox Driver   
    System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");  
      
         // Instantiate a FirefoxDriver class.     
      
    WebDriver driver= new FirefoxDriver(); 
      
       // Launch Website  
    driver.get("http://www.google.com/");
    //driver.navigate().to("http://www.javatpoint.com/");  
    System.out.println(driver.getTitle());
    String title = driver.getTitle();
    //driver.findElement(By.tagName(title));
     //new WebDriverWait(driver, 0).until(ExpectedConditions.visibilityOf(null));
   
     if(title.equals("Google")) 
	   System.out.println("Title is correct");
   else
	   System.out.println("Title not correct");
   System.out.println(driver.getCurrentUrl());
   
    driver.close();
	
 
}
}
