Feature: Verification if it is possible to create an album, upload, update and delete photo inside an album

  Scenario Outline: E2E test flow
    Given User has created an account
    And Created an album
    When Upload a photo <url> with name <name>
    Then New album with photos is created
    When User update a photo <url> with name <name>
    Then New photo is uploaded
    When User delete a photo
    Then Photo is successfully deleted

  Examples:
  | url | name |
  | https://via.placeholder.com/600/92c952 | dog photo |
  | https://via.placeholder.com/600/92c876 | dog photo |