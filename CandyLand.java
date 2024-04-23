import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CandyLand {

    // vars
    
    int life = 20;
    int points = 0;
    int location = 0;

    boolean gingerbreadManDefeated = false;
    boolean candyCaneManDefeated = false;

    int lifeLost = 0;
    int bossesKilled = 0;

    // methods

    //draw card function
    public void drawCard() {
        // draws card in interval
        int cardNum = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("You drew a: " + cardNum);
        location += cardNum;
        if (location >= 50) {
            location = 50;
        }
        else {
            System.out.println("You are currently at square " + location);
            System.out.println("Input 'draw' to continue, input 'quit' to end game.");
        }
    }

    // gingerbread man boss
    // first boss, easy
    public void gingerbreadMan() {
        // create scanner
        Scanner sc = new Scanner(System.in);
        // set dice num as random number between 1 and 6
        int diceNum = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("You rolled a " + diceNum);
        // if dice roll sufficient, player wins
        if (diceNum >= 2) {
            // set boolean to true
            gingerbreadManDefeated = true;
            bossesKilled += 1;
            // offer player options for reward
            System.out.println("You beat the Gingerbread Man! \nYou earned a gingerbread cookie (1). \nWhat would you like to do with this cookie? \nType 'life' to gain +2 health or type 'move' to advance 10 squares.");
            String userInput = sc.nextLine();
            // if player chooses life, add 2 to life
            if (userInput.equals("life")) {
                life += 2;
                System.out.println("New life: " + life);
            }
            // if player chooses move, add 10 to location
            else if (userInput.equals("move")) {
                location += 10;
                System.out.println("New location: "+ location);
            }
            // typo catcher
            else {
                System.out.println("Please type 'life' or 'move'");
            }
        }
        // if dice roll insufficient, player loses
        else {
            System.out.println("You failed to defeat the gingerbread man.");
            // randomly decide repercussions - this is subject to change
            int repercussions = ThreadLocalRandom.current().nextInt(1, 2);
            if (repercussions == 1) {
                life -= 1; // subject to change, placeholder
                lifeLost -= 1;
                System.out.println("-1 life...");
                System.out.println("New life: " + life);
            }
            if (repercussions == 2) {
                location -= 5; // subject to change, placeholder
                System.out.println("-5 tiles...");
                System.out.println("New location: " + location);
            }
        }
    }

    // candy cane man boss
    // meidum-easy boss
    public void candyCaneMan() {
        // create scanner
        Scanner sc = new Scanner(System.in);
        // set dice num as random number between 1 and 6
        int diceNum = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("You rolled a " + diceNum);
        // if dice roll sufficient, player wins
        if (diceNum >= 3) {
            // set boolean to true
            candyCaneManDefeated = true;
            bossesKilled += 1;
            // offer player options for reward
            System.out.println("You beat the Candy Cane Man! \nYou earned a candy cane (1). \nWhat would you like to do with this candy cane? \nType 'life' to gain +5 health or type 'move' to advance 15 squares.");
            String userInput = sc.nextLine();
            // if player chooses life, add 5 to life
            if (userInput.equals("life")) {
                life += 5;
                System.out.println("New life: " + life);
            }
            // if player chooses move, add 15 to location
            else if (userInput.equals("move")) {
                location += 15;
                System.out.println("New location: "+ location);
            }
            // typo catcher
            else {
                System.out.println("Please type 'life' or 'move'");
            }
        }
        // if dice roll insufficient, player loses
        else {
            System.out.println("You failed to defeat the candy cane man.");
            // randomly decide repercussions - this is subject to change
            int repercussions = ThreadLocalRandom.current().nextInt(1, 2);
            if (repercussions == 1) {
                life -= 4; // subject to change, placeholder
                lifeLost -= 4;
                System.out.println("-4 life...");
                System.out.println("New life: " + life);
            }
            if (repercussions == 2) {
                location -= 10; // subject to change, placeholder
                System.out.println("-10 tiles...");
                System.out.println("New location: " + location);
            }
        }
    }

    //main
    public static void main(String[] args) {
        // initialize game
        boolean playing = true;

        System.out.println("Welcome to CandyLand!");
        // create game object
        CandyLand game = new CandyLand();
        // create scanner
        Scanner sc = new Scanner(System.in);
        // turn message w/ instructions
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");

        // main game loop
        while (playing) {
            // check if player in end game
            if (game.location == 50) {
                // initalize end game
                System.out.println("You are at the end of the board!");
                System.out.println("Game over!");
                // ideally, print achievements here
                if (game.bossesKilled == 0) {
                    System.out.println("You killed: " + game.bossesKilled + " bosses. " + "So peaceful!");
                }
                else if (game.bossesKilled == 1) {
                    System.out.println("You killed: " + game.bossesKilled + " boss");
                }
                else if (game.bossesKilled > 1) {
                    System.out.println("You killed: " + game.bossesKilled + " bosses");
                }
                System.out.println("You lost: " + game.lifeLost + " life");
                // i.e., you beat x bosses, you took x time, you lost x life
                break;
            }

            String userInput = sc.nextLine();

            // main game loop
            if (userInput.equals("draw")) {
                // draw card
                game.drawCard();
                // if statements for each boss
                // gingerbread man
                if (game.location >= 10 && game.location <= 20) {
                    // check if boss defeated
                    // if not, prompt player to fight
                    if (game.gingerbreadManDefeated != true) {
                        // offer player option to fight
                        System.out.println("You are in the territory of the Gingerbread man! \nWould you like to fight? Type 'yes' or 'no' to make your decision.");
                        String fightQuestion = sc.nextLine();
                        // if player chooses to fight, call gingerbreadMan method
                        if (fightQuestion.equals("yes")) {
                            game.gingerbreadMan();
                            System.out.println("You continue on your way. \nInput 'draw' to continue, input 'quit' to end game.");
                        }
                        // if player chooses not to fight, continue game
                        else if (fightQuestion.equals("no")) {
                            System.out.println("You choose not to battle.");
                            game.drawCard();
                        }
                        // typo catcher
                        // note: only works once for some reason?
                        else {
                            System.out.println("Please type either 'yes' or 'no' to make your decision.");
                        }
                    }
                }

                // candy cane man
                if (game.location >= 30 && game.location <= 40) {
                    // check if boss defeated
                    // if not, prompt player to fight
                    if (game.candyCaneManDefeated != true) {
                        // offer player option to fight
                        System.out.println("You are in the teritory of the Candy Cane Man \nWould like to fight? Type 'yes' or 'no' to make your decision.");
                        String fightQuestion = sc.nextLine();
                        // if player chooses to fight, call candyCaneMan method
                        if (fightQuestion.equals("yes")) {
                            game.candyCaneMan();
                            System.out.println("You continue on your way. \nInput 'draw' to continue, input 'quit' to end game.");
                        }
                        // if player chooses not to fight, continue game
                        else if (fightQuestion.equals("no")) {
                            System.out.println("You choose not to battle.");
                            game.drawCard();
                        }
                        // typo catcher
                        // note: only works once for some reason?
                        else {
                            System.out.println("Please type either 'yes' or 'no' to make your decision.");
                        }
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