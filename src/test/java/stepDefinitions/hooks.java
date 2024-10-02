package stepDefinitions;

import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class hooks {

	@Before("@smoketest")
	public void The_user_is_on_the_login_page() {
	    System.out.println("this is befor to smoketest ************** ");
	}
	
	@After("@smoketest")
	public void afterall() {
	    System.out.println("this is after to smoketest ************** ");
	}
}
