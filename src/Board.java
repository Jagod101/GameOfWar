import java.util.Collections;
import java.util.ArrayList;

public class Board {

    private ArrayList<Integer> deck1;
    private ArrayList<Integer> deck2;
    private ArrayList<Integer> origDeck;
    private int playingIndex1;
    private int playingIndex2;
    private int numBattles = 0;


    public Board() {
        deck1 = new ArrayList<>();
        deck2 = new ArrayList<>();
        origDeck = new ArrayList<>();
        playingIndex1 = 0;
        playingIndex2 = 0;

        for(int i = 2; i <= 14; i++)
        {
            origDeck.add(i);
            origDeck.add(i);
            origDeck.add(i);
            origDeck.add(i);
        }
        Collections.shuffle(origDeck);

        for(int i = 0; i < 52; i++)
        {
            if(i % 2 == 0 || i == 0) {
                deck1.add(origDeck.get(i));
            }
            else if(i % 2 == 1) {
                deck2.add(origDeck.get(i));
            }
        }


    }

    public ArrayList printOrigDeck()
    {
        return origDeck;
    }

    public ArrayList printDeck1()
    {
        return deck1;
    }
    public ArrayList printDeck2()
    {
        return deck2;
    }

    public int playCard(ArrayList<Integer> deck, int deckNumber)
    {
        if(deckNumber == 1) return deck1.get(0);
        else
        {
            return deck2.get(0);
        }

        /*
        int origIndex;
        int tempIndex;

        if(deckNumber == 1)
        {
            tempIndex = playingIndex1;
        }
        else if (deckNumber == 2)
        {
            tempIndex = playingIndex2;
        }
        else
        {
            tempIndex = 0;
        }

        if(deck.size() == 0)
        {
            return 0;
        }


        if(tempIndex == deck.size() - 1)
        {
            origIndex = tempIndex;
            tempIndex = 0;
            if(deckNumber == 1)
            {
                playingIndex1 = tempIndex;
            }
            else if (deckNumber == 2)
            {
                playingIndex2 = tempIndex;
            }
            return deck.get(origIndex);
        }
        else if(tempIndex != deck.size() - 1)
        {
            tempIndex++;
            if(deckNumber == 1)
            {
                playingIndex1 = tempIndex;
            }
            else if (deckNumber == 2)
            {
                playingIndex2 = tempIndex;
            }
            return deck.get(tempIndex - 1);
        }

        return 0;
       */
    }




    public String playGame()
    {
        int playCard1;
        int playCard2;
        int tempCard;

        while(deck1.size() != 0 && deck2.size() != 0) {
            System.out.println("Deck 1 size: " + deck1.size());
            System.out.println("Deck 2 size: " + deck2.size());
            playCard1 = deck1.get(0);
            playCard2 = deck2.get(0);
            numBattles++;
            if (playCard1 == playCard2) {
                goToWar();
            }
            else if(playCard1 > playCard2) {
                deck1.add(playCard2);
                deck2.remove(0);
                tempCard = deck1.remove(0);
                deck1.add(tempCard);
            }
            else if(playCard1 < playCard2) {
                deck2.add(playCard1);
                deck1.remove(0);
                tempCard = deck2.remove(0);
                deck2.add(tempCard);
            }
        }

        if(deck1.size() == 0)
        {
            return "Player 2 wins! Number of Battles: " + numBattles;
        }
        else if(deck2.size() == 0)
        {
            return "Player 1 wins! Number of Battles: " + numBattles;
        }
        return "";
    }


    public void goToWar()
    {
        ArrayList<Integer> warDeck1 = new ArrayList<>();
        ArrayList<Integer> warDeck2 = new ArrayList<>();
        int play1;
        int play2;
        boolean keepGoing = true;

        while(keepGoing) {

            if (deck1.size() == 1) {
                warDeck1.add(deck1.get(0));
                play1 = warDeck1.get(0);
            } else if (deck1.size() == 2) {
                warDeck1.add(deck1.get(0));
                warDeck1.add(deck1.get(1));
                play1 = warDeck1.get(1);
            } else if (deck1.size() == 3) {
                warDeck1.add(deck1.get(0));
                warDeck1.add(deck1.get(1));
                warDeck1.add(deck1.get(2));
                play1 = warDeck1.get(2);

            } else if(deck1.size() > 3) {
                warDeck1.add(deck1.get(0));
                warDeck1.add(deck1.get(1));
                warDeck1.add(deck1.get(2));
                warDeck1.add(deck1.get(3));
                play1 = warDeck1.get(3);
            }

            if (deck2.size() == 1) {
                warDeck2.add(deck2.get(0));
                play2 = warDeck2.get(0);
            } else if (deck2.size() == 2) {
                warDeck2.add(deck2.get(0));
                warDeck2.add(deck2.get(1));
                play2 = warDeck2.get(1);
            } else if (deck2.size() == 3) {
                warDeck2.add(deck2.get(0));
                warDeck2.add(deck2.get(1));
                warDeck2.add(deck2.get(2));
                play2 = warDeck2.get(2);
            } else if(deck2.size() > 3) {
                warDeck2.add(deck2.get(0));
                warDeck2.add(deck2.get(1));
                warDeck2.add(deck2.get(2));
                warDeck2.add(deck2.get(3));
                play2 = warDeck2.get(3);
            }

            if (play1 > play2) {
                deck1.addAll(warDeck2);
                deck2.removeAll(warDeck2);
                keepGoing = false;
            } else if (play2 > play1) {
                deck2.addAll(warDeck1);
                deck1.removeAll(warDeck1);
                keepGoing = false;
            } else if (play1 == play2) {
                keepGoing = true;
            }
        }

    }



}
