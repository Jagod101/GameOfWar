public class Board
{


    private PlayerDeck d1;
    private PlayerDeck d2;


    public Board()
    {
        PlayerDeck d1 = new PlayerDeck();
        PlayerDeck d2 = new PlayerDeck();
    }

    public void goToWar(PlayerDeck deck1, PlayerDeck deck2)
    {
        ArrayList<Integer> warDeck1 = new ArrayList<>();
        ArrayList<Integer> warDeck2 = new ArrayList<>();
        int play1;
        int play2;
        boolean keepGoing = true;

        while(keepGoing) {

            if (deck1.size() == 1) {
                warDeck1.add(deck1.get(deck1.size() - 1));
                play1 = warDeck1.get(deck1.size() - 1);
            } else if (deck1.size() == 2) {
                warDeck1.add(deck1.get(deck1.size() - 1));
                warDeck1.add(deck1.get(deck1.size() - 2));
                play1 = warDeck1.get(deck1.size() - 1);
            } else if (deck1.size() == 3) {
                warDeck1.add(deck1.get(deck1.size() - 1));
                warDeck1.add(deck1.get(deck1.size() - 2));
                warDeck1.add(deck1.get(deck1.size() - 3));
                play1 = warDeck1.get(deck1.size() - 1);
            } else {
                warDeck1.add(deck1.get(0));
                warDeck1.add(deck1.get(1));
                warDeck1.add(deck1.get(2));
                play1 = warDeck1.get(deck1.get(4));
            }

            if (deck2.size() == 1) {
                warDeck2.add(deck2.get(deck2.size() - 1));
                play1 = warDeck2.get(deck2.size() - 1);
            } else if (deck2.size() == 2) {
                warDeck2.add(deck2.get(deck2.size() - 1));
                warDeck2.add(deck2.get(deck2.size() - 2));
                play1 = warDeck2.get(deck2.size() - 1);
            } else if (deck2.size() == 3) {
                warDeck2.add(deck2.get(deck2.size() - 1));
                warDeck2.add(deck2.get(deck2.size() - 2));
                warDeck2.add(deck2.get(deck2.size() - 3));
                play1 = warDeck2.get(deck2.size() - 1);
            } else {
                warDeck2.add(deck2.get(0));
                warDeck2.add(deck2.get(1));
                warDeck2.add(deck2.get(2));
                play1 = warDeck2.get(deck2.get(4));
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

        d1.setPlayerDeck(deck1);
        d2.setPlayerDeck(deck2);

        return;

    }





}