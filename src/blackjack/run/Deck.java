package blackjack.run;

import java.util.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    Deck() {
        addCards();
    }
    
    public int deckSize() {
        return cards.size();
    }
    
    public void addCards() {
        String[] patterns = {"Spade", "Diamond", "Heart", "Clover"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        
        for(int i=0; i<patterns.length; i++) {
            for(int j=0; j<nums.length; j++) {
                cards.add(new Card(patterns[i], nums[j]));
            }
        }
    }
    
    public Card takeTopCard() {
        cardsNullCheck();
        return cards.remove(randomIndex());
    }
    private int randomIndex() {
        Random random = new Random();
        return random.nextInt(deckSize());
    }
    private void cardsNullCheck() {
        if (deckSize() == 0) {
            throw new RuntimeException("Deck haven't any cards!");
        }
        return;
    }
}

class Card {
    private String pattern;
    private String num;
    
    Card(String pattern, String num) {
        this.pattern = pattern;
        this.num = num;
    }
    
    public int point() {
        switch(num) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(num);
        }
    }
}
