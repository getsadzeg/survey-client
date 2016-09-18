Feature: Inserting info to server
  Scenario: Invalid members
          Given I see an empty login form
          When I introduce an invalid members
          And  I press the login button
          Then I see an error message saying 'Invalid members'