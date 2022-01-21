package blackjack.run;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DeckTest {
    private Deck deck;
    
    @Before
    public void setup() {
        deck = new Deck();
    }
    
    @Test
    public void 생성자확인() {
        assertEquals(52, deck.deckSize());
    }
    
    @Test
    public void 카드한벌추가() {
        deck.addCards();
        assertEquals(104, deck.deckSize());
    }
    
    @Test
    public void 카드뽑기() {
        deck.takeTopCard();
        assertEquals(51, deck.deckSize());
    }
    
    @Test(expected = RuntimeException.class)
    public void 카드없는데뽑기() throws Exception {
        for(int i=0; i<52; i++) {
            deck.takeTopCard();
        }
        deck.takeTopCard();
        assertEquals(0, deck.deckSize());
    }
    
    @Test
    public void 카드점수() {
        Card card = new Card("Spade", "A");
        assertEquals(11, card.point());
        card = new Card("Spade", "J");
        assertEquals(10, card.point());
        card = new Card("Spade", "7");
        assertEquals(7, card.point());
    }
}
