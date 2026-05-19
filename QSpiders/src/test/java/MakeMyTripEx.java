import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripEx {

	public static void main(String[] args) throws InterruptedException {
	
	WebDriver d=new ChromeDriver();
	d.manage().window().maximize();
	
	d.get("https://www.makemytrip.com/");
	Thread.sleep(1000);
	
	d.findElement(By.className("commonModal__close")).click();
	Thread.sleep(1000);
	
	d.findElement(By.id("fromCity")).click();
	Thread.sleep(1000);
	//Enter on "From" location
	d.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Del");
	Thread.sleep(2000);
	
	WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li")));
	
	//Select specific suggestion
	List<WebElement> list = d.findElements(By.xpath("//ul/li"));
	
	for(WebElement res: list) {
		if(res.getText().contains("Delhi")) {
			res.click();
			break;
		}
	}

	}

}
