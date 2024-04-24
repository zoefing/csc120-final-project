import java.util.Scanner;

public class CandyLand {

    //main
    public static void main(String[] args) {
        // initialize game
        boolean playing = true;

        // welcome message
        System.out.println("Welcome to CandyLand!");

        // create player
        Player player = new Player("Player", 10, 0);

        // create bosses
        Boss GingerbreadMan = new Boss("Gingerbread Man", 2, 1);
        Boss CandyCaneMan = new Boss("Candy Cane Man", 3, 2);

        // create controls
        Controls Controls = new Controls();

        // create scanner
        Scanner sc = new Scanner(System.in);

        // turn message w/ instructions
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");

        // main game loop
        while (playing) {
            // check if player in end game
            if (player.location == 50) {
                // initalize end game
                Controls.endGame(player);
                break;
            }

            String userInput = sc.nextLine();

            // main game loop
            if (userInput.equals("draw")) {
                // draw card
                Controls.drawCard(player);

                // check if player in boss areas

                // gingerbread
                if (player.location >= 10 && player.location <= 20) {
                    // check if boss defeated
                    if (GingerbreadMan.defeated == false) {
                        // offer player option to fight
                        GingerbreadMan.enterArea();
                        GingerbreadMan.offerFight(player);
                    }
                } 

                // candy cane
                if (player.location >= 30 && player.location <= 40) {
                    // check if boss defeated
                    if (CandyCaneMan.defeated == false) {
                        // offer player option to fight
                        CandyCaneMan.enterArea();
                        CandyCaneMan.offerFight(player);
                    }
                } 
            }
            
            // game quit option
            else if (userInput.equals("quit")) {
                System.out.println("Game over");
                break;
            }
            
            // typo catcher
            else {
                System.out.println("Please type either 'draw' or 'quit' to continue.");
            }
        } 
        // close scanner
        sc.close();
    }
}