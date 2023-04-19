import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reservations {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino");
		driver.manage().window().maximize();
	
		
		//klik na filmovi
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
		boolean filmovi = driver.findElement(By.xpath("//*[@id=\"section-filmovi\"]")).isDisplayed();
		if(filmovi== true) {
		System.out.println("Elementi Filmovi su vidljivi");
		}
				
		driver.findElement(By.xpath("//*[@id=\"home-section-1\"]/div[2]/a")).click();
		boolean odaberi = driver.findElement(By.className("movies")).isDisplayed();
		if(odaberi == true) {
		System.out.println("Elementi pregleda filmova su vidljivi");
		}
     	
		//odabir jednog filma
		driver.findElement(By.name("odaberifilm")).click();
		WebElement film = driver.findElement(By.xpath("/html/body/div/form/select"));
		film.sendKeys(Keys.ARROW_DOWN);
		film.sendKeys(Keys.ENTER);
		driver.findElement(By.name("Pogledaj")).click();
		
		boolean detalji = driver.findElement(By.className("box1")).isDisplayed();
		if(detalji== true) {
			System.out.println("Detalji filma su vidljivi");
		}
		
		//pokusaj rezervacije karte prije prijave
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"indent-1\"]/div/div/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		
		driver.findElement(By.xpath("/html/body/a")).click();
		
		//prijava
		driver.findElement(By.name("emailp")).sendKeys("hhhzzz@gmail.com");
	    driver.findElement(By.name("lozinkap")).sendKeys("12345");
     	driver.findElement(By.name("btnprijava")).click();
     	
     	//pokusaj rezervacije karte nakon prijave
        	//klik na filmovi
     	driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
     	boolean filmovi1 = driver.findElement(By.xpath("//*[@id=\"section-filmovi\"]")).isDisplayed();
     	if(filmovi1== true) {
     	System.out.println("Elementi Filmovi su vidljivi");
     	}
     					
     	driver.findElement(By.xpath("//*[@id=\"home-section-1\"]/div[2]/a")).click();
     	if(odaberi == true) {
     	System.out.println("Elementi pregleda filmova su vidljivi");
     	}
     	     	
        //odabir jednog filma
     	driver.findElement(By.name("odaberifilm")).click();
     	WebElement film1 = driver.findElement(By.xpath("/html/body/div/form/select"));
     	film1.sendKeys(Keys.ARROW_DOWN);
     	film1.sendKeys(Keys.ENTER);
     	driver.findElement(By.name("Pogledaj")).click();
     			
     	
     	if(detalji== true) {
     	System.out.println("Detalji filma su vidljivi");
     	}
     	
     	//klik na rezerviraj
     	WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"indent-1\"]/div/div/a"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView();", Element1);
		Element1.click();
		
		//ispunjavanje rezervacije
		driver.findElement(By.name("prikazivanje")).click();
		driver.findElement(By.name("pr")).click();
		
		driver.findElement(By.name("fName")).sendKeys("Helena");
		driver.findElement(By.name("lName")).sendKeys("Zeko");
		driver.findElement(By.name("pNumber")).sendKeys("063444455");
		driver.findElement(By.name("submit")).click();
		
		boolean uspjesnarez = driver.findElement(By.xpath("/html/body/div/div[4]/div[3]/form")).isDisplayed();
		if (uspjesnarez == true){
	     	System.out.println("Rezervacija je uspjesna");
	     	}
 }
}