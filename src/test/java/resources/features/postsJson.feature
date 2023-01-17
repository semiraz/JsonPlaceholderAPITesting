Feature: Validating JSON resources - E2E test flow
  As a user
  In order to post photos I would like to be able to create an album with photos, updated them and deleted

  Scenario: E2E test flow
    Given User has created an account
    When User create a post
    And Create an album
    And Post a photo with title dog photo
    Then New album with photos is created
    When User update a post and delete a photo
    Then Post is successfully changed
    And Photo is successfully deleted