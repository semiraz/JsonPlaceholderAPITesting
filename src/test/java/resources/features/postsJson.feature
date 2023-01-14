Feature: Validating JSON resources - E2E test flow
  As a user
  I want to create post, update it and delete them
  Background:
    Given New user is created

  Scenario Outline: E2E test flow
    Given List all posts for a user
    When User create post with name <name1>
    Then The post with name <name1> is "added"
    And The API call is success with a 201 status code
    When User update post with name <name2>
    Then The post with name <name2> is "updated"
    And The API call is success with a 200 status code
    And "id" in response body is 100
    When User delete post with delete request
    Then The post with name <name2> is "deleted"
    And The API call is success with a 200 status code

    Examples:
    |name1 | name2|
    |Book1 | Book2 |
    |Comment 1| Comment 2 |
