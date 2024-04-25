import java.util.concurrent.ThreadLocalRandom;

public class Controls {
    public void drawCard(Player player) {
        // draws card in interval
        int cardNum = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("You drew a: " + cardNum);
        player.location += cardNum;
        if (player.location >= 50) {
            player.location = 50;
        }
        else {
            System.out.println("You are currently at square " + player.location);
            betweenLines();
            System.out.println("Input 'draw' to continue, input 'quit' to end game.");
        }
    }

    public void endGame(Player player) {
        // initalize end game
        System.out.println("You are at the end of the board!");
        System.out.println("Game over!");
        // ideally, print achievements here
        if (player.bossesKilled == 0) {
            System.out.println("You killed: " + player.bossesKilled + " bosses. " + "So peaceful!");
        }
        else if (player.bossesKilled == 1) {
            System.out.println("You killed: " + player.bossesKilled + " boss");
        }
        else if (player.bossesKilled > 1) {
            System.out.println("You killed: " + player.bossesKilled + " bosses");
        }
        System.out.println("You lost: " + player.lifeLost + " life");
        // i.e., you beat x bosses, you took x time, you lost x life
    }
    
    public void betweenLines() {
        System.out.println("");
        System.out.println("ʚ𖦹ɞ");
        System.out.println("");
    }
}