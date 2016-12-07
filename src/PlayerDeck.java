import java.util.ArrayList;
import java.util.Collections;

public class PlayerDeck {

    private ArrayList<Integer> deck;

    public PlayerDeck() {
        deck = new ArrayList<>();
        for(int i = 0; i < 52; i++)
        {
            deck.add(i);
        }
        deck.shuffle();
    }

    public ArrayList<Integer> getPlayerDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Integer> temp)
    {
        deck = temp;
        return;
    }


    public int getCard()
    {
        int card;
        if(deck.size() == 0)
        {
            return 0;
        }

        card = deck.get(0);
        deck.remove(0);
        return card;

    }


    public void shuffle()
    {
        Collections.shuffle(deck);
        return;
    }

}