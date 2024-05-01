public class Card {
    String cardSuit;
    int cardValue;

    public Card(String suit, int value)
    {
        if(suit.equals("Spades") || suit.equals("Diamonds") || suit.equals("Clubs") || suit.equals("Hearts"))
        {
            if(value >= 1 && value <= 13)
            {
                cardSuit = suit;
                cardValue = value;
            }
            else
            {
                System.out.println("Invalid value");
            }
        }
        else
        {
            System.out.println("Invalid suit");
        }
    }

    public String getSuit()
    {
        return cardSuit;
    }

    public int getValue()
    {
        return cardValue;
    }

    public String toString()
    {
        String cardString = "";
        if(cardValue == 1)
        {
            cardString = "Ace of " + cardSuit;
        }
        if(cardValue == 11)
        {
            cardString = "Jack of " + cardSuit;
        }
        if(cardValue == 12)
        {
            cardString = "Queen of " + cardSuit;
        }
        if(cardValue == 13)
        {
            cardString = "King of " + cardSuit;
        }
        if(cardValue > 1 && cardValue < 11)
        {
            cardString = cardValue + " of " + cardSuit;
        }
        return cardString;
    }
}
