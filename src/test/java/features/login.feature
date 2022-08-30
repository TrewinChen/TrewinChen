#Author
@tag
Feature: Login Process

  @Regression
  Scenario: Login to demo page
    Given The Page is displayed
    When I enter the username with 'Trewin'
    And I enter the email with 'trewin@123.com'
    And I enter the website with 'trewin.com.sg'
    And I select the years of experience
    And I choose the expertise
    And I choose the education
    And I enter the comments with:
  """
  Dear All,
  
  How is everything? Nice to have you here.
  
  Regards
  QQ
  """ 
  Then I click on the submit button

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
