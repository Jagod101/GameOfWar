import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Integer> deck1;
    private ArrayList<Integer> deck2;
    private ArrayList<Integer> origDeck;
    private int playingIndex1;
    private int playingIndex2;
    private int numBattles = 0;
    private int numDWars = 0;
    private int numWars = 0;


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
    }




    public String playGame()
    {
        int playCard1;
        int playCard2;
        int tempCard;

        while(deck1.size() != 0 && deck2.size() != 0) {
            System.out.println("Deck 1 size: " + deck1.size());
            System.out.println("Deck 2 size: " + deck2.size());
            System.out.println("");
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
        numWars++;
        ArrayList<Integer> warDeck1 = new ArrayList<>();
        ArrayList<Integer> warDeck2 = new ArrayList<>();
        int play1 = 0;
        int play2 = 0;
        boolean keepGoing = true;

        warDeck1.add(deck1.get(0));
        warDeck2.add(deck2.get(0));
        warDeck1.remove(0);
        warDeck2.remove(0);

        while(keepGoing)
        {
            if (deck1.size() == 0) {
                play1 = warDeck1.get(0);
            } else if (deck1.size() == 1) {
                warDeck1.add(deck1.get(0));
                play1 = deck1.get(0);
                deck1.remove(0);
            } else if (deck1.size() >= 2) {
                warDeck1.add(deck1.get(0));
                warDeck1.add(deck1.get(1));
                play1 = deck1.get(1);
                deck1.remove(1);
                deck1.remove(0);

            }

            if (deck2.size() == 0) {
                play2 = warDeck2.get(0);
            } else if (deck2.size() == 1) {
                warDeck2.add(deck2.get(0));
                play2 = deck2.get(0);
                deck2.remove(0);
            } else if (deck2.size() >= 2) {
                warDeck2.add(deck2.get(0));
                warDeck2.add(deck2.get(1));
                play2 = deck2.get(1);
                deck2.remove(1);
                deck2.remove(0);
            }

            if(play1 > play2)
            {
                deck2.addAll(warDeck1);
                deck2.addAll(warDeck2);
                keepGoing = false;
            }
            else if(play2 > play1)
            {
                deck1.addAll(warDeck2);
                deck1.addAll(warDeck1);
                keepGoing = false;
            }
            else if(play1 == play2)
            {
                numDWars++;
                keepGoing = true;
            }

        }


    }
    

    public int getNumBattles()
    {
        return numBattles;
    }

    public int getNumDWars()
    {
        return numDWars;
    }

    public int getNumWars()
    {
        return numWars;
    }

}
