import java.util.ArrayList;

public class Board
{


    private PlayerDeck d1;
    private PlayerDeck d2;


    public Board()
    {
        d1 = new PlayerDeck();
        d2 = new PlayerDeck();
    }

    public void goToWar()
    {
        ArrayList<Integer> warDeck1 = new ArrayList<>();
        ArrayList<Integer> warDeck2 = new ArrayList<>();
        int play1;
        int play2;
        boolean keepGoing = true;

        while(keepGoing) {

            if (d1.getPlayerDeck().size() == 1) {
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 1));
                play1 = warDeck1.get(d1.getPlayerDeck().size() - 1);
            } else if (d1.getPlayerDeck().size() == 2) {
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 1));
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 2));
                play1 = warDeck1.get(d1.getPlayerDeck().size() - 1);
            } else if (d1.getPlayerDeck().size() == 3) {
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 1));
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 2));
                warDeck1.add(d1.getPlayerDeck().get(d1.getPlayerDeck().size() - 3));
                play1 = warDeck1.get(d1.getPlayerDeck().size() - 1);
            } else {
                warDeck1.add(d1.getPlayerDeck().get(0));
                warDeck1.add(d1.getPlayerDeck().get(1));
                warDeck1.add(d1.getPlayerDeck().get(2));
                play1 = warDeck1.get(d1.getPlayerDeck().get(4));
            }

            if (d2.getPlayerDeck().size() == 1) {
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 1));
                play2 = warDeck1.get(d2.getPlayerDeck().size() - 1);
            } else if (d2.getPlayerDeck().size() == 2) {
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 1));
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 2));
                play2 = warDeck1.get(d2.getPlayerDeck().size() - 1);
            } else if (d2.getPlayerDeck().size() == 3) {
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 1));
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 2));
                warDeck1.add(d2.getPlayerDeck().get(d2.getPlayerDeck().size() - 3));
                play2 = warDeck1.get(d2.getPlayerDeck().size() - 1);
            } else {
                warDeck1.add(d2.getPlayerDeck().get(0));
                warDeck1.add(d2.getPlayerDeck().get(1));
                warDeck1.add(d2.getPlayerDeck().get(2));
                play2 = warDeck1.get(d2.getPlayerDeck().get(4));
            }

            if (play1 > play2) {
                d1.getPlayerDeck().addAll(warDeck2);
                d2.getPlayerDeck().removeAll(warDeck2);
                keepGoing = false;
            } else if (play2 > play1) {
                d2.getPlayerDeck().addAll(warDeck1);
                d1.getPlayerDeck().removeAll(warDeck1);
                keepGoing = false;
            } else if (play1 == play2) {
                keepGoing = true;
            }
        }

    }

    public ArrayList<Integer> getDeck1()
    {
        return d1.getPlayerDeck();
    }

    public ArrayList<Integer> getDeck2()
    {
        return d2.getPlayerDeck();
    }

}