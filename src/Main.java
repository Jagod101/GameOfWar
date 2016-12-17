import java.io.FileWriter;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("stats.txt");
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
            if(b.getNumBattles() > maxNumBattles)
            {
                maxNumBattles = b.getNumBattles();
            }
            if(b.getNumBattles() < minNumBattles)
            {
                minNumBattles = b.getNumBattles();
            }
            if(b.getNumWars() > maxNumWars)
            {
                maxNumWars = b.getNumWars();
            }
            if(b.getNumWars() < minNumWars)
            {
                minNumWars = b.getNumWars();
            }



            totNumWars += b.getNumWars();
            totNumDWars += b.getNumDWars();
        }

        System.out.println(totBattles/1000);
        System.out.println(totNumWars/1000);
        System.out.println(totNumDWars/1000);
        System.out.println(minNumWars);
        System.out.println(maxNumWars);
        System.out.println(minNumBattles);
        System.out.println(maxNumBattles);



        fw.write("Total Battles: " + totBattles/1000 + " ");
        fw.write("Total Wars: " + totNumWars/1000 + " ");
        fw.write("Total Double Wars: " + totNumDWars/1000 + " ");
        fw.write("Minumum Wars: " + minNumWars + " ");
        fw.write("Maximum Wars: " + maxNumWars + " ");
        fw.write("Mininum Battles: " + minNumBattles + " ");
        fw.write("Maximum Battles: " + maxNumBattles + " ");
        fw.close();
    }
}
