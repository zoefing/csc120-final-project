import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class CandyLand {

    //main
    public static void main(String[] args) {
        // initialize game
        boolean playing = true;

        // welcome message
        System.out.println("Welcome to CandyLand!");

        // create player
        Player player = new Player("Player", 5, 0);

        // create bosses
        Boss GingerbreadMan = new Boss("Gingerbread Man", 2, 2);
        Boss CandyCaneMan = new Boss("Candy Cane Man", 3, 3);
        Boss GumDropMan = new Boss("Gumdrop Man", 4, 5);
        Boss LordLicorice = new Boss("Lord Licorice", 5, 6);
        Boss PrincessFrostine = new Boss("Princess Frostine", 6, 10);

        // create controls
        Controls Controls = new Controls();

        // create scanner
        Scanner sc = new Scanner(System.in);

        // start time
        long startTime = System.nanoTime();

        // turn message w/ instructions
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");

        // main game loop
        while (playing) {
            //if player is alive
            if (!(player.life <= 0)) {
                    
                // check if player in end game
                if (player.location == 50) {
                    // initalize end game
                    long endTime = System.nanoTime();
                    long gameTime = endTime - startTime;

                    // convert time to minutes and seconds
                    long minutes = TimeUnit.MINUTES.convert(gameTime, NANOSECONDS);
                    long seconds = TimeUnit.SECONDS.convert(gameTime, NANOSECONDS);

                    // end game message
                    System.out.println("\nYou are at the end of the board! \nGame over!");
                    if (minutes == 0) {
                        System.out.println("You took " + seconds + " seconds to finish the game");
                    }
                    else if (seconds == 0) {
                        System.out.println("You took " + minutes + " minutes to finish the game");
                    }
                    Controls.leaderboard(player);
                    Controls.achievements(player);
                    break;
                }

                String userInput = sc.nextLine();

                // main game loop
                if (userInput.equals("draw")) {
                    // draw card
                    Controls.drawCard(player);

                    // check if player in active areas

                    //rainbow bridges
                    if (player.location == 12 || player.location == 32) {
                        System.out.println("You have landed on a rainbow bridge! You advance 10 squares."); //print lines for readability
                        player.location += 10;
                        System.out.println("You are now at tile " + player.location + ". \n Input 'draw' to continue, input 'quit' to end game.");
                    }

                    //licorice squares
                    if (player.location % 7 == 0 && player.location >= 10)  {
                        // added patch so that player does not immediately lose all life or go into negative squares
                        System.out.println("You have landed on a licorice square! Type 'life' to lose 5 life or 'move' to go back 10 squares.");
                        String licoriceChoice = sc.nextLine();
                        if (licoriceChoice.equals("life")) {
                            player.life -= 5;
                            System.out.println("Your life is now " + player.life + ".");
                            if (player.life <= 0) {
                                ;
                            }
                            else {
                                System.out.println("Input 'draw' to continue, input 'quit' to end game.");
                            }
                        }
                        else if (licoriceChoice.equals("move")) {
                            player.location -= 10;
                            System.out.println("Your location is now " + player.location + ". Input 'draw' to continue, input 'quit' to end game.");
                        }
                        else {
                            System.out.println("You did not enter life or move. Therefore, you lose 5 life and go back 10 squares. Input 'draw' to continue, input 'quit' to end game.\n");
                            player.life -= 5;
                            player.location -= 10;
                        }
                    }

                    // check if player in boss areas

                    // gingerbread
                    if ((!(player.life <= 0)) && (player.location >= 4 && player.location <= 10)) {
                        // check if boss defeated
                        if (GingerbreadMan.defeated == false) {
                            // offer player option to fight
                            GingerbreadMan.enterArea();
                            GingerbreadMan.offerFight(player);
                        }
                        // silly little resolution for the draw card message
                        else {
                            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
                        }
                    } 

                    // candy cane
                    if ((!(player.life <= 0)) && (player.location >= 14 && player.location <= 20)) {
                        // check if boss defeated
                        if (CandyCaneMan.defeated == false) {
                            // offer player option to fight
                            CandyCaneMan.enterArea();
                            CandyCaneMan.offerFight(player);
                        }
                        // silly little resolution for the draw card message
                        else {
                            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
                        }
                    } 

                    // gumdrop
                    if ((!(player.life <= 0)) && (player.location >= 24 && player.location <= 30)) {
                        // check if boss defeated
                        if (GumDropMan.defeated == false) {
                            // offer player option to fight
                            GumDropMan.enterArea();
                            GumDropMan.offerFight(player);
                        }
                        // silly little resolution for the draw card message
                        else {
                            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
                        }
                    } 

                    // Lord Licorice
                    if ((!(player.life <= 0)) && (player.location >= 34 && player.location <= 40)) {
                        // check if boss defeated
                        if (LordLicorice.defeated == false) {
                            // offer player option to fight
                            LordLicorice.enterArea();
                            LordLicorice.offerFight(player);
                        }
                        // silly little resolution for the draw card message
                        else {
                            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
                        }
                    } 

                    // Princess Frostine
                    if ((!(player.life <= 0)) && (player.location >= 44 && player.location <= 50)) {
                        // check if boss defeated
                        if (PrincessFrostine.defeated == false) {
                            // offer player option to fight
                            PrincessFrostine.enterArea();
                            PrincessFrostine.offerFight(player);
                        }
                        // silly little resolution for the draw card message
                        else {
                            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
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
        //if player is dead
        else if (player.life <= 0) {
            System.out.println("Game over! You died.");
            break;
        } //game over
    }
        // close scanner
        sc.close();
    }
}