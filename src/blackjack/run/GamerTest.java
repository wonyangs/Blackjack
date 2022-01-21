package blackjack.run;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class GamerTest {
    private Gamer gamer;
    private Deck deck;
    
    @Before
    public void setup() {
        gamer = new Gamer();
        deck = new Deck();
    }
    
    @Test
    public void 카드뽑기() {
        gamer.draw(deck.takeTopCard());
        assertEquals(1, gamer.handSize());
        assertEquals(51, deck.deckSize());
    }
    
    @Test
    public void 현재점수() {
        gamer.draw(new Card("Spade", "A"));
        gamer.draw(new Card("Spade", "J"));
        assertEquals(21, gamer.point());
    }
}
