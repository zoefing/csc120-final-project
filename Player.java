public class Player {

    // vars
    public String name;
    public int life;
    public int location;
    int locationGained = 0;
    int bossesKilled = 0;
    int bossBattlesAttempted = 0;
    int lifeLost = 0;
    int lifeGained = 0;

    // constructor
    public Player(String name, int life, int location) {
        this.name = name;
        this.life = life;
        this.location = location;
    }
}