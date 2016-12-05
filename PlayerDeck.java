import java.util.ArrayList;

public class playerDeck
{
    private ArrayList<Integer> playerDeck;
    
    public playerDeck()
    {
        playerDeck = new ArrayList<>();
    }

    public ArrayList<Integer> getPlayerDeck()
    {
        return playerDeck;
    }

    public goToWar()
    {
        if (playerDeck.size() < 4)
        {
            return playerDeck.get(playerDeck.size()-1);
        }

        
    }
}