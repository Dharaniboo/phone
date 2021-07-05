
Feature: Login Feature
  Verify if user is able to Login in to the site


Scenario: Login as a authenticated user
Given user is on homepage
When user click login
Then it will navigate to login page
And user enters email_id and password


Scenario: user search for product
Given user is on homepage
When user search product
Then it will show list of particular products  


