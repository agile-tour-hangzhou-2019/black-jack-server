package mob.code.blackjack.controller;

import mob.code.blackjack.bean.Game;
import mob.code.blackjack.service.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class GameController {

    @Autowired
    public Deck deck;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("card")
    public List<String> card() {
        //See https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
        return Arrays.asList("A0","B1");
    }

    @GetMapping("startgame")
    public List<Game> startGame() {
        //See https://en.wikipedia.org/wiki/Playing_cards_in_Unicode

        Game banker = new Game("banker", new ArrayList<>());
        Game player = new Game("player", new ArrayList<>());
        player.getCards().add(deck.nextCard());
        banker.getCards().add(deck.nextCard());
        player.getCards().add(deck.nextCard());
        banker.getCards().add(deck.nextCard());
        return Arrays.asList(banker, player);
    }

}
