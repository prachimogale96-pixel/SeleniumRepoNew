package actionsClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeysUpAndDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
			
		d.get("https://www.myntra.com/");
		Thread.sleep(2000);
		
		WebElement profile = d.findElement(By.xpath("//span[text()='Profile']")); 
		Thread.sleep(2000);
		
		Actions act = new Actions(d);
		act.moveToElement(profile);
		Thread.sleep(2000);
		
		WebElement login = d.findElement(By.xpath("//a[contains(text(),'login')]"));
		act.keyDown(Keys.CONTROL).click(login).perform();
		act.keyUp(Keys.CONTROL).perform();
		
		String expectedTitle="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		
		Set<String> allIds = d.getWindowHandles();
		for(String allWindow: allIds) {
			d.switchTo().window(allWindow);
		
			String actualTitle="Myntra";
			if(actualTitle.equals(expectedTitle)) {
				break;
				}
		}
		Thread.sleep(2000);
		WebElement signup = d.findElement(By.xpath("//input[@autocomplete='new-password']"));
		act.sendKeys(signup, "9860748732").perform();

	}

}
