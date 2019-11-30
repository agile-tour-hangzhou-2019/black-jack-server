Feature: black jack

  Scenario: ping
    When I ping the server
    Then the server will response

  Scenario: example cards
    When I ask example cards
    Then the server will response:
        """
        [A0, B1]
        """

  Scenario: start game
    Given deck is ["A2","A0","B2","A3"]
    When I start game
    Then the server will response:
        """
        [{"role_name":"banker","cards":["A0","A3"]},
        {"role_name":"player","cards":["A2","B2"]}]
        """