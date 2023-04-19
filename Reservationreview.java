import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reservationreview {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino/index.php");
		driver.manage().window().maximize();
		
		//prijava 
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"section-about\"]/div/div/div/h4"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
				
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).click();
		driver.findElement(By.name("emailp")).sendKeys("hhhzzz@gmail.com");
	    driver.findElement(By.name("lozinkap")).sendKeys("12345");
		driver.findElement(By.name("btnprijava")).click();
				
	    //klik na pregled rezervacije
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).click();
	    boolean pregledrezervacije = driver.findElement(By.xpath("/html/body/section[2]")).isDisplayed();
		if(pregledrezervacije == true) {
			System.out.println("Elementi Pregled rezervacije su vidljivi");
		}
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name("id")));
		
		//pregled rezervacije po broju
		driver.findElement(By.name("id")).sendKeys("58");
		driver.findElement(By.name("btn")).click();
		boolean pregledrezervacijepobr = driver.findElement(By.className("pregledrezervacije")).isDisplayed();
		if(pregledrezervacijepobr == true) {
			System.out.println("Detalji rezervacije su vidljivi");
		}
		
		
 }
}