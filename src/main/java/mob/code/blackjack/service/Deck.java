package mob.code.blackjack.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Deck {
    public static final String[] CARDS={"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AD", "AE",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BD", "BE",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CD", "CE",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DD", "DE"};
    private final List<String> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        this.cards.addAll(Arrays.asList(CARDS));

    }
    public String nextCard() {
        return this.cards.remove(0);
    }
}
