import java.util.Scanner;

public class Game {
    private Scanner input;
    private Deck deck;
    private Hand playerCards;
    private Hand dealerCards;

    public Game()
    {
        deck = new Deck();
        input = new Scanner(System.in);
        playerCards = new Hand();
        dealerCards = new Hand();
    }

    public void Play()
    {
        int quit = 1;
        int playerMoney = 10;

        while(quit == 1)
        {
            int bet = 0;
            int dummyBet;
            int dummy = 2;
            boolean bust = false;
            deck = new Deck();
            playerCards = new Hand();
            dealerCards = new Hand();
            int playerTotal = 0;
            int dealerTotal = 0;
            int win = 3;
            boolean tryAgain = true;

            while(tryAgain)
            {
                System.out.println("Your balance: $" + playerMoney);
                System.out.print("Please enter a bet: ");
                dummyBet = input.nextInt();
                if(dummyBet >= 0 && dummyBet <= playerMoney)
                {
                    bet = dummyBet;
                    System.out.println("You bet: $" + bet);
                    playerMoney -= bet;
                    break;
                }
                else
                {
                    System.out.println("Please enter a valid bet.");
                }
            }

            for(int i = 1; i < 3; i++)
            {
                playerCards.addCard(deck.deal());
                playerTotal += playerCards.getCardValue();
                System.out.println("Card " + i + ": " + playerCards.toString());
                dealerCards.addCard(deck.deal());
                dealerTotal += dealerCards.getCardValue();
            }

            System.out.println("Your total: " + playerTotal);
            System.out.println("Dealer's first card: " + dealerCards.toString());
            System.out.println("Dealer's second card: ???");

            while(dummy == 2)
            {
                System.out.println("Type 1 to stand or 2 to hit.");
                dummy = input.nextInt();
                if(dummy == 1 || dummy == 2)
                {
                    if(dummy == 2)
                    {
                        playerCards.addCard(deck.deal());
                        playerTotal += playerCards.getCardValue();
                        System.out.println("Your new card: " + playerCards.toString());
                        System.out.println("Your new total: " + playerTotal);
                    }
                    else
                    {
                        System.out.println("Your total is " + playerTotal);
                    }
                }
                else
                {
                    System.out.println("Please enter a valid number.");
                }
                if(playerTotal > 21)
                {
                    System.out.println("You bust...");
                    bust = true;
                    break;
                }
            }


            if(!bust)
            {
                System.out.println("The dealer's cards are: ");
                dealerCards.showAll();
                System.out.println();
                System.out.println("The dealer's total is: " + dealerTotal);
                System.out.println();
                while(dealerTotal < playerTotal)
                {
                    System.out.println("The dealer hits.");
                    dealerCards.addCard(deck.deal());
                    dealerTotal += dealerCards.getCardValue();
                    System.out.println("The dealer's new card: " + dealerCards.toString());
                    System.out.println("The dealer's new total: " + dealerTotal);
                }
            }

            if(dealerTotal > playerTotal && dealerTotal <= 21)
            {
                System.out.println();
                System.out.println("The dealer won...");
                System.out.println();
                win = 2;
            }
            if(dealerTotal > 21 && !bust)
            {
                System.out.println();
                System.out.println("The dealer bust!");
                System.out.println();
                win = 1;
            }
            if(win == 3 && !bust)
            {
                System.out.println();
                System.out.println("The dealer tied.");
                System.out.println();
            }

            if(win == 1)
            {
                System.out.println("You won! Congratulations. Your bet has been doubled.");
                playerMoney += (bet * 2);
                System.out.println("Your new balance: $" + playerMoney);
            }

            if(win == 2 || bust)
            {
                System.out.println("The dealer won and you lost your bet...");
            }

            if(win == 3 && !bust)
            {
                System.out.println("You tied the dealer. Your bet was returned.");
                playerMoney += bet;
                System.out.println("Your balance: $" + playerMoney);
            }

            if(playerMoney <= 0)
            {
                System.out.println("You ran out of money...");
                break;
            }
            else
            {
                System.out.println("Your balance: $" + playerMoney);
            }

            System.out.println("Would you like to play again? Press 1 for yes or 2 for no.");

            while(tryAgain)
            {
                dummy = input.nextInt();
                if(dummy == 1 || dummy == 2)
                {
                    quit = dummy;
                    tryAgain = false;
                }
                else
                {
                    System.out.println("Please enter a valid number.");
                }
            }

            if(quit == 2)
            {
                System.out.println("Goodbye!");
            }
            else
            {
                System.out.print('\u000C');
            }
        }
    }
}
