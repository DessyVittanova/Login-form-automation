import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "rahul";
		System.setProperty("webdriver.gecko.driver", "D:/programs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); // тези две първи стъпки ще отворят браузъра
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //настройва браузъра да изчаква 5 секунди, за да изчака обектите да се покажат. те не са били на страницата до този момент                                      // синхронизираща настройка на браузъра, за да изчаква няколко секунди преди да потвърди, че даден тест е неуспешен
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // тази стъпка отваря конкретната страница
		driver.findElement(By.id("inputUsername")).sendKeys(name); //конкретизираме да търси локатор и да напише rahul чрез опцията sendKeys
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"); //въвеода паролата, която е грешна
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText()); // локатор tagName - използва се когато има само един такъв таг в целия html код
	    Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in."); //ВАЖНО ЗА АВТОМАТИЗАЦИЯТА - ТОЗИ КОД ПРОВЕРЯВА ОЧАКВАНИЯ РЕЗУЛТАТ С РЕАЛНИЯ !!! 
	    Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
	    driver.findElement(By.xpath("//*[text()='Log Out']")).click();
	    driver.close();
	    
	
	
	}

}

