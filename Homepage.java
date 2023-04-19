import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino/index.php");
		driver.manage().window().maximize();
		
		//klik na naslovnica
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[1]/a")).click();
		boolean naslovnica = driver.findElement(By.xpath("//*[@id=\"headerSlider\"]/div")).isDisplayed();
		if(naslovnica == true) {
			System.out.println("Elementi naslovnice su vidljivi");
		}
		//klik na o nama
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
		boolean onama = driver.findElement(By.xpath("//*[@id=\"section-about\"]/div/div/div/div")).isDisplayed();
		if(onama == true) {
			System.out.println("Elementi O nama su vidljivi");
		}
		//klik na filmovi
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[3]/a")).click();
		boolean filmovi = driver.findElement(By.xpath("//*[@id=\"section-filmovi\"]")).isDisplayed();
		if(filmovi== true) {
			System.out.println("Elementi Filmovi su vidljivi");
		}
		//klik na Kontakt
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[4]/a")).click();
		boolean kontakt = driver.findElement(By.xpath("//*[@id=\"section-contact\"]")).isDisplayed();
		if(kontakt == true) {
			System.out.println("Elementi Kontakt su vidljivi");
		}
		//gumb PRIJAVA   
		boolean prijava = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).isDisplayed();
		if(prijava == true) {
		   System.out.println("Gumb prijava je vidljiv");
		}
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
		//gumb ODJAVA
		boolean odjava = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[5]/a")).isDisplayed();
		if(odjava == true) {
			System.out.println("Gumb odjava je vidljiv");
		}
		
		
		
		
		
 }
}