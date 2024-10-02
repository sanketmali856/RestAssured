package Package;

import org.openqa.selenium.chrome.ChromeDriver;

public class first {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		  // TODO Auto-generated method stub 
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubham Shetti\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
			  ChromeDriver driver=new ChromeDriver(); 
			  driver.manage().window().maximize(); 
			  driver.get("https://www.linkedin.com/login"); 
			  Thread.sleep(5000);
			  driver.close();

			  
	}

}
