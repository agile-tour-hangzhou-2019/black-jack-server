package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.util.RestfulHelper;
import mob.code.blackjack.BlackjackServerApplication;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = BlackjackServerApplication.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BlackjackStep {

    @LocalServerPort
    private int port;

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
}
