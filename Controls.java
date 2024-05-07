import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/*
 * this Controls class is used to create controls objects
 * this class has no variables or constructor
 * this class has methods that allow the player to draw a card, print the leaderboard, print achievements, and quit the game
 */
public class Controls {

    // methods
    
    /*
     * this method allows the player to draw a card and increments the player's location accordingly
     * @param player the player object
     * @return none
     */
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

    /*
     * this method prints the leaderboard
     * @param player the player object
     * @return none
     */
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

    /*
     * this method prints the achievements the player has unlocked
     * @param player the player object
     * @return none
     */
    public void achievements(Player player) {
        // initialize achievements
        int achievementsUnlocked = 0;
        int baseAchievementsUnlocked = 0;
        int bonusAchievementsUnlocked = 0;

        // checking if player has unlocked any achievements to determine if "🏆 Achievements 🏆" should be printed

        // check for default achievement: beat game
        if (player.life > 0 && player.location == 50) {
            // increment achievements
            achievementsUnlocked += 1;
            baseAchievementsUnlocked += 1;
        }

        // if player has unlocked achievements
        // print "🏆 Achievements 🏆"
        else if (achievementsUnlocked >= 1) {
            // print statement
            System.out.println("\n🏆 Achievements 🏆");
        }

        // default achievement: beat game
        if (player.life > 0 && player.location == 50) {
            System.out.println("🌟 Winner 🌟 : You beat the game");
        }
        
        // check if player has unlocked other achievements

        // traveled over 50 squares
        if (player.locationGained >= 50) {
            // print statement
            System.out.println("🗺️ Long Journey 🚶🗺️ : You traveled a great distance");
            // increment achievements
            achievementsUnlocked += 1;
            bonusAchievementsUnlocked += 1;
        }

        // attempted to fight at least 5 bosses
        if (player.bossBattlesAttempted >= 5) {
            // print statement
            System.out.println("🛡️ Brave Warrior 🛡️ : You attempted to fight at least 5 bosses");
            // increment achievements
            achievementsUnlocked += 1;
            baseAchievementsUnlocked += 1;
        }

        // beat all bosses
        if (player.bossesKilled == 5) {
            // print statement
            System.out.println("🗡️ Valiant Fighter 🗡️ : You defeated all of the bosses");
            // increment achievements
            achievementsUnlocked += 1;
            baseAchievementsUnlocked += 1;
        }

        // lose no life
        if (player.lifeLost == 0) {
            // print statement
            System.out.println("🏥 So Healthy! 🏥 : You did not lose any life in your travels");
            // increment achievements
            achievementsUnlocked += 1;
            baseAchievementsUnlocked += 1;
        }

        // beat all bosses without losing life
        if (player.bossesKilled == 5 && player.lifeLost == 0) {
            // print statement
            System.out.println("👑 God Amongst Mortals 👑 : You have defeated all the bosses and did not lose any life in the process");
            // increment achievements
            achievementsUnlocked += 1;
            baseAchievementsUnlocked += 1;
        }

        // beat no bosses
        if (player.bossesKilled == 0) {
            // randomize between two achievements
            int shameQuestionMark = ThreadLocalRandom.current().nextInt(1, 2);

            // if 1
            if (shameQuestionMark == 1) {
                // print statement
                System.out.println("🫣 The Cowards Path 🫣 : You battled no bosses");
                // increment achievements
                achievementsUnlocked += 1;
                bonusAchievementsUnlocked += 1;
            }

            // if 2
            else if (shameQuestionMark == 2) {
                // print statement
                System.out.println("🙏 Pacifist 🙏 : You battled no bosses ");
                // increment achievements
                achievementsUnlocked += 1;
                bonusAchievementsUnlocked += 1;
            }
        }

        // print achievements unlocked

        // if player has not unlocked any achievements
        if (achievementsUnlocked == 0) {
            // add space
            betweenLines();

            // print statement
            System.out.println("🔒 No Achievements Unlocked 🔒");

            // add space
            betweenLines();
        }

        // achievements unlocked
        if (achievementsUnlocked >= 1) {
            // add space
            betweenLines();

            // print statements
            System.out.println("Base achievements unlocked: " + baseAchievementsUnlocked + " out of 5");
            System.out.println("Bonus achievements unlocked: " + bonusAchievementsUnlocked + " out of 2");

            // add space
            betweenLines();
        }
    }
    
    /*
     * this method helps format the output of the game
     * @param none
     * @return none
     */
    public void betweenLines() {
        System.out.println("");
        System.out.println("ʚ𖦹ɞ");
        System.out.println("");
    }

    /*
     * this method allows the player to quit the game
     * @param none
     * @return none
     */
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