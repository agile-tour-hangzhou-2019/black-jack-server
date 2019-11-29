package mob.code.blackjack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class GameController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("card")
    public List<String> card() {
        //See https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
        return Arrays.asList("A0","B1");
    }

}
