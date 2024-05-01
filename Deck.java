import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int currentCardIndex;

    public Deck()
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new ArrayList<>();
        currentCardIndex  = 0;       //first Card dealt is from position zero, then 1, then 2 etc...
        for (int count = 0; count < 52; count++)
        {
            deck.add(new Card(suits[count / 13], 1 + count % 13));
        }
        java.util.Collections.shuffle(deck);
    }

    public Card deal()
    {
        if(currentCardIndex > 51)
        {
            java.util.Collections.shuffle(deck);
            currentCardIndex = 0;
        }
        return deck.get(currentCardIndex++);
    }
}
