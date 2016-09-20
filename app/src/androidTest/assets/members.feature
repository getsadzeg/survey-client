Feature: Inserting info to server


 Background:
		Given I see an empty login form

  Scenario: Invalid members
          When I introduce an invalid members
          And  I press the login button
          Then I see an error message saying 'Invalid members'