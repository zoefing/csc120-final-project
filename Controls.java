import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Controls {

    public void drawCard(Player player) {
        // draws card in interval
        int cardNum = ThreadLocalRandom.current().nextInt(1, 10);

        // print card drawn
        System.out.println("You drew a: " + cardNum);

        // add space
        player.location += cardNum;

        // check if player is at end of board
        if (player.location >= 50) {
            player.location = 50;
        }

        else {
            // print location
            System.out.println("You are currently at square " + player.location);

            // add space
            betweenLines();

            // print statement based on location

            // print nothing
            if (player.life <= 0) {
                ;
            }

            // print nothing
            else if ((player.life != 0) && ((player.location >= 4 && player.location <= 10) || (player.location >= 14 && player.location <= 20) || (player.location >= 24 && player.location <= 30) || (player.location >= 34 && player.location <= 40) || (player.location >= 44 && player.location <= 50))) {
                ;
            }

            // print nothing
            else if ((player.life != 0) && (player.location == 13 || player.location == 33 || (player.location % 7 == 0 && player.location >= 10))) {
                ;
            }

            // print end statement
            else if (player.life != 0 && player.location >= 50) {
                System.out.println("You have reached the end of the board!");
            }

            // print draw card statement
            else {
                System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
            }
        }
    }

    public void leaderboard(Player player) {
        // initialize leaderboard

        // print boss statement based on num kills
        // plural
        if (player.bossesKilled == 0 || player.bossesKilled > 1) {
            System.out.println("You killed: " + player.bossesKilled + " bosses");
        }
        // singular
        else if (player.bossesKilled == 1) {
            System.out.println("You killed: " + player.bossesKilled + " boss");
        }

        // print life lost
        System.out.println("You lost: " + player.lifeLost + " life");
    }

    public void achievements(Player player) {
        // print achievements
        System.out.println("\n🏆 Achievements 🏆");
        
        // initialize achievements
        int achievementsUnlocked = 0;

        // print achievements based on player stats

        // default achievement: beat game
        System.out.println("🌟 Winner 🌟 : You beat the game");

        // increment achievements
        achievementsUnlocked += 1;

        // check if player has unlocked other achievements

        // traveled over 50 squares
        if (player.locationGained >= 50) {
            System.out.println("🗺️ Long Journey 🚶🗺️ : You traveled a great distance");
            achievementsUnlocked += 1;
        }

        // attempted to fight at least 5 bosses
        if (player.bossBattlesAttempted >= 5) {
            System.out.println("🛡️ Brave Warrior 🛡️ : You attempted to fight at least 5 bosses");
            achievementsUnlocked += 1;
        }

        // beat all bosses
        if (player.bossesKilled == 5) {
            System.out.println("🗡️ Valiant Fighter 🗡️ : You defeated all of the bosses");
            achievementsUnlocked += 1;
        }

        // lose no life
        if (player.lifeLost == 0) {
            System.out.println("🏥 So Healthy! 🏥 : You did not lose any life in your travels");
            achievementsUnlocked += 1;
        }

        // beat all bosses without losing life
        if (player.bossesKilled == 5 && player.lifeLost == 0) {
            System.out.println("👑 God Amongst Mortals 👑 : You have defeated all the bosses and did not lose any life in the process");
            achievementsUnlocked += 1;
        }

        // beat no bosses
        if (player.bossesKilled == 0) {
            // randomize between two achievements
            int shameQuestionMark = ThreadLocalRandom.current().nextInt(1, 2);

            // if 1
            if (shameQuestionMark == 1) {
                System.out.println("🫣 The Cowards Path 🫣 : You battled no bosses");
                achievementsUnlocked += 1;
            }

            // if 2
            else if (shameQuestionMark == 2) {
                System.out.println("🙏 Pacifist 🙏 : You battled no bosses ");
                achievementsUnlocked += 1;
            }
        }

        // blank line
        System.out.println("");

        // print achievements unlocked

        // no achievements unlocked
        if (achievementsUnlocked == 0) {
            System.out.println("🔒 No Achievements Unlocked 🔒");
        }

        // achievements unlocked
        else {
            System.out.println("Achievements unlocked: " + achievementsUnlocked + " out of 7");
        }

        // blank line
        System.out.println("");
    }
    
    // pretty formatting
    public void betweenLines() {
        System.out.println("");
        System.out.println("ʚ𖦹ɞ");
        System.out.println("");
    }

    public void offerQuit() {
        // confirm quit
        System.out.println("Are you sure you want to quit? Type 'yes' or 'no' to make your decision.");

        // create scanner
        Scanner sc = new Scanner(System.in);
        String quitQuestion = sc.nextLine();

        // if player wants to quit
        if (quitQuestion.equals("yes")) {
            
            // add space
            betweenLines();

            // print statement
            System.out.println("Weak...");

            // spacing
            System.out.println("");

            // end game
            System.exit(0);
        }

        // if player does not want to quit
        else if (quitQuestion.equals("no")) {
            // print statement
            System.out.println("Interesting typo then...");

            // add space
            betweenLines();

            // return to game loop
            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
        }

        // typo catcher
        else {
            // print statement
            System.out.println("Please type either 'yes' or 'no' to continue.");

            // add space
            betweenLines();

            // offer quit again
            offerQuit();
        }
    }    
}