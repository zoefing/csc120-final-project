import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Boss {

    // vars
    public String name;
    public int health;
    public int damage;
    public boolean defeated = false;
    
    // constructor
    public Boss(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    // methods
    public void enterArea() {
        // "the" doesn't sound right with some of the names
        if (this.name != "Princess Frostine" && this.name != "Lord Licorice") {
            System.out.println("You are in the territory of the " + name + "!");
            flair();
        }
        else {
            System.out.println("You are in the territory of " + name + "!");
            flair();
        }
    }

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

    public void offerFight(Player player) {
        System.out.println("Would you like to fight? Type 'yes' or 'no' to make your decision.");
        Scanner sc = new Scanner(System.in);
        String fightQuestion = sc.nextLine();
        // if player chooses to fight, call gingerbreadMan method
        if (fightQuestion.equals("yes")) {
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
            System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
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

            // reward player
            Reward Reward = new Reward("name", health * 2, health * 5); // temp values
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
            System.out.println("-" + damage + " life...");

            // add to life lost
            player.lifeLost += damage;

            // print new life
            System.out.println("Remaining life: " + player.life);

            // add space
            Controls.betweenLines();
            
            // exit
            if (player.life <= 0) {
                ;
            }
            else if (player.life > 0){
                System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
            }
        }
    }
}