import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    int cardIndex;

    public Hand()
    {
        hand = new ArrayList<>();
        cardIndex = -1;
    }

    public void addCard(Card c)
    {
        hand.add(c);
        cardIndex++;
    }

    public int getCardValue()
    {
        int value;
        value = hand.get(cardIndex).getValue();
        if(value > 10)
        {
            value = 10;
        }
        return value;
    }

    public void showAll()
    {
        for(Card i: hand)
        {
            System.out.println(i);
        }
    }

    public String toString()
    {
        String returnString;
        if(cardIndex >= 0)
        {
            returnString = hand.get(cardIndex).toString();
            return returnString;
        }
        return "Empty";
    }
}
