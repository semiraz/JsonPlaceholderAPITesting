Feature: Validating JSON resources - E2E test flow
#  As a user
#  I want to create comments, update it and delete them

  Scenario Outline: E2E test flow
    Given New user is created
    When User "create" comments with "post" request
    Then The comment with name "<name1>" is "added"
    And The API call is success with a 201 status code
    When User "update" comments with "put" request
    Then The comment with name "<name2>" is "updated"
    And The API call is success with a 201 status code
    And "id" in response body is 11
    When User "delete" post with "delete" request
    Then The comment with name "<name2>" is "deleted"
    And The API call is success with a 200 status code

    Examples:
    |name1 | name2|
    |Book1 | Book2 |
    |Comment 1| Comment 2 |
