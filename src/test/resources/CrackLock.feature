Feature: Guess code(s) scenarios

  Scenario: Crack lock with these hints
    Given [6,9,0] One number is correct and in the right place
    Given [7,4,1] One number is correct but in the wrong place
    Given [5,0,4] Two numbers are correct but in the wrong place
    Given [3,8,7] Nothing is correct
    Given [2,1,9] One number is correct but in the wrong place
    When Crack lock
    Then Codes should be [150,420,495]