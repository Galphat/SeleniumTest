package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarSelect {

	static WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
		 // System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");  
	      
	         // Instantiate a ChromeDriver class.     
	     driver=new ChromeDriver();  
	      
	       // Launch Website , maximize browser and wait to load page
	    driver.get("https://www.goibibo.com/");
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    System.out.println(driver.getTitle());
	    
	    //Click on calendar pickUp
	    driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //Pass desire date to select on calendar pickUp by passing the date, month and year 
	   selectDate("31", "March", "2022");

	}
	
	//method to separate month and year in a string from calendar pickUp 
	public static String[] getMonthYear(String monthYearValue) {
		return monthYearValue.split(" ");
		
	}
     
	public static void selectDate(String exDate, String exMonth, String exYear) {
		
		if (exMonth.equals("February") && Integer.parseInt(exDate)>29) {
			System.out.println("Wrong date entered :- "+exDate+" "+ exMonth);
			return;
		}
		
		if (Integer.parseInt(exDate)>31) {
			System.out.println("Wrong date entered :- "+exDate);
			return;
		}
		
		 String monthYearValue = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		    System.out.println(monthYearValue);
		    
		    while(!(getMonthYear(monthYearValue)[0].equals(exMonth) 
		    		&& getMonthYear(monthYearValue)[1].equals(exYear))) {
		    	driver.findElement(By.xpath("//span[contains(@class, 'DayPicker-NavButton DayPicker-NavButton--next')]")).click();
		    	 
		    	monthYearValue = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
			    
		    }
		    try {
		    driver.findElement(By.xpath("//div[text()='"+exDate+"']")).click();
		    }
		    catch (Exception e) {
		    	System.out.println("Wrong date entered :- "+exDate+" "+ exMonth);
			}
		    driver.close();
		
	}
}
