package abstractParameters;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AbstractTestParameters {
public WebDriver driver;


	@BeforeMethod(alwaysRun = true)
	public void setUp() {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.hostinger.com/");
	driver.manage().window().maximize();
	}


	public void resultsToFile(String text, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName, true);//open file to write info
		BufferedWriter bw = new BufferedWriter(fw);//for text writing
		PrintWriter pw = new PrintWriter(bw);//to write in new line every time
		pw.println(text);
		pw.close();//close file
		}



	@AfterMethod(alwaysRun = true)
	public void cleanUp() throws InterruptedException {
		driver.manage().deleteAllCookies();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
