import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * this Boss class is used to create boss objects
 * this class has vars for the name, health, and damage of the boss
 * this class has a constructor that takes in a name, health, and damage
 * this class has methods that allow the player to enter the boss area, print a specialized boss flair, offer a fight, and initiate a boss battle
 */
public class Boss {

    // vars
    public String name;
    public int health;
    public int damage;
    public boolean defeated = false;
    
    // constructor
    /*
     * this constructor takes in a name, health, and damage
     * @param name the name of the boss
     * @param health the health of the boss
     * @param damage the damage of the boss
     */
    public Boss(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // methods

    /*
     * this method allows the player to enter the boss area
     * this method prints a statement that the player is in the territory of the boss
     * this method then calls the flair method to print a specialized boss flair
     * @param none
     * @return none
     */
    public void enterArea() {
        // "the" doesn't sound right with some of the names
        if (this.name != "Princess Frostine" && this.name != "Lord Licorice") {
            // print statement
            System.out.println("You are in the territory of the " + name + "!");
            
            // add boss flair
            flair();
        }
        else {
            // print statement
            System.out.println("You are in the territory of " + name + "!");

            // add boss flair
            flair();
        }
    }

    /*
     * this method prints a specialized boss flair
     * @param none
     * @return none
     */
    public void flair() {
        if (this.name.equals("Gingerbread Man")) {
            System.out.println("     ,-.\n" + //
                                "   _(*_*)_\n" + //
                                "  (_  o  _)\n" + //
                                "    / o \\\n" + //
                                "   (_/ \\_)");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();
        }
        else if (this.name.equals("Candy Cane Man")) {
            System.out.println("           _._\n" + //
                                "         /\\|/\\\n" + //
                                "        /\\/ )-|\n" + //
                                "       /\\/  `\"\n" + //
                                "      /\\/\n" + //
                                "     /\\/\n" + //
                                "    /\\/\n" + //
                                "   /\\/\n" + //
                                "   `\"");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();
        }
        else if (this.name.equals("Gumdrop Man")) {
            System.out.println( "    ,---.\n" + //
                                "   / o o \\\n" + //
                                "  | o o o |\n" + //
                                "   \\ o o /\n" + //
                                "    `---'");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();
        }
        else if (this.name.equals("Lord Licorice")) {
            // art
            System.out.println("      ___      .-\"\"-.      ___\n" + //
                                "      \\  \"-.  /      \\  .-\"  /\n" + //
                                "       > -=.\\/        \\/.=- <\n" + //
                                "       > -='/\\        /\\'=- <\n" + //
                                "      /__.-'  \\      /  '-.__\\\n" + //
                                "               '-..-'");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();
        }
        else if (this.name.equals("Princess Frostine")) {
            // art
            System.out.println("         _\n" + //
                                "       ,' `,.\n" + //
                                "       >-.(__)\n" + //
                                "      (_,-' |\n" + //
                                "        `.  |\n" + //
                                "          `.| \n" + //
                                "            `");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();
        }
    }

    /*
     * this method offers the player the option to fight the boss and calls the battleBoss method if the player chooses to fight
     * @param player the player object
     * @return none
     */
    public void offerFight(Player player) {
        // print statement
        System.out.println("Would you like to fight? Type 'yes' or 'no' to make your decision.");
        
        // make a new scanner
        Scanner sc = new Scanner(System.in);
        String fightQuestion = sc.nextLine();
        
        // if player chooses to fight, call gingerbreadMan method
        if (fightQuestion.equals("yes")) {
            // increment amount of boss battles attempted
            player.bossBattlesAttempted += 1;

            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();

            // enter boss battle
            battleBoss(player);
        }
        // if player chooses not to fight, continue game
        else if (fightQuestion.equals("no")) {
            // print message
            System.out.println("You choose not to battle.");

            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();

            // exit
            if (player.location < 50) {
                System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
            }
            else if (player.location >= 50) {
                ;
            }
        }
        // typo catcher
        else {
            // print statement
            System.out.println("Please type either 'yes' or 'no' to make your decision.");

            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();

            // repeat
            offerFight(player);
        }
    }

    /*
     * this method initiates a boss battle
     * if the player wins, the player is rewarded
     * if the player loses, the player takes damage
     * @param player the player object
     * @return none
     */
    public void battleBoss(Player player) {
        // set dice num as random number between 1 and 6
        int diceNum = ThreadLocalRandom.current().nextInt(1, 7);

        // print dice roll
        System.out.println("You rolled a " + diceNum);

        // if dice roll sufficient, player wins
        if (diceNum > health || diceNum == health) {
            // set boolean to true
            defeated = true;

            // add to bosses killed
            player.bossesKilled += 1;

            // print success message
            System.out.println("You beat the " + name + "!");   

            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();

            // create reward object with name, healthGain (two times boss health), and locationGain (five times boss health)
            Reward Reward = new Reward("name", health * 2, health * 5);

            // reward player
            Reward.rewardOptions(player);
        }

        // if dice roll insufficient, player loses
        else if (diceNum < health) {
            // keep boolean as false
            defeated = false;
            
            // print failure message
            System.out.println("You failed to defeat the " + name + ".");
            
            // add space
            Controls Controls = new Controls();
            Controls.betweenLines();

            // subtract from life
            player.life -= damage;

            // if life is negative, set to 0
            if (player.life < 0) {
                player.life = 0;
            }

            // print damage taken
            System.out.println("-" + damage + " life...");

            // add to life lost
            player.lifeLost += damage;

            // print new life
            System.out.println("Remaining life: " + player.life);

            // add space
            Controls.betweenLines();
            
            // exit

            // if player has no life, print nothing
            if (player.life <= 0) {
                ;
            }

            // if player has life, print draw card statement
            else if (player.life > 0){
                System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
            }
        }
    }
}