package stepDefinitions;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mainSteps {

	@Given("The user is on the login page")
	public void The_user_is_on_the_login_page() {
	    System.out.println("Cool given");
	}
	@When("The user added correct username {string} and password {string} clicked on login")
	public void the_user_added_correct_username_and_password_clicked_on_login(String username , String password ) {
		System.out.println(username + " and " + password );
	}	    
	@Then("Home page is displyed")
	public void Homepageisdisplyed() {
		System.out.println("Cool then");
	}
	@And("the cards are visible")
	public void thecardsarevisible() {
		System.out.println("Cool and");	    
	}
	
		
	@Given("Clear the data At start")
	public void clear_the_dataAtStart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubham Shetti\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); 
		  ChromeDriver driver=new ChromeDriver(); 
		  driver.manage().window().maximize(); 
		  driver.get("https://www.linkedin.com/login"); 
		  Thread.sleep(5000);
		  driver.close();
	}
	@Then("launch URl At start")
	public void launch_u_rlAtstat() {
		System.out.println("Launch the URL");
	}


}
