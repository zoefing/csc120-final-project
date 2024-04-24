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
        System.out.println("You are in the territory of the " + name + "!");
    }

    public void offerFight(Player player) {
        System.out.println("Would you like to fight? Type 'yes' or 'no' to make your decision.");
        Scanner sc = new Scanner(System.in);
        String fightQuestion = sc.nextLine();
        
        // if player chooses to fight, call gingerbreadMan method
        if (fightQuestion.equals("yes")) {
            battleBoss(player);
        }
        // if player chooses not to fight, continue game
        else if (fightQuestion.equals("no")) {
            // print message
            System.out.println("You choose not to battle.");

            // exit
            Controls Controls = new Controls();
            Controls.drawCard(player);
        }
        // typo catcher
        // note: only works once for some reason?
        else {
            System.out.println("Please type either 'yes' or 'no' to make your decision.");
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
            
            // subtract from life
            player.life -= damage;
            System.out.println("-" + damage + " life...");

            // add to life lost
            player.lifeLost += damage;

            // print new life
            System.out.println("New life: " + player.life);
            
            // exit
            Controls Controls = new Controls();
            Controls.drawCard(player);
        }
    }
}