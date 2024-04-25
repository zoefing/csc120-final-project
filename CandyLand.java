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
        Boss GumDropMan = new Boss("Gumdrop Man", 2, 5);
        Boss LordLicorice = new Boss("Lord Licorice", 4, 3);
        Boss PrincessFrostine = new Boss("Princess Frostine", 5, 5);

        // create controls
        Controls Controls = new Controls();

        // create scanner
        Scanner sc = new Scanner(System.in);

        // turn message w/ instructions
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game. \n");

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

                // check if player in active areas

                // gingerbread
                if (player.location >= 4 && player.location <= 10) {
                    // check if boss defeated
                    if (GingerbreadMan.defeated == false) {
                        // offer player option to fight
                        GingerbreadMan.enterArea();
                        GingerbreadMan.offerFight(player);
                    }
                } 

                //rainbow bridges
                if (player.location == 11 || player.location == 31) {
                    System.out.println("You have landed on a rainbow bridge! You advance 10 squares."); //print lines for readability
                    player.location += 10;
                    System.out.println("You are now at tile " + player.location + ". Input 'draw' to continue, input 'quit' to end game. \n");
                }

                //licorice squares
                if (player.location % 7 == 0)  {
                    System.out.println("You have landed on a licorice square! Type 'life' to lose 5 life or 'move' to go back 10 squares. \n");
                    String licoriceChoice = sc.nextLine();
                    if (licoriceChoice.equals("life")) {
                        player.life -= 5;
                        System.out.println("Your life is now " + player.life + ". Input 'draw' to continue, input 'quit' to end game. \n");
                    }
                    else if (licoriceChoice.equals("move")) {
                        player.location -= 10;
                        System.out.println("Your location is now " + player.location + ". Input 'draw' to continue, input 'quit' to end game.\n");
                    }
                    else {
                        System.out.println("You did not enter life or move. Therefore, you lose 5 life and go back 10 squares. Input 'draw' to continue, input 'quit' to end game.\n");
                        player.life -= 5;
                        player.location -= 10;
                    }
                }

                // candy cane
                if (player.location >= 14 && player.location <= 20) {
                    // check if boss defeated
                    if (CandyCaneMan.defeated == false) {
                        // offer player option to fight
                        CandyCaneMan.enterArea();
                        CandyCaneMan.offerFight(player);
                    }
                } 

                // gumdrop
                if (player.location >= 24 && player.location <= 30) {
                    // check if boss defeated
                    if (GumDropMan.defeated == false) {
                        // offer player option to fight
                        GumDropMan.enterArea();
                        GumDropMan.offerFight(player);
                    }
                } 

                 // Lord Licorice
                 if (player.location >= 34 && player.location <= 40) {
                    // check if boss defeated
                    if (LordLicorice.defeated == false) {
                        // offer player option to fight
                        LordLicorice.enterArea();
                        LordLicorice.offerFight(player);
                    }
                } 

                // Princess Frostine
                if (player.location >= 44 && player.location <= 50) {
                    // check if boss defeated
                    if (PrincessFrostine.defeated == false) {
                        // offer player option to fight
                        PrincessFrostine.enterArea();
                        PrincessFrostine.offerFight(player);
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
                System.out.println("Please type either 'draw' or 'quit' to continue. \n");
            }
        } 
        // close scanner
        sc.close();
    }
}