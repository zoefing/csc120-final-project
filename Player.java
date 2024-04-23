public class Player {

    // vars
    public String name;
    public int life;
    public int location;
    int bossesKilled = 0;
    int lifeLost = 0;

    // constructor
    public Player(String name, int life, int location) {
        this.name = name;
        this.life = life;
        this.location = location;
    }
}