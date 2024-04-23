import java.util.Scanner;

public class Reward {
    // vars
    public String name;
    public int healthGain;
    public int locationGain;

    // constructor
    public Reward(String name, int healthGain, int locationGain) {
        this.name = name;
        this.healthGain = healthGain;
        this.locationGain = locationGain;
    }

    // methods
    public void rewardOptions(Player player) {
        // print reward options
        System.out.println("Type 'life' to gain " + healthGain + " health or type 'move' to advance " + locationGain + " squares.");
        
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
    }

    public void rewardLocation(Player player) {
        // add locationGain to location
        player.location += locationGain;
        System.out.println("You moved " + locationGain + " tiles! You are now at tile " + player.location + ".");
        
        // exit
        Controls Controls = new Controls();
        Controls.drawCard(player);
    }

    public void rewardLife(Player player) {
        player.life += healthGain;
        System.out.println("You gained " + healthGain + " health! You now have " + player.life + " health.");

        // exit
        Controls Controls = new Controls();
        Controls.drawCard(player);
    }
}