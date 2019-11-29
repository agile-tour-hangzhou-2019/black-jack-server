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
