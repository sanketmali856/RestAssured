Feature: Application login.

Background: 
Given Clear the data At start
Then launch URl At start

@smoketest
Scenario: Admin page login 

Given The user is on the login page 
When The user added correct username "9090cool" and password "cool9090" clicked on login
Then Home page is displyed
And the cards are visible
 


  

