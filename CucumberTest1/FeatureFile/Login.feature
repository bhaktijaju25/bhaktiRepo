Feature: Login functionality 
@data-driven 
Scenario: login with valid credentials 
	Given Navigate to next page 
	When user enters username and password 
	Then user logged in successfully 
	@user-specific
	Scenario Outline: login with valid credentials 
	Given Navigate to next page 
	When user enters "<username>" and "<password>" 
	Then user logged in successfully 
	
	Examples:
	|username|password|
	|lalitha|Password123|
	|ABC|XYZ|
@data-driven 
Scenario:
The one where user picks different product through search functionality 
	When Larry searches below products in search box: 
		|Headphone|
		|Carpet   |
	Then product should be added in cart if available 
	
 