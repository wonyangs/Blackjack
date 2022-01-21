package blackjack.run;

import java.util.*;

public class Gamer {
    private ArrayList<Card> hand = new ArrayList<Card>();
    int money;
    
    Gamer() {
        money = 0;
    }
    
    public void draw(Card card) {
        hand.add(card);
    }
    
    public int handSize() {
        return hand.size();
    }
    
    public int point() {
        int sum = 0;
        for(int i=0; i<handSize(); i++) {
            sum += hand.get(i).point();
        }
        return sum;
    }
}
