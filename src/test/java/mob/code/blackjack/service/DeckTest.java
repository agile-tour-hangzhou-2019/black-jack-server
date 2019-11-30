package mob.code.blackjack.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeckTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAllCards() {
        //given
        Deck deck = new Deck();
        Set<String> cards = new HashSet<>();
        for (int i=0;i<52;i++){
            cards.add(deck.nextCard());
        }
        //expect

        Set<String> expected = new HashSet<>();
        expected.addAll(Arrays.asList(
                "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AD", "AE",
                "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BD", "BE",
                "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CD", "CE",
                "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DD", "DE"
        ));
        assertEquals(expected, cards);

    }
}