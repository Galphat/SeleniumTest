package Selenium;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
    // System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");  
      
         // Instantiate a ChromeDriver class.     
    WebDriver driver=new ChromeDriver();  
      
       // Launch Website  
    driver.get("http://www.google.com/");
    //driver.navigate().to("http://www.javatpoint.com/");  
    System.out.println(driver.getTitle());
    String title = driver.getTitle();
    
   if(title.equals("Google")) 
	   System.out.println("Title is correct");
   else
	   System.out.println("Title not correct");
   System.out.println(driver.getCurrentUrl());
   
    driver.close();
	
 
}
}
