package practiceProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DepIndeAmazonEx {

	public static void main(String [] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
				
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		//click on search bar
		WebElement searchbox = d.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("laptop");
		Thread.sleep(2000);
				
		//click on search button
		d.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(2000);
	}
}

//div[@class='Fish']/parent ::div[@class='Vertebrate']/parent ::div[@class='Animal']/child::div[@class='Invertebrate']



//div[starts-with(text(),'Nokia 5310 Dual SIM')]/ancestor ::span[@text()='Add to Compare']