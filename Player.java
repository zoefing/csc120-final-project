/*
 * this Player class is used to create the player object
 * this class has vars for the name, health, and location of the player
 * this class also has tracker vars for the locationGained, bossesKilled, bossBattlesAttempted, lifeLost, and lifeGained of the player
 * this class has a constructor that takes in a name, health, and damage
 */
public class Player {

    // vars

    // general vars
    public String name;
    public int life;
    public int location;

    // tracker vars
    int locationGained = 0;
    int bossesKilled = 0;
    int bossBattlesAttempted = 0;
    int lifeLost = 0;
    int lifeGained = 0;

    // constructor
    /*
     * this constructor takes in a name, health, and location
     * @param name the name of the player
     * @param life the health of the player
     * @param location the location of the player
     */
    public Player(String name, int life, int location) {
        this.name = name;
        this.life = life;
        this.location = location;
    }
}