@Smoke

Feature: Smoke

  Verification if it is possible to create an album, upload, update and delete photo inside an album

  Scenario Outline: E2E test flow
    Given user has created an account
    And user has created an album
    And user uploads a photo <url> with name <name>
    And a new album with photos is created
    When user updates a photo <url> with name <name>
    And a new photo is uploaded
    Then user deletes a photo
    And the photo is successfully deleted

  Examples:
  | url | name |
  | https://via.placeholder.com/600/92c952 | dog photo |
  | https://via.placeholder.com/600/92c876 | dog photo |