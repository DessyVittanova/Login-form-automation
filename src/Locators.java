import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Locators {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:/programs/geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); // тези две първи стъпки ще отворят браузъра
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //настройва браузъра да изчаква 5 секунди, за да изчака обектите да се покажат. те не са били на страницата до този момент                                      // синхронизираща настройка на браузъра, за да изчаква няколко секунди преди да потвърди, че даден тест е неуспешен
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); // тази стъпка отваря конкретната страница
		driver.findElement(By.id("inputUsername")).sendKeys("rahul"); //конкретизираме да търси локатор и да напише rahul чрез опцията sendKeys
		driver.findElement(By.name("inputPassword")).sendKeys("hello123"); //въвеода паролата, която е грешна
		driver.findElement(By.className("signInBtn")).click(); //натискане на бутона влез, но трябва да дава грешка в паролата или името
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // ще извади написаната грешка
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000); // задаваме време да изчакаме обект, който вече се е появил, но не може да се клика или разпознава от seleniuma - 1000 = 1 секунда
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Desi"); // xpath вързва с пътя до елемента, ако няма ясно разграничен локатор 
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("dudarraankataaabe@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); // действието clear изчиства въведеното от горния ред - специфицира се чрез [2] - номера на реда 
	    driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("dudarraankatabe@gmail.com"); // синтаксисът е различен при индивидуалното разпознаване на таговете :nth-child(3)
	    driver.findElement(By.xpath("//form/input[3]")).sendKeys("6559856652"); // използва техниката parent/child и се посочва чрез този код, че в тази конкретна форма искаме да въведем номер в третия ред 
	    driver.findElement(By.className("reset-pwd-btn")).click(); // натиска бутона за resert the password 
	    System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // техника на parent/child, но в cssSelector локатор - извежда текста за потвърждение в конзолата 
	    driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); // използват се три техники 
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
	    driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	    driver.findElement(By.id("chkboxOne")).click();
	    driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
	    
	    
	    
	    
	    
	    //driver.close();
	    
		
	}

}
