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
        deck.shuffleCards();
    }

    public void shuffleCards()
    {
        Collections.shuffle(deck);
    }


    public ArrayList<Integer> getPlayerDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Integer> temp)
    {
        deck = temp;
        return;
    }

}