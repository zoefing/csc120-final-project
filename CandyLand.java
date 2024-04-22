import java.util.Random;
import java.util.Scanner;

public class CandyLand {

    // vars
    
    int life = 20;
    int points = 0;
    int location = 0;
    boolean candyCaneManDefeated = false;
    boolean gingerbreadManDefeated = false;

//draw card function
public void drawCard() {

    Random rand = new Random();
    int cardNum = rand.nextInt(10);
    //needs to be greater than 1
    System.out.println("You drew a: " + cardNum);
    location += cardNum;
    System.out.println("You are currently at square " + location);
    System.out.println("Input 'draw' to continue, input 'quit' to end game.");
}

public void candyCaneMan() {
    // candycane man lore
    // easy boss
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    // plot point for dice
    int diceNum = rand.nextInt(6);
    System.out.println("You rolled a " + diceNum);
    // decide consequences for life and location
    if (diceNum >= 2) {
        candyCaneManDefeated = true;
        System.out.println("You have vanquished the Candy Cane Man");
        // art?
        System.out.println("You have gained a candycane (1)");
        // could build inventory system
        System.out.println("What would you like to do with this candycane");
        // show options
        System.out.println("Type 'life' to gain +2 health or type 'move' to advance +10 squares");
        // leaderboard could be fun!
        String userInput = sc.nextLine();
        if (userInput.equals("life")) {
            life += 2;
            System.out.println("New life: " + life);
        }
        else if (userInput.equals("move")) {
            location += 10;
            System.out.println("New location: "+ location);
        }
        else {
            System.out.println("Please type 'life' or 'move'");
        }
    }
    else {
        System.out.println("You failed to defeat the gingerbread man.");
    }

}

public void gingerbreadMan() {
    // gingerbread man
    // medium level boss
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    int diceNum = rand.nextInt(6);
    System.out.println("You rolled a " + diceNum);
    // decide consequences for life and location
    if (diceNum >= 4) {
        gingerbreadManDefeated = true;
        System.out.println("You beat the gingerbread man! \n You earned a gingerbread cookie (1). \n What would you like to do with this cookie? \n Type 'life' to gain +5 health or type 'move to advance 15 squares.");
        String userInput = sc.nextLine();
        if (userInput.equals("life")) {
            life += 5;
            System.out.println("New life: " + life);
        }
        else if (userInput.equals("move")) {
            location += 15;
            System.out.println("New location: "+ location);
        }
        else {
            System.out.println("Please type 'life' or 'move'");
        }
    }
    else {
        System.out.println("You failed to defeat the gingerbread man.");
    }

}

//main
public static void main(String[] args) {
    //if you're within a certain interval of squares, you get the choice to engage with bosses (10 squares)
    boolean playing = true;
    CandyLand game = new CandyLand();
    Scanner sc = new Scanner(System.in);
    System.out.println("Input 'draw' to continue, input 'quit' to end game.");
    // weird gap

    System.out.println();
    while (playing) {
        String userInput = sc.nextLine();

        // if statements for each boss

        if (userInput.equals("draw")) {
            game.drawCard();
            if (game.location >= 10 && game.location <= 20) {
                if (game.candyCaneManDefeated != true) {
                    System.out.println("You are in the teritory of the Candy Cane Man");
                    System.out.println("Would like to fight? Type 'yes' or 'no' to make your decision.");
                    String fightQuestion = sc.nextLine();
    
                    if (fightQuestion.equals("yes")) {
                        game.candyCaneMan();
                        System.out.println("You continue on your way.");
                        System.out.println("Input 'draw' to continue, input 'quit' to end game.");
                    }
                    else if (fightQuestion.equals("no")) {
                        System.out.println("You choose not to battle.");
                        game.drawCard();
                    }
                }
            }
            if (game.location >= 30 && game.location <= 40) {
                if (game.gingerbreadManDefeated != true) {
                    System.out.println("You are in the territory of the Gingerbread man! \n Would you like to fight? Type 'yes' or 'no' to make your decision.");
                    String fightQuestion = sc.nextLine();

                    if (fightQuestion.equals("yes")) {
                        game.gingerbreadMan();
                        System.out.println("You continue on your way. \n Input 'draw' to continue, input 'quit' to end game.");
                    }
                }
            }
        }     
        
        else if (userInput.equals("quit")) {
            System.out.println("Game over");
            break;
        }

        else {
            System.out.println("Please type either 'draw' or 'quit' to continue.");
        }
    }
    
} 
}
