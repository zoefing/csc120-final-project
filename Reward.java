import java.util.Scanner;

/*
 * this Reward class is used to create reward objects
 * this class has vars for the name, lifeGain, and locationGain of the reward
 * this class has a constructor that takes in a name, lifeGain, and locationGain
 * this class has methods to offer reward options, reward life, and reward location
 */
public class Reward {
    // vars
    public String name;
    public int lifeGain;
    public int locationGain;

    // constructor
    /*
     * this constructor takes in a name, lifeGain, and locationGain
     * @param name the name of the reward
     * @param lifeGain the health gain of the reward
     * @param locationGain the location gain of the reward
     */
    public Reward(String name, int lifeGain, int locationGain) {
        this.name = name;
        this.lifeGain = lifeGain;
        this.locationGain = locationGain;
    }

    // methods

    /*
     * this method offers the player reward options
     * this method prints the reward options and allows the player to choose between gaining health or advancing squares
     * this method then calls the rewardLife or rewardLocation method based on the player's choice
     * @param player the player object
     * @return none
     */
    public void rewardOptions(Player player) {
        // print reward options
        System.out.println("Type 'life' to gain " + lifeGain + " health or type 'move' to advance " + locationGain + " squares.");
        
        // new scanner
        Scanner sc = new Scanner(System.in);
        String reward = sc.nextLine();

        // if player chooses life, add healthGain to life
        if (reward.equals("life")) {
            rewardLife(player);
        }
        
        // if player chooses move, add locationGain to location
        else if (reward.equals("move")) {
            rewardLocation(player);
        }
        
        // typo catcher
        else {
            System.out.println("Invalid input. Please try again.");
            rewardOptions(player);
        }
    }

    /*
     * this method rewards the player with locationGain
     * this method adds locationGain to the player's location and locationGained
     * this method makes sure the player does not surpass the tile limit
     * this method prints a statement and calls the betweenLines method
     * this method then exits
     * @param player the player object
     * @return none
     */
    public void rewardLocation(Player player) {
        // add locationGain to location
        player.location += locationGain;

        // add locationGain to locationGained
        player.locationGained += locationGain;

        // make sure player does not surpass the tile limit
        if (player.location >= 50) {
            player.location = 50;
        }

        // print statement
        else {
            System.out.println("You moved " + locationGain + " tiles! You are now at tile " + player.location + ".");
        }
        
        // add space
        Controls Controls = new Controls();
        Controls.betweenLines();

        // exit
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game");
    }

    /*
     * this method rewards the player with lifeGain
     * this method adds lifeGain to the player's life and lifeGained
     * this method prints a statement and calls the betweenLines method
     * this method then exits
     * @param player the player object
     * @return none
     */
    public void rewardLife(Player player) {
        // add healthGain to life
        player.life += lifeGain;

        // add lifeGain to lifeGained
        player.lifeGained += lifeGain;

        // print statement
        System.out.println("You gained " + lifeGain + " health! You now have " + player.life + " health.");

        // add space
        Controls Controls = new Controls();
        Controls.betweenLines();

        // exit
        System.out.println("Input 'draw' to draw a card, input 'quit' to end game");
    }
}