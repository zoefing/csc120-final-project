import java.util.Scanner;

public class Reward {
    // vars
    public String name;
    public int lifeGain;
    public int locationGain;

    // constructor
    public Reward(String name, int lifeGain, int locationGain) {
        this.name = name;
        this.lifeGain = lifeGain;
        this.locationGain = locationGain;
    }

    // methods
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