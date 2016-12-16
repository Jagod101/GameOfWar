
public class Main {

    public static void main(String[] args) {


        Board b = new Board();
        System.out.println(b.printOrigDeck());
        System.out.println(b.printDeck1());
        System.out.println(b.printDeck2());

        b.playGame();
    }
}
