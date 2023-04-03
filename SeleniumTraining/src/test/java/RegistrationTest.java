import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).click();
		
		//pokusaj registrtacije s pogresnim emailom (npr.samo brojevi)
		driver.findElement(By.name("ime")).sendKeys("Ana");
		driver.findElement(By.name("prezime")).sendKeys("Anic");
		driver.findElement(By.name("email")).sendKeys("1232244");
		driver.findElement(By.name("lozinka")).sendKeys("lozinka");
		driver.findElement(By.name("btnreg")).click();
		
		boolean invalidreg = driver.findElement(By.cssSelector("div.alert.alert-danger")).isDisplayed();
	    if(invalidreg == true) {
	    	System.out.println("Email greška");
	    }
	    
	    //registracija s već postojećim podacima
     	driver.findElement(By.name("ime")).sendKeys("Ana");
 		driver.findElement(By.name("prezime")).sendKeys("Anic");
 		driver.findElement(By.name("email")).sendKeys("anaa.a@gmail.com");
 		driver.findElement(By.name("lozinka")).sendKeys("lozinka");
 		driver.findElement(By.name("btnreg")).click();
 		
 		boolean invalidreg1 = driver.findElement(By.cssSelector("div.alert.alert-danger")).isDisplayed();
 	    if(invalidreg1 == true) {
 	    	System.out.println("Taj email već postoji");
 	    }
	   
	    //uspješna registracija
	    driver.findElement(By.name("ime")).sendKeys("Ana");
		driver.findElement(By.name("prezime")).sendKeys("Anic");
		driver.findElement(By.name("email")).sendKeys("anaa2.a@gmail.com");
		driver.findElement(By.name("lozinka")).sendKeys("lozinka");
		driver.findElement(By.name("btnreg")).click();
		
		boolean successreg = driver.findElement(By.cssSelector("div.alert.alert-success")).isDisplayed();
	    if(successreg == true) {
	    	System.out.println("Uspješna registracija");
	    }
	    
	    driver.findElement(By.name("emailp")).sendKeys("ana.a@gmail.com");
	    driver.findElement(By.name("lozinkap")).sendKeys("lozinka");
     	driver.findElement(By.name("btnprijava")).click();
		
     	
 }
}