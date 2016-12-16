public class Main {

    public static void main(String[] args) {

        double totBattles = 0;
        double totNumWars = 0;
        double totNumDWars = 0;
        int maxNumBattles = 0; // impliment later
        int minNumBattles = Integer.MAX_VALUE;
        int maxNumWars = 0;
        int minNumWars = Integer.MAX_VALUE;




        for(int i = 0; i < 1000; i++)
        {
            Board b = new Board();
            /*
            System.out.println(b.printOrigDeck());
            System.out.println(b.printDeck1());
            System.out.println(b.printDeck2());
            */
            b.playGame();
            totBattles += b.getNumBattles();
            totNumWars += b.getNumWars();
            totNumDWars += b.getNumDWars();
        }

        System.out.println(totBattles/1000);
        System.out.println(totNumWars/1000);
        System.out.println(totNumDWars/1000);

    }
}
