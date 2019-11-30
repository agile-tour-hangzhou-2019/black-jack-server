package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.util.RestfulHelper;
import mob.code.blackjack.BlackjackServerApplication;
import mob.code.blackjack.controller.GameController;
import mob.code.blackjack.service.Deck;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = BlackjackServerApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlackjackStep {

    @LocalServerPort
    private int port;
    @Autowired
    private GameController gameController;

    private ResponseEntity<String> response;

    @When("^I ping the server$")
    public void i_ping_the_server() throws Throwable {
        response = RestfulHelper.connect(port).get("/ping");
    }

    @Then("^the server will response$")
    public void the_server_will_response() throws Throwable {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("pong", response.getBody());
    }

    @When("I ask example cards")
    public void i_ask_example_cards() {
        response = RestfulHelper.connect(port).get("/card");
    }

    @Then("^the server will response:$")
    public void the_server_will_response(String json) throws Throwable {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        JSONAssert.assertEquals(json, response.getBody(), true);
    }

    @When("I start game")
    public void i_start_game() {
        response = RestfulHelper.connect(port).get("/startgame");
    }

    @Given("deck is [{string},{string},{string},{string}]")
    public void deck_is(String string, String string2, String string3, String string4) {
        Deck deck = mock(Deck.class);
        when(deck.nextCard()).thenReturn(string, string2, string3, string4);
        gameController.deck = deck;
    }
}
