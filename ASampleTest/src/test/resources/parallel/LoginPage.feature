Feature: Amazon login

Scenario Outline: Amazon Login Test Scenario

Given user is already on Login Page
When title of login page is Amazon
Then user enters "<sheetName>" and <rowNumber>
Then user clicks on login button
Then user is on home page
Then Search the product from list 
Then Close the browser


Examples:
	| sheetName | rowNumber |
	|login| 0 |
	