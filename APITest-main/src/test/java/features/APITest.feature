Feature: Test Github API

  Scenario Outline: User is able to validate the Github API Response

    Given User sets the base API Request "<URL>"
    And User authenticates the API request with "<token>"
    When User sends the API request to get all the repositories
    Then User validates the response status is "<code>"

    Examples:
    |URL                   | token                              | code |
    |https://api.github.com| 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  | 200  |