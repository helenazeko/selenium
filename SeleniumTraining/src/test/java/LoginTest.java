import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).click();
		
		driver.findElement(By.name("emailp")).sendKeys("ttt@gmail.com");
		driver.findElement(By.name("lozinkap")).sendKeys("1234567");
		driver.findElement(By.name("btnprijava")).click();
		boolean invalidlogin = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/h2")).isDisplayed();
		System.out.println(invalidlogin);
		
		if(invalidlogin == true) {
			driver.findElement(By.name("emailp")).sendKeys("hhhzzz@gmail.com");
		    driver.findElement(By.name("lozinkap")).sendKeys("12345");
	     	driver.findElement(By.name("btnprijava")).click();
	
	     	String currenturl = driver.getCurrentUrl();
	    	System.out.println(currenturl); 
		
		    driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[6]/a")).click();
	    	String currenturl1 = driver.getCurrentUrl();
		    System.out.println(currenturl1); 
		   }
		else {
			driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[6]/a")).click();
			String currenturl1 = driver.getCurrentUrl();
			System.out.println(currenturl1); 
		   }
		
 }
}