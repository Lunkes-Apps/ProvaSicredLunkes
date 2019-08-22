#Author: Alexandre Lunkes

Feature: CRUD of customer list 
  As user
  I want update the customer list
  To save the customer information in data base

	Background: 
	 Given I have accessed the Bootstrap Theme page
	
  @functional 
  Scenario: Add a new customer   
    When I change the bootstrap version to "Bootstrap V4 Theme"
    And I access the Add Page 
    And I fill out the custormer's information
    |Teste Sicredi | Teste | Alexandre de Almeida Lunkes | 519999-9999 | Av Assis Brasil, 3970 | Torre D | Porto Alegre | RS | 91000-000 | Brasil | Fixter | 200 |
    And I click in save button
    Then Will show a menssage "Your data has been successfully stored into the database."
    
  @functional
  Scenario: Delete a customer   
    Given I change the bootstrap version to "Bootstrap V4 Theme"
    And I access the Add Page 
    And I fill out the custormer's information
    |Teste Sicredi | Teste | Alexandre de Almeida Lunkes | 519999-9999 | Av Assis Brasil, 3970 | Torre D | Porto Alegre | RS | 91000-000 | Brasil | Fixter | 200 |
    And I click in save button
    And Will show a menssage "Your data has been successfully stored into the database." 
		When I click in Go back to list
		And I search the name "Teste Sicredi"
		And I select all itens 
		And I click delete
		Then Will show a message to confirm delete
		When I click delete from popup 
		Then Will show a message after delete "Your data has been successfully deleted from the database."
  