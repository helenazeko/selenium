import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Movie {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino/index.php");
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
		
		driver.findElement(By.name("odaberifilm")).click();
		WebElement film = driver.findElement(By.xpath("/html/body/div/form/select"));
		film.sendKeys(Keys.ARROW_DOWN);
		film.sendKeys(Keys.ENTER);
		driver.findElement(By.name("Pogledaj")).click();
		
		boolean detalji = driver.findElement(By.className("box1")).isDisplayed();
		if(detalji== true) {
			System.out.println("Detalji filma su vidljivi");
		}
		
		
 }
}