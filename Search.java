import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Search {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost/kino/index.php");
		driver.manage().window().maximize();
		
		//pretraga odredenog filma
		driver.findElement(By.name("keyword")).sendKeys("Joker");
		driver.findElement(By.className("search")).click();
		
		boolean film = driver.findElement(By.className("box1")).isDisplayed();
		if (film ==true) {
			System.out.println("Detalji filma su vidljivi");
		}
		
		//klik samog gumba search i prikaz svih filmova
		driver.findElement(By.className("search")).click();
		if (film ==true) {
			System.out.println("Detalji filmova su vidljivi");
		}
		
 }
}